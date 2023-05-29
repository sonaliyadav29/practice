package com.mphasis.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//db Conn - 1. driver 2. url 3. username 4. password 
public class dbUtil {
private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
//by using jdbc driver - connect to mysql which is a local dB server on the port of 3306 which has db1 as dB
private static final String DB_URL="jdbc:mysql://localhost:3306/db1";
private static final String USERNAME="root";
private static final String PASSWORD="Sona@1234";

public static Connection getConn() throws ClassNotFoundException, SQLException {
	//register the driver 
	Class.forName(DRIVER_CLASS);
	//connection with the dB
	Connection con=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
	return con;
}

	
}

