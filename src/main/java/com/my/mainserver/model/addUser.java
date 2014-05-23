package com.my.mainserver.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class addUser {

	private Statement statement = null;
	public ResultSet resultSet = null;
	public int resultSet1;
	Connection conn=null;
	
	String DB_HOST="jdbc:mysql://localhost:8080/data";
	String USER = "root";
	String PASS = "";
	String sql1="select * from user_auth";
	String sql2 = "INSERT INTO user_auth (auser_name,auser_imei,auser_pass) VALUES (?,?,?)";
	
	
	public void checkUser(String imei)
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
			resultSet = statement.executeQuery(sql1);

			while (resultSet.next())
			{
				String duserimei=resultSet.getString("auser_imei");
				String guserimei=imei;
				if(duserimei.equals(guserimei))
				{
				System.out.println("existing user");
				}
				else
				{
					 PreparedStatement pstmt1 = conn.prepareStatement(sql2);
					 pstmt1.setString(2, imei);
					 pstmt1.setString(1, "unknown");
					 pstmt1.setString(3, "[)!N|=S[-]");
					 pstmt1.executeUpdate();
					 System.out.println("successful");


				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void justCheck(String imei)
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
			resultSet = statement.executeQuery(sql1);

			while (resultSet.next())
			{
				
						String onlyimei=resultSet.getString("auser_imei");
				
						if((onlyimei.equals(imei)) && !(resultSet.last()))
						{
					
							System.out.println("your have logged in!!!!!!");
							String name=resultSet.getString("auser_name");
							String pass=resultSet.getString("auser_pass");
							
							if((name.equals("unknown")) || (pass.equals("[)!N|=S[-]")) )
							{
								System.out.println("need to update your profile");
							}
						}
						else 
						{
							if(onlyimei.equals(imei))
							{
						
								System.out.println("your have logged in!!!!!!");
								String name=resultSet.getString("auser_name");
								String pass=resultSet.getString("auser_pass");
								
								if((name.equals("unknown")) || (pass.equals("[)!N|=S[-]")) )
								{
									System.out.println("need to update your profile");
								}
							}
							else
							{
								System.out.println("wrong user..check whether your friend added you");

							}
								
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
