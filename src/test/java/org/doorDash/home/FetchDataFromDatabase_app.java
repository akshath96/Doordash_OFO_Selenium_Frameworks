package org.doorDash.home;

import java.sql.SQLException;
import java.util.List;

import org.doordash.genericUtility.DataBaseUtility;
import org.doordash.genericUtility.IConstantPath;

public class FetchDataFromDatabase_app {
 public static void main(String[] args) throws SQLException {
	DataBaseUtility databaseutility = new DataBaseUtility();
	databaseutility.openDBConnection(IConstantPath.DB_URL,"root","root"); 
	List<String> data = databaseutility.getDataFromDatabase("select * from doordash;","user_name");
	List<String> data1 = databaseutility.getDataFromDatabase("select * from doordash;","user_name");
	List<String> data2 = databaseutility.getDataFromDatabase("select * from doordash;","user_name");
	
	System.out.println(data);
	System.out.println(data1);
	System.out.println(data2);
	databaseutility.closeDB();
}
}
