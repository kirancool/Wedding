package com.wedding.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import org.springframework.stereotype.Repository;

import com.wedding.meta.User;
@Repository
public interface IUserDao extends MongoRepository<User, String>  {
	@Query(value="{ 'firstName' : ?0 , 'password' : ?1 }")
	public User findLatestByUsername(String firstName, String password);
	}


