package com.wedding.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mongodb.spark.MongoSpark;
import com.wedding.dao.WeddingDao;
import com.wedding.meta.StockData;


@SuppressWarnings("serial")
@Service
public class WeddingService implements java.io.Serializable {
	@Autowired
	WeddingDao weddingDao;
	
	@Autowired
	SparkSession sparkSession;
	@Autowired
	LoginServiceImpl loginServiceImpl;
	@Autowired
	MongoTemplate mongoTemplate;
	public JdbcTemplate jdbcTemplate;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	
	 @Autowired
	 public void setDataSource(DataSource dataSource) {
	  this.dataSource = dataSource;
	 }
	
	@SuppressWarnings("static-access")
	public List<Map<String, Object>> weddata() {
		 sparkSession.builder()
			      .config("spark.mongodb.input.uri", "mongodb://localhost:27017/kiran.stockdata")
			      .config("spark.mongodb.output.uri", "mongodb://localhost:27017/kiran.stockdata")
			      .getOrCreate();
		JavaSparkContext jsc = new JavaSparkContext(sparkSession.sparkContext());
		Dataset<Row> sql1 = MongoSpark.load(jsc).toDF();
		sql1.createOrReplaceTempView("characters");
		Dataset<Row> sql11 =sparkSession.sql("SELECT * FROM characters");
		List<Map<String, Object>> stockList = new ArrayList<Map<String,Object>>();

		 
		  Row[] dataRows = (Row[]) sql11.collect();
		 
		  String[] columns = sql11.columns();
		 
		    for (Row row : dataRows) {
		    		    		
		    	Map<String, Object> object= new HashMap<String, Object>();
		          
		        	   for(String column : columns)
		        	   {
		        		 
		        		   object.put(column, row.getAs(column));
		        		  
		        
		                 }
		        	   stockList.add(object);
		    }
		    
			return stockList;
	

		
		
	/*	return weddingDao.findAll();*/
		/*Query query=new Query();
		List<Wedding> user=mongoTemplate.find(query, Wedding.class);	
		return user;
		*/
	}


	public List<Map<String, Object>> getTableData(){
		 Dataset<Row> sql =sparkSession.read().format("CSV").option("header","true").load("C:\\Users\\Kiran\\Desktop\\stockdata.csv");
		// sql.write().parquet("C:\\Users\\Kiran\\Desktop\\stockdata.parquet");
	List<Map<String, Object>> stockList = new ArrayList<Map<String,Object>>();

		 
		  Row[] dataRows = (Row[]) sql.collect();
		 
		  String[] columns = sql.columns();
		 
		    for (Row row : dataRows) {
		    		    		
		    	Map<String, Object> object= new HashMap<String, Object>();
		          
		        	   for(String column : columns)
		        	   {
		        		 
		        		   object.put(column, row.getAs(column));
		        		  
		        
		                 }
		        	   stockList.add(object);
		    }
		    
			return stockList;
		
			
	}



	public List<StockData> getMySqlData() {
		 List<StockData> employees = null ;
		try {
		employees = jdbcTemplate.query("SELECT * FROM stockdata",new BeanPropertyRowMapper<StockData>(StockData.class));   
		  } catch (DataAccessException e) {
		   e.printStackTrace();
		  }
		return employees;		
			 
	}




	public String getLogin(String firstName, String password) throws JsonProcessingException {
		
		String result = null;
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		result = ow.writeValueAsString(loginServiceImpl.findLatestByUsername(firstName,password));
		return result;
	
	}


/*
	public List<Datasource> getMySqlData123(String driver, int host, String dbname, String port, String username,
			String password) {
		return iDataSourceDao.findDatasourceByParms(driver,dbname,host,port,username,password);
	}*/

	
}
