package org.doorDash.home;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase {
	static Connection connection=null;
public static void main(String[] args) throws SQLException {
	Driver dbdriver=new Driver();
	DriverManager.registerDriver(dbdriver);
	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root","root");
	try {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select* from doordash;");
		while(result.next()) {
       System.out.println(result.getString("user_name"));
      }}
		finally { 
		connection.close();
		}
	
	
	
	/*DataBaseUtility dataBaseUtility=new DataBaseUtility();
	dataBaseUtility.openDBConnection("jdbc:mysql://localhost:3306/tyss","root","root");
	List<String> list = dataBaseUtility.getDataFromDatabase("select* from doordash;", "user_name");
	System.out.println(list);
	dataBaseUtility.closeDB();*/
	}
	
}

