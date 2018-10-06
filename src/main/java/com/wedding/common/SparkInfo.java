package com.wedding.common;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.spark.SparkConf;
import org.springframework.stereotype.Component;

import com.wedding.executor.ExecContext;

@Component
public class SparkInfo {
	private Properties prop;

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public SparkConf getSparkConfiguration()
	{
		SparkConf sparkConf=new SparkConf();
		Map<String,String> sparkProps= new HashMap<String,String>();
		try
		{
			String key;
			String value;
			String sparkkey = null;
			String sparkvalue = null;
			Enumeration<?> e=prop.propertyNames();
			while(e.hasMoreElements())
			{
				key=(String) e.nextElement();
				value=prop.getProperty(key);
				if(key.contains(ExecContext.spark.toString()))
				{
					sparkProps.put(key, value);
				}
			}
			for(int i=0;i<sparkProps.size();i++)
			{
				for(Map.Entry<String, String> ent:sparkProps.entrySet())
				{
					sparkkey=ent.getKey().toString();
					sparkvalue=ent.getValue().toString();
					sparkConf.set(sparkkey, sparkvalue);
				}
			}
		}finally
		{
			
		}
		return sparkConf;
		
	}
}
