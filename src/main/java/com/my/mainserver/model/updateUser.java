package com.my.mainserver.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class updateUser {
	private Statement statement = null;
	//private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	Connection conn=null;
	String DB_HOST="jdbc:mysql://localhost:8080/data";
	String USER = "root";
	String PASS = "";
	String sql1="select * from user_auth";


	public void updateUserProfile(String imei,String name, String password)
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
			String sql3="UPDATE user_auth SET auser_name='" + name + "', auser_pass='" + password + "' WHERE auser_imei='" + imei + "'"; 
		
			resultSet=statement.executeQuery(sql1);
			
			while(resultSet.next())
			{
			
				String uname=resultSet.getString("auser_name");
				String upass=resultSet.getString("auser_pass");
				String oimei=resultSet.getString("auser_imei");
		
				if((uname.equals("unknown") || upass.equals("[)!N|=S[-]")) && (oimei.equals(imei)))
				{
					statement.executeUpdate(sql3);
					System.out.println("profile updated");
				}
				else
					System.out.println("your profile has been already updated");
			}
		}
		catch(SQLException sq)
		{
			sq.printStackTrace();
		}


		
	}
}
