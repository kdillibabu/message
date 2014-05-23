package com.my.mainserver.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class messageDB
{

	private Statement statement = null;
	public ResultSet resultSet = null;
	public ResultSet resultSet1 = null;
	Connection conn=null;
	
	String DB_HOST="jdbc:mysql://localhost:8080/data";
	String USER = "root";
	String PASS = "";
	String firstQuery="select * from user_mess,user_auth";
	
	
	public void Message()
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		try
		{
			conn = DriverManager.getConnection(DB_HOST,USER,PASS);
			statement = conn.createStatement();
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		try {
			resultSet = statement.executeQuery(firstQuery);
			while (resultSet.next())
			{
				String auserimei=resultSet.getString("auser_imei");
				String muserimei=resultSet.getString("muser_imei");
				if(auserimei.equals(muserimei))
				{
				String username = resultSet.getString("auser_name");
				String userMessage = resultSet.getString("muser_mess");
				System.out.println("username:"+username);
				System.out.println("message:"+userMessage);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void writeMessage(String imei, String content)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		try
		{
			conn = DriverManager.getConnection(DB_HOST,USER,PASS);
			statement = conn.createStatement();
			String sql1 = "INSERT INTO user_mess (muser_mess,muser_imei) VALUES ('" + content + "','" + imei +"')";
			statement.executeUpdate(sql1);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}
