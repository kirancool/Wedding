package com.wedding.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.wedding.meta.Datasource;



public interface IDataSourceDao extends MongoRepository<Datasource, String>{
	@Query(value="{'type' :?0,'dbname' :?1,'host' :?2}")
	//public List<Datasource>  findDatasourceByParms(String driver,int host,String dbname,int port,String username,String password);

	//public Datasource findDatasourceByParms(String driver, int host, String dbname, String port, String username,	String password);

	//public List<Datasource> findDatasourceByParms(String driver, String dbname, int host, String port, String username,			String password);	
//	public List<Datasource> findData(String driver,String host,String dbname,int port,String username,String password);

	public List<Datasource> findDatasourceByParms(String type, String dbname, String host);
}
