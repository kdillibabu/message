package com.my.mainserver.model;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBclass {
	
	private Statement statement = null;
	private ResultSet resultSet = null;
	private ResultSet res=null;

	Connection conn=null;
	String DB_HOST="jdbc:mysql://localhost:8080/data";
	String USER = "root";
	String PASS = "";
	
	String firstQuery="select * from user_auth";
	
	public void  readDataBase()
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("successfully connected");
		try {
			conn = DriverManager.getConnection(DB_HOST,USER,PASS);
		
			statement = conn.createStatement();
		
			resultSet = statement.executeQuery(firstQuery);
		
			writeResultSet(resultSet);
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void writeResultSet(ResultSet resultSet) throws SQLException
	{
	    
	    while (resultSet.next())
	    {
	      // e.g., resultSet.getSTring(2);
	      //String userId = resultSet.getInt("u_id");
	      String userName = resultSet.getString("u_name");
	      String userImei = resultSet.getString("u_imei");
	      String userPass = resultSet.getString("u_pass");
	      System.out.println("User: " + userName);
	      System.out.println("Imei: " + userImei);
	      System.out.println("pass: " + userPass);
	      
	    }
	  }
	  
	public void validUser(String imei, String password)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			conn = DriverManager.getConnection(DB_HOST,USER,PASS);
		
			statement = conn.createStatement();
		
			res = statement.executeQuery(firstQuery);
			while (res.next())
		    {
				//String imei1=imei.toString();
				//String pass=password.toString();
		     
				String userimei = res.getString("auser_imei");
				String userPass = res.getString("auser_pass");
		      
				if(imei.equals(userimei)&&password.equals(userPass))
				{
		    	  
					System.out.println("login successful");
				}
				else
				{
					System.out.println("wrong user");
				  
				}
		    }
			
		}
	
		catch (SQLException e)
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
}
