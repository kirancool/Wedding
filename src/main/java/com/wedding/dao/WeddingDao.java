package com.wedding.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.wedding.meta.Wedding;

public interface WeddingDao extends MongoRepository<Wedding,String> {
	@Query(value="{}")
	public List<Wedding> findAll();	

}
