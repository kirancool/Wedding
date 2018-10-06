package com.wedding.dao;

import java.sql.SQLException;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.wedding.meta.Demo;

public interface PutDao extends  MongoRepository<Demo,String> {

   @Query(value="{}")
	
	public Demo putdata() throws SQLException;
}
