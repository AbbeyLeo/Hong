package com.hong.util;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBTool {
	
	private static String driver;
	private static String Url;
	private static String username;
	private static String password;
	
	static
	{
		Properties Prop = new Properties();
		Reader In;
		try {
			In = new FileReader("src\\config.properties");
			Prop.load(In);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver = Prop.getProperty("driver");
		Url = Prop.getProperty("Url");
		username = Prop.getProperty("username");
		password = Prop.getProperty("password");
	}
	public static Connection Connect()
	{
		
		
		
		
		try {
			Class.forName(driver);
			return DriverManager.getConnection(Url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void Close(Connection c)
	{
		if(c != null)
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}