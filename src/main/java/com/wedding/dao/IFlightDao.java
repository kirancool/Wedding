package com.wedding.dao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.mongodb.DB;

public interface IFlightDao extends MongoRepository<DB,String>{
	@Query(value="{ 'dbName' : ?0 ,'table' : ?1 }")
	public String findCountOnCountry(String dbName,String table);

}
