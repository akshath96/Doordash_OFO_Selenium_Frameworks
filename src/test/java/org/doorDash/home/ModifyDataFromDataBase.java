package org.doorDash.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataFromDataBase {
public static void main(String[] args) throws SQLException {
	
Driver dbdriver=new Driver();
DriverManager.registerDriver(dbdriver);
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root","root");
try {
	Statement statement = connection.createStatement();
	int result = statement.executeUpdate("insert into sdet40 values(1005,'Suraj',453675,'tumkur');");
	System.out.println(result+"Data updated successfully");
}
 finally {
	 connection.close();
	 
	 System.out.println("Connection closed successfully");
 }
}


}
