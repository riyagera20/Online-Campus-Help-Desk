package com.ntl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacilityHeadDAO {

	MyConnection mCon;
	Connection myCon;
	
	public FacilityHeadDAO() {
		super();
		mCon=new MyConnection();
	}
	
	public boolean checkFacilityHeadCredentials(int userId,String password)
	{
		Boolean isValid=false;
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select * from facilityhead where FACILITYHEADID=? and PASSWORD=?");
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
	
	public String checkPasswordChangeStatus(int userId)
	{
		String status="NO";
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select PASSWORDCHANGESTATUS from facilityhead where FACILITYHEADID=?");
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
	
	public boolean changeFacilityHeadPassword(int userId,String password)
	{
		Boolean cpasswordChanged=false;
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("update facilityhead set PASSWORD=?,PASSWORDCHANGESTATUS=? where FACILITYHEADID=?");
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
	
	public int checkFacilityHeadEmail(String email)
	{
		int reqId=0;
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select * from facilityhead where EMAIL=?");
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
	
	public String getEmailFromFacilityId(String fId)
	{
		String email="";
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select EMAIL from facilityhead where FACILITYID=?");
			pstmt.setString(1,fId);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			email=rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}
	
	public String getFacilityIdForFacilityHead(int fId)
	{
		String facId="";
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select FACILITYID from facilityhead where FACILITYHEADID=?");
			pstmt.setInt(1,fId);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			facId=rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facId;
	}
}
