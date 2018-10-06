package com.wedding.executor;

import java.io.IOException;

import com.wedding.meta.ResultSetHolder;



public interface IExecutor {

	ResultSetHolder executeSql(String sql) throws IOException;
}