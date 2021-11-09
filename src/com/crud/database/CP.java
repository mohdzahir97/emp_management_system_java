package com.crud.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	
	static Connection con;
	public static Connection conProvider() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String uname="root";
			String upass="8600";
			String url="jdbc:mysql://localhost:3308/employee_db?autoReconnect=true&useSSL=false";
			
			con=DriverManager.getConnection(url,uname,upass);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return con;
	}
}



