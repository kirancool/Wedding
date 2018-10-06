package com.wedding.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Repository;
@Repository("fightDao")
public class FightDaoImpl implements FightDao{
	
	public List<Map<String, Object>> getflightdelay() {
		SparkSession ssc = SparkSession.builder().master("local").appName("test").getOrCreate();
		
		/*Properties properties = new Properties();
        properties.put("driver", "com.mysql.jdbc.Driver");
        properties.put("dbtable","filghts");
        properties.put("user", "root");
        properties.put("password", "root");*/
		
       // Dataset<Row> sql1 = ssc.read().jdbc("jdbc:mysql://localhost:3306/kiran","flights", properties);
		
        Dataset<Row> sql1 = ssc.read().format("Jdbc").option("url","jdbc:mysql://localhost:3306/kiran").option("driver", "com.mysql.jdbc.Driver").option("dbtable","flights").option("user", "root").option("password", "root").load();
               
        sql1.sqlContext().sql("select AIRLINE_DELAY from flights.ORIGIN_AIRPORT limit 10").collect(); 
        List<Map<String, Object>> fight = new ArrayList<Map<String, Object>>();

		 
		  Row[] dataRows = (Row[]) sql1.collect();
		 
		  String[] columns = sql1.columns();
		 
		    for (Row row : dataRows) {
		    		    		
		    	Map<String, Object> object= new HashMap<String, Object>();
		          
		        	   for(String column : columns)
		        	   {
		        		 
		        		   object.put(column, row.getAs(column));
		        		  
		        
		                 }
		        	   fight.add(object);
		        	   
		      //     }
		    }
		    
	
		return fight;
		
			 
		  

	}
	
}
