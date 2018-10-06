package com.wedding.meta;

import java.sql.ResultSet;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;



public class ResultSetHolder {
	
	private ResultSet resultSet;
	private Dataset<Row> dataFrame;
	public ResultSet getResultSet() {
		return resultSet;
	}
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	public Dataset<Row> getDataFrame() {
		return dataFrame;
	}
	public void setDataFrame(Dataset<Row> dataFrame) {
		this.dataFrame = dataFrame;
	}
	public long getCountRows() {
		return countRows;
	}
	public void setCountRows(long countRows) {
		this.countRows = countRows;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	private long countRows;
	private String tableName;

}
