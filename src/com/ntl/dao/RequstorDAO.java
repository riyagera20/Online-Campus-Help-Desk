package com.ntl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RequstorDAO {

	MyConnection mCon;
	Connection myCon;
	
	public RequstorDAO()
	{
		mCon=new MyConnection();
	}
	
	public String checkPasswordChangeStatus(int userId)
	{
		String status="NO";
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select PWDCHANGESTATUS from requestor where REQUESTOR_ID=?");
			pstmt.setInt(1,userId);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			status=rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean checkRequestorCredentials(int userId,String password)
	{
		Boolean isValid=false;
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select * from requestor where REQUESTOR_ID=? and PASSWORD=?");
			pstmt.setInt(1,userId);
			pstmt.setString(2,password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
			isValid=true;
			}else
			{
				isValid=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValid;
	}
	
	public boolean changeRequestorPassword(int userId,String password)
	{
		Boolean cpasswordChanged=false;
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("update requestor set PASSWORD=?,PWDCHANGESTATUS=? where REQUESTOR_ID=?");
			
//			Statement stmt=myCon.createStatement();
//			String query="update Requestor set PASSWORD="+password+",PWDCHANGESTATUS='YES' where REQUESTOR_ID="+userId;
//			stmt.executeUpdate(query);
			pstmt.setString(1,password);
			pstmt.setString(2,"YES");
			pstmt.setInt(3,userId);
			pstmt.executeUpdate();
			cpasswordChanged=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			cpasswordChanged=false;
			e.printStackTrace();
		}
		return cpasswordChanged;
	}
	
	public int checkRequestorEmail(String email)
	{
		int reqId=0;
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select * from requestor where EMAIL=?");
			pstmt.setString(1,email);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
			reqId=rs.getInt(1);
			}else
			{
				reqId=0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reqId;
	}
	
	public String getEmailFromRequestorId(int fId)
	{
		String email="";
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select EMAIL from requestor where REQUESTOR_ID=?");
			pstmt.setInt(1,fId);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			email=rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}
}
