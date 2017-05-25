package com.niit.crud.util;


import java.sql.Connection;

import java.sql.DriverManager;

public class JDBCUtil {

	static Connection conn = null;
	static {

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static Connection getMysqlConenction() throws Exception {

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "");

		return conn;

	}

	public static Connection getOracleConenction() {

		return null;

	}

	public static void closeMysqlConenction(Connection conn) {

		try {

			if (conn != null) {

				conn.close();
				System.out.println("connection closed***");

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}