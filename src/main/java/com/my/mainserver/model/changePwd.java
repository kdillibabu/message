package com.my.mainserver.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class changePwd {
	private Statement statement = null;
	private ResultSet resultSet = null;
	private ResultSet res=null;

	Connection conn=null;
	String DB_HOST="jdbc:mysql://localhost:8080/data";
	String USER = "root";
	String PASS = "";
	

	public void change(String oldpwd,String imei, String newpwd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(DB_HOST,USER,PASS);
			statement = conn.createStatement();
			String sql1="UPDATE user_auth SET auser_pass='" + newpwd + "' WHERE auser_imei='" + imei + "'";
			String sql2="SELECT auser_pass FROM user_auth WHERE auser_imei='" + imei + "'";
			resultSet=statement.executeQuery(sql2);
			while(resultSet.next())
			{
			      String userpass = resultSet.getString("auser_pass");
			      if(userpass.equals(oldpwd))
			      {
						statement.executeUpdate(sql1);
						System.out.println("updated!!!:)");

			      }
			      else
			      {
			    	  System.out.println("wrong password!!!:(");
			      }

			}
		
			
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
