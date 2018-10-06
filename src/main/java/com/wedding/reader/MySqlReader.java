/*package com.wedding.reader;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import com.wedding.executor.IExecutor;
import com.wedding.factory.ExecutorFactory;
import com.wedding.meta.Datasource;
import com.wedding.meta.ResultSetHolder;
import com.wedding.meta.Wedding;

public class MySqlReader  implements IReader{
	
	@Autowired
	protected ExecutorFactory execFactory;
	@Override
	public ResultSetHolder read(Wedding dp, Object conObject, Datasource dataSource) throws IOException {
		ResultSetHolder rsHolder = null;
		try {
			Datasource datasource =null;
			IExecutor exec = execFactory.getExecutor(datasource.getDriver()+datasource.getHost()+datasource.getDbname()+datasource.getUsername()+datasource.getPassword());
			String dbName = dataSource.getDbname();		
			rsHolder = exec.executeSql("SELECT * FROM "+dbName);
		} catch (SecurityException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
		return rsHolder;		
	}


}
*/