package com.ntl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ntl.model.Assignee;
import com.ntl.model.Request;

public class AssigneeDAO {

	MyConnection mCon;
	Connection myCon;
	
	public AssigneeDAO() {
		super();
		mCon=new MyConnection();
	}
	
	public ArrayList<Assignee> getAssigneeByFacId(String facId)
	{
		ArrayList<Assignee> assignees=new ArrayList<>();
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select * from assignee where FACILITY_ID=?");
			pstmt.setString(1,facId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Assignee assignee=new Assignee();
				assignee.setAssigneeId(rs.getInt(1));
				assignee.setAssigneeName(rs.getString(2));
				assignee.setFacilityId(rs.getString(3));
				assignee.setDesignation(rs.getString(4));
				assignee.setQualification(rs.getString(5));
				assignee.setPhone(rs.getString(6));
				assignee.setEmail(rs.getString(7));
				assignees.add(assignee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return assignees;
	}
	
	public boolean checkAssigneeCredentials(int userId,String password)
	{
		Boolean isValid=false;
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select * from assignee where AssigneeId=? and password=?");
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
			PreparedStatement pstmt=myCon.prepareStatement("select passwordChangeStatus from Assignee where AssigneeId=?");
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
	
	public String getEmailFromAssigneeId(int assigneeId)
	{
		String email="";
		myCon=mCon.getMyConnection();
		try
		{
			PreparedStatement pstmt=myCon.prepareStatement("select email from assignee where AssigneeId=?");
			pstmt.setInt(1,assigneeId);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			email=rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}
	
	public boolean changeAssigneePassword(int userId,String password)
	{
		Boolean cpasswordChanged=false;
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("update Assignee set PASSWORD=?,passwordChangeStatus=? where AssigneeId=?");
			
		
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
	
	public int checkAssigneeEmail(String email)
	{
		int assgId=0;
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select * from Assignee where Email=?");
			pstmt.setString(1,email);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
		      assgId=rs.getInt(1);
			}else
			{
				assgId=0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return assgId;
	}

	
	
}
