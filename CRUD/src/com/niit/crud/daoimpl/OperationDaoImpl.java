package com.niit.crud.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.niit.crud.dao.OperationFunction;
import com.niit.crud.util.JDBCUtil;

public class OperationDaoImpl implements OperationFunction

{

	public static void productcreate() {
		Connection mysqlcon = null;
		try {

			Scanner sc = new Scanner(System.in);
			mysqlcon = com.niit.crud.util.JDBCUtil.getMysqlConenction();

			// Bulk Operations
			PreparedStatement pstmt = mysqlcon.prepareStatement("insert into product values(?,?,?)");

			String decider = null;

			do {

				System.out.println("enter  ProductID***");
				int p_Id = sc.nextInt();
				System.out.println("enter  ProductName***");
				String p_name = sc.next();
				System.out.println("enter  Product Price***");
				int p_price = sc.nextInt();

				pstmt.setInt(1, p_Id);
				pstmt.setString(2, p_name);
				pstmt.setInt(3, p_price);

				pstmt.executeUpdate();

				System.out.println("Do you wish to contine y/n ");
				decider = sc.next();

			} while (decider.equalsIgnoreCase("y"));

			System.out.println("Done*****");

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			JDBCUtil.closeMysqlConenction(mysqlcon);
		}

	}

	public static void productupdate() {

		try {

			Connection mysqlcon = JDBCUtil.getMysqlConenction();
			Scanner sc = new Scanner(System.in);

			Statement stmt = mysqlcon.createStatement();
			
			
			PreparedStatement pstmt = mysqlcon.prepareStatement("select * from product where p_Id=?");
			System.out.println("enter the p_Id");
			int p_id = sc.nextInt();


			String sql = "UPDATE  PRODUCT SET    WHERE p_Id=?";

			int number_rows_affected = stmt.executeUpdate(sql);

			System.out.println("number_rows_affected=" + number_rows_affected);
			System.out.println("Updated****");

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void productread() {

		Connection mysqlcon = null;
		try {

			mysqlcon = com.niit.crud.util.JDBCUtil.getMysqlConenction();
			Scanner sc = new Scanner(System.in);

			PreparedStatement pstmt = mysqlcon.prepareStatement("select * from product where p_Id=?");
			System.out.println("enter the p_Id");
			int p_id = sc.nextInt();

			pstmt.setInt(1, p_id);

			ResultSet result = pstmt.executeQuery();

			while (result.next()) {

				System.out.println(result.getString(1) + "\t" + result.getString(2) + "\t" + result.getInt(3));

			}

		}

		catch (Exception e) {

		}
	}

	public static void productdelete() {
		try {
			Connection mysqlcon = JDBCUtil.getMysqlConenction();

			Scanner sc = new Scanner(System.in);

			PreparedStatement pstmt = mysqlcon.prepareStatement("select * from product where p_Id=?");
			System.out.println("enter the p_Id");
			int p_id = sc.nextInt();

			String sql = "DELETE FROM  STUDENT  WHERE st_Id=?";

			int number_rows_affected = pstmt.executeUpdate(sql);

			System.out.println("number_rows_affected=" + number_rows_affected);
			System.out.println("Updated****");

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
