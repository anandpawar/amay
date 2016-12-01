package com.vc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	public static final synchronized Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Found ....");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found ...." + e);
		}

		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "123";

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, username ,password);
			System.out.println("Connection established successfully .......");
		} catch (SQLException e) {
			System.out.println("Connection failed ......." + e);

		}
		return connection;

	}

	}

