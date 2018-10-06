package com.wedding.service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import com.wedding.common.HDFSInfo;

import scala.collection.Iterator;
import scala.collection.Seq;


@Service
public class DataSourceImpl {
	@Autowired
	SparkSession sparkSession;
	
	@Autowired
	MongoTemplate mongoTemplate;

	private DataSource dataSource;
	@Autowired
	HDFSInfo hdfsInfo;
	 @Autowired
	 public void setDataSource(DataSource dataSource) {
	  this.dataSource = dataSource;
	 }
	


	public List<Map<String, Object>> getmysqldata123(String dbName,String table) throws SQLException  {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
	Dataset<Row> sq=sparkSession.read().jdbc("jdbc:mysql://localhost:3306"+"/",dbName+"."+table, prop);
		 List<Map<String, Object>> stockList2 = new ArrayList<Map<String, Object>>();
		  Row[] dataRows = (Row[]) sq.collect();
		 
		  String[] columns = sq.columns();
		 
		    for (Row row : dataRows) {
		    		    		
		    	Map<String, Object> object= new HashMap<String, Object>();
		          
		        	   for(String column : columns)
		        	   {
		        		 
		        		   object.put(column, row.getAs(column));
		        		  
		        
		        	   }
		    
		        	   stockList2.add(object);
		    }

		return stockList2;
	}
		
		
	



	public List<String> getCountdelayflight(String dbName, String table) {
	
		    
		    return null;
		}



	public String createAndLoad(String path,String csvFileName,String dbName,String table) throws SQLException {
	
 java.sql.Connection con = dataSource.getConnection();
			     
   java.sql.Statement stmt;
		  try {
		        stmt = con.createStatement();
		     String sql = ("LOAD DATA Local INFILE '"+path+"/"+csvFileName+"'"+ " INTO TABLE "+" "+dbName+"."+ table+" "+"FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' IGNORE 1 ROWS");
             System.out.println(sql);
		      stmt.execute("LOAD DATA LOCAL INFILE '"+path+"/"+csvFileName+"'"+"INTO TABLE"+" " +dbName+"."+ table+" "+"FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' IGNORE 1 ROWS");
               con.close();
              } catch (SQLException e) 
	          {
	           	e.printStackTrace();
	           }
			return csvFileName;
		                
		               
				
	
	}



	public void writemongo(String path, String csvFileName, String dbName, String table) {
		String command = " --db "+dbName+"--collection"+table +"--type csv"+"--headerline"+"--file "+path +"/" +csvFileName ;
		mongoTemplate.insert(command);;
	}





	public String createtable() throws SQLException {
	
	
			Dataset<Row> df = sparkSession.sqlContext().read().format("jdbc")
				.option("Schema", "true")
			    .option("header", "true")
			    .option("url","jdbc:mysql://localhost:3306/kiran")
			    .option("driver", "com.mysql.jdbc.Driver")
			    .option("dbtable","branch")
			    .option("user", "root")
			    .option("password", "root")
			    .load("C:\\Users\\Kiran\\Desktop\\branch.csv");
			/*StructType st = df.schema();
			Seq<StructField> seqFields = st.thisCollection();
			Iterator<StructField> iter = st.iterator();
			
			int i = 0;			
			while (iter.hasNext()) {
				StructField sf = iter.next();
				System.out.println(sf);
			}*/
				return null;
	}


	public String upload(MultipartFile csvFile)	throws Exception,FileNotFoundException {
		String csvFileName = csvFile.getOriginalFilename();
	
		/*	//patern matching for csv filename
			Pattern p = Pattern.compile("[ !@#$%&*()+=|<>?{}\\[\\]~-]");
			Matcher match = p.matcher(csvFileName);
			boolean z = match.find();			
			if (z == true || csvFileName.contains(" ")) 
				throw new Exception("CSV file name contains white space or special character");*/
			
			String uploadPath = hdfsInfo.getHdfsURL()+hdfsInfo.getSchemaPath() +"/UploadData/"+ csvFileName+'"';
			
			// Copy file to server location
			File file = new File(uploadPath);
			csvFile.transferTo(file);
		 
				return csvFileName;
	}
	}
