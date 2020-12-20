package com.ntl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	Connection con;
	public Connection getMyConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://ayush-rds.cvx7zapvwiwi.us-east-2.rds.amazonaws.com:3306/onlinehelpdesk","rootroot","rootroot");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinehelpdesk","root","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
