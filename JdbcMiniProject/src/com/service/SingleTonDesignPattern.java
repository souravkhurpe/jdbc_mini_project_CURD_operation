package com.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleTonDesignPattern {

	public static Connection connection = null;

	private SingleTonDesignPattern() {

	}

	public static Connection getConnection() {

		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher", "root", "root");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return connection;
	}

}
