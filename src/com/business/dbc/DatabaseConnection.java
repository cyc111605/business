package com.business.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static final String DBDRIVER="com.mysql.jdbc.Driver";
	private static final String DBURL="jdbc:mysql://localhost:3306/cs20";
	private static final String DBUSER="root";
	private static final String DBPASS="cyc19981025cyc";
	private Connection conn;
	public DatabaseConnection()throws Exception{
		Class.forName(DBDRIVER);
		this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
	}
	public Connection getConnection(){
		return this.conn;
	}
	public void close() throws Exception{
		if(this.conn!=null){
			try{
				this.conn.close();
			}catch(Exception e){
				throw e;
			}
		}
	}
}
