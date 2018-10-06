/*package com.wedding.connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import org.springframework.beans.factory.annotation.Autowired;

import com.wedding.executor.ExecContext;
import com.wedding.meta.Datasource;
import com.wedding.service.WeddingService;


public class MySqlConnector implements IConnector {
	@Autowired
	WeddingService weddingService;
	
	@Override
	public ConnectionHolder getConnection() {
		ConnectionHolder conholder = new ConnectionHolder();
		
		try {
			Datasource datasource =null;
			
			Class.forName(datasource.getDriver());
			Connection con = null;
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + datasource.getHost() + ":" + datasource.getPort()
						+ "/" + datasource.getDbname(), datasource.getUsername(), datasource.getPassword());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Statement stmt = con.createStatement();
			conholder.setType(ExecContext.MYSQL.toString());
			conholder.setStmtObject(stmt);
			conholder.setConObject(con);
		} catch (ClassNotFoundException | SQLException | IllegalArgumentException
				| SecurityException
				| NullPointerException e) {
			e.printStackTrace();
		}
		return conholder;
	}
}*/