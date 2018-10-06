package com.wedding.meta;

public class Tab {

	String dbName;
	String table;
	public Tab(String dbName,String table) {
		this.dbName=dbName;
		this.table=table;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
}
