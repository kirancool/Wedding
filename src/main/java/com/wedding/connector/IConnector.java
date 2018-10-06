package com.wedding.connector;

import java.io.IOException;


public interface IConnector {

	ConnectionHolder getConnection() throws IOException;
}

