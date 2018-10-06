package com.wedding.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.spark.network.protocol.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.wedding.meta.Attribute;
import com.wedding.meta.Attributes1;
import com.wedding.meta.Demo;
import com.wedding.meta.StockData;
import com.wedding.service.DataSourceImpl;
import com.wedding.service.WeddingService;
import com.wedding.service.WeddingServiceImpl;

@Controller
@RequestMapping(value="/wedding")
public class WeddingController {
	
	@Autowired
	WeddingService wedService;
	@Autowired
	WeddingServiceImpl 	weddingServiceImpl;
	@Autowired
	DataSourceImpl datasourceImpl;
	/*@Autowired
	FlightServiceImpl flightService;*/
 	
	@RequestMapping(value="/weddata" ,method= RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> weddata()
	{
		return wedService.weddata();
		
	}
	@RequestMapping(value = "/getTableData", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getTableData() {
		return wedService.getTableData();
	}
	@RequestMapping(value = "/getMySqlData", method = RequestMethod.GET)
	public @ResponseBody List<StockData> getMySqlData() {
		return wedService.getMySqlData();
	}

//	public @ResponseBody List<Datasource> getMySqlData123(@RequestParam("driver") String driver,@RequestParam("host") int host,@RequestParam("dbname") String port,@RequestParam("port") String dbname,@RequestParam("username") String username,@RequestParam("password") String password) {
		//return wedService.getMySqlData123(driver, host, dbname, port, username, password);
	@RequestMapping(value = "/getMySqlData123", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getmysqldata123(@RequestParam("dbName") String dbName,
			@RequestParam("table") String table) throws SQLException 
			{
	
		return datasourceImpl.getmysqldata123(dbName,table);
	}
	@RequestMapping(value = "/getLogin", method = RequestMethod.GET)
	public @ResponseBody String getLogin(@RequestParam("firstName") String firstName,
			@RequestParam("password") String password, HttpServletRequest request) throws JsonProcessingException
	{
		
		return wedService.getLogin(firstName, password);
	}
	@RequestMapping(value = "/getflightdelay", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getflightdelay() throws SQLException
       {	
		return weddingServiceImpl.getflightdelay();
	}
	@RequestMapping(value = "/getCountdelayflight", method = RequestMethod.GET)
	public @ResponseBody List<String> getCountdelayflight(@RequestParam("dbName") String dbName,
			@RequestParam("table") String table) throws SQLException 
			{
	
		return datasourceImpl.getCountdelayflight(dbName,table);
	}
	
	@RequestMapping(value = "/registerFile", method = RequestMethod.GET)
	public @ResponseBody String loadCsv(@RequestParam("csvFileName") String csvFileName,@RequestParam("path")String path,@RequestParam("dbName") String dbName,@RequestParam("table")String table)
			
			throws  IOException, SQLException {
		return datasourceImpl.createAndLoad(path,csvFileName,dbName,table);
	}
	@RequestMapping(value = "/writemongo", method = RequestMethod.GET)
	public @ResponseBody void writemongo(@RequestParam("csvFileName") String csvFileName,@RequestParam("path")String path,@RequestParam("dbName") String dbName,@RequestParam("table")String table)
			
			throws  IOException, SQLException {
		 datasourceImpl.writemongo(path,csvFileName,dbName,table);
	}
	@RequestMapping(value = "/createtable", method = RequestMethod.GET)
	public @ResponseBody String createtable()
			
			throws  IOException, SQLException {
		return datasourceImpl.createtable();
	}
	@RequestMapping(value = "/upload",  headers=("content-type=multipart/*"), method = RequestMethod.POST)
	public  @ResponseBody String upload(@RequestParam("csvFileName") MultipartFile csvFile)
		 throws Exception,FileNotFoundException{
		
		
			return datasourceImpl.upload(csvFile);
		
		
		}
	
	@RequestMapping(value = "/putdata", method = RequestMethod.POST)
	public @ResponseBody Demo putdata( @RequestBody Demo demo ) throws SQLException,JsonMappingException
			{
	
		return weddingServiceImpl.putdata(demo);
	}
}
