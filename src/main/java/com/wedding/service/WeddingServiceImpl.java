package com.wedding.service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.spark.network.protocol.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.wedding.dao.FightDao;
import com.wedding.dao.PutDao;
import com.wedding.meta.Attribute;
import com.wedding.meta.Attributes1;
import com.wedding.meta.Demo;


@Service
public class WeddingServiceImpl {
	@Autowired
	private FightDao fightDao;
	@Autowired
	private PutDao putDao;
	@Autowired
	MongoTemplate mongoTemplate;
	public List<Map<String, Object>> getflightdelay() {
		List<Map<String, Object>> ft=fightDao.getflightdelay();
		return ft;
	}
	public Demo putdata(Demo demo) throws SQLException,JsonMappingException {
		demo.setIsDevTenant(demo.getIsDevTenant());
		demo.setMasterCatalogs(demo.getMasterCatalogs());
		
		demo.setDomain(demo.getDomain());
		demo.setOmsMerchantId(demo.getOmsMerchantId());
	
		demo.setName(demo.getName());
	   

	
		return putDao.save(demo);
		
	}
	

}
