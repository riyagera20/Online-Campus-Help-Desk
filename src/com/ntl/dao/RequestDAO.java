package com.ntl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ntl.model.Facilities;
import com.ntl.model.Request;

public class RequestDAO {

	MyConnection mCon;
	Connection myCon;
	
	public RequestDAO()
	{
		mCon=new MyConnection();
	}
	
	public ArrayList<Facilities> getFacilities()
	{
		ArrayList<Facilities> facilities=new ArrayList<>();
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select * from facilities");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Facilities facility=new Facilities();
				facility.setFacilityId(rs.getString(1));
				facility.setFacilityname(rs.getString(2));
				facility.setFacilityDescription(rs.getString(3));
				facilities.add(facility);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facilities;
	}
	
	public boolean createRequest(Request userRequest)
	{
		Boolean requestedCreated=false;
		myCon=mCon.getMyConnection();
		try
		{
			PreparedStatement pstmt=myCon.prepareStatement("insert into request(REQUESTOR_ID,FACILITY_ID,REQUEST,REQUEST_DATE,SEVERIETY) values (?,?,?,?,?)");
			pstmt.setInt(1,userRequest.getRequestorId());
			pstmt.setString(2,userRequest.getFacilityId());
			pstmt.setString(3,userRequest.getRequest());
			pstmt.setDate(4,new java.sql.Date(userRequest.getRequestDate().getTime()));
			pstmt.setString(5,userRequest.getSeveriety());
			pstmt.executeUpdate();
			requestedCreated=true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			requestedCreated=false;
			e.printStackTrace();
		}
		return requestedCreated;
	}
	
	public ArrayList<Request> getRequestById(int requestorId)
	{
		ArrayList<Request> requests=new ArrayList<>();
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select * from request where REQUESTOR_ID=? order by REQUEST_ID desc");
			pstmt.setString(1,String.valueOf(requestorId));
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Request request=new Request();
				request.setRequestId(rs.getInt(1));
				request.setRequestorId(Integer.parseInt(rs.getString(2)));
				request.setFacilityId(rs.getString(3));
				request.setRequest(rs.getString(4));
				request.setRequestDate(rs.getDate(5));
				request.setResponse(rs.getString(6));
				request.setStatus(rs.getString(7));
				request.setAssigneeId(rs.getString(8));
				request.setSeveriety(rs.getString(9));
				requests.add(request);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requests;
	}
	
	public boolean deleteRequest(int requestId)
	{
		boolean deleted=false;
		myCon=mCon.getMyConnection();
		try
		{
			PreparedStatement pstmt=myCon.prepareStatement("update request set STATUS='Closed' where REQUEST_ID=?");
			pstmt.setInt(1,requestId);
			pstmt.executeUpdate();
			deleted=true;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			deleted=false;
			e.printStackTrace();
		}
		return deleted;
	}
	

	public ArrayList<Request> getRequestByFacId(String facId)
	{
		ArrayList<Request> requests=new ArrayList<>();
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select * from request where FACILITY_ID=? order by REQUEST_ID desc");
			pstmt.setString(1,facId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Request request=new Request();
				request.setRequestId(rs.getInt(1));
				request.setRequestorId(Integer.parseInt(rs.getString(2)));
				request.setFacilityId(rs.getString(3));
				request.setRequest(rs.getString(4));
				request.setRequestDate(rs.getDate(5));
				request.setResponse(rs.getString(6));
				request.setStatus(rs.getString(7));
				request.setAssigneeId(rs.getString(8));
				request.setSeveriety(rs.getString(9));
				requests.add(request);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requests;
	}
	
	public boolean addAssigneeToRequest(int requestId,int assigneeId)
	{
		boolean updated=false;
		myCon=mCon.getMyConnection();
		try
		{
			PreparedStatement pstmt=myCon.prepareStatement("update request set STATUS='Assigned',ASSIGNEE_ID=? where REQUEST_ID=?");
			pstmt.setString(1,String.valueOf(assigneeId));
			pstmt.setInt(2,requestId);
			pstmt.executeUpdate();
			updated=true;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			updated=false;
			e.printStackTrace();
		}
		return updated;
	}
	
	public ArrayList<Request> getRequestByAssId(String assId)
	{
		ArrayList<Request> requests=new ArrayList<>();
		myCon=mCon.getMyConnection();
		try {
			PreparedStatement pstmt=myCon.prepareStatement("select * from request where ASSIGNEE_ID=? order by REQUEST_ID desc");
			pstmt.setString(1,assId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Request request=new Request();
				request.setRequestId(rs.getInt(1));
				request.setRequestorId(Integer.parseInt(rs.getString(2)));
				request.setFacilityId(rs.getString(3));
				request.setRequest(rs.getString(4));
				request.setRequestDate(rs.getDate(5));
				request.setResponse(rs.getString(6));
				request.setStatus(rs.getString(7));
				request.setAssigneeId(rs.getString(8));
				request.setSeveriety(rs.getString(9));
				requests.add(request);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requests;
	}
	
	public boolean addResponseToRequest(int requestId,String res)
	{
		boolean deleted=false;
		myCon=mCon.getMyConnection();
		try
		{
			PreparedStatement pstmt=myCon.prepareStatement("update request set RESPONSE=? where REQUEST_ID=?");
			pstmt.setString(1,res);
			pstmt.setInt(2,requestId);
			pstmt.executeUpdate();
			deleted=true;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			deleted=false;
			e.printStackTrace();
		}
		return deleted;
	}
}
