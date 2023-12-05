package com.example.javadb.params;

public class Parameters {
	// MYSQL
	public static final String MYSQL_DRIVER_NAME="com.mysql.jdbc.Driver";
	// "jdbc:mysql://server_name:3306/db_name","user","passwd";
	public static final String MYSQL_DRIVER_URL="jdbc:mysql://localhost:3306/javafs?user=master&password=ciao%20mondo";

	// MARIADB
	public static final String MARIADB_DRIVER_NAME="org.mariadb.jdbc.Driver";
	// "jdbc:mysql://server_name:3306/db_name","user","passwd";
	public static final String MARIADB_DRIVER_URL="jdbc:mariadb://localhost:3306/javafs?user=master&password=ciao mondo";
}
