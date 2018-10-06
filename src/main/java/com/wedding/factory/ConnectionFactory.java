/*package com.wedding.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedding.connector.IConnector;
import com.wedding.connector.MySqlConnector;



@Service
public class ConnectionFactory {


	@Autowired
	MySqlConnector mySqlConnector;

	
	public IConnector getConnector(String connection)
	{
		switch(connection.toLowerCase())
		{
		
		case "mysql": return mySqlConnector;
		
		default:				
		}
		return null;
	}
}*/