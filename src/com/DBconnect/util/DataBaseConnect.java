package com.DBconnect.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnect {
	private static Connection connection;
	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String user = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/shop";
			connection=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

					
		return connection;
		
	}

}
