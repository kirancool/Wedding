package com.wedding.reader;

import java.io.IOException;

import com.wedding.meta.Datasource;
import com.wedding.meta.ResultSetHolder;
import com.wedding.meta.Wedding;

public interface IReader {
	ResultSetHolder read(Wedding dp, Object conObject, Datasource ds) throws IOException;
}
