/*package com.wedding.executor;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.wedding.connector.ConnectionHolder;
import com.wedding.connector.IConnector;
import com.wedding.factory.ConnectionFactory;
import com.wedding.meta.ResultSetHolder;


public class MySqlExecutor implements IExecutor {
	@Autowired 
	ConnectionFactory connectionFactory;
	@Override
	public ResultSetHolder executeSql(String sql) throws IOException {
		final Logger logger = Logger.getLogger(MySqlExecutor.class);	
		logger.info(" Inside MySQL executor  for SQL : " + sql);
		ResultSetHolder rsHolder = new ResultSetHolder();
		IConnector connector = connectionFactory.getConnector(ExecContext.MYSQL.toString());
		ConnectionHolder conHolder = connector.getConnection();
		Object obj = conHolder.getStmtObject();
		long countRows = -1L;
		if(obj instanceof Statement)
		{
			Statement stmt = (Statement) conHolder.getStmtObject();
			ResultSet rs = null;
			try {	
				if(sql.toUpperCase().contains("INSERT")) {
					countRows = stmt.executeUpdate(sql);
					//countRows = stmt.executeLargeUpdate(sql); Need to check for the large volume of data.
					rsHolder.setCountRows(countRows);
				} else 
					rs = stmt.executeQuery(sql);
				rsHolder.setResultSet(rs);
			} catch (SQLException e) {				
				e.printStackTrace();
			}			
		}		
		return rsHolder;
	}

}
*/