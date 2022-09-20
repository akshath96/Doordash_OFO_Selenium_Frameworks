package org.doorDash.home;

import java.sql.SQLException;

import org.doordash.genericUtility.DataBaseUtility;
import org.doordash.genericUtility.IConstantPath;

public class VerifyDataFromDataBase {
public static void main(String[] args) throws SQLException {
	DataBaseUtility databaseutility = new DataBaseUtility();
	databaseutility.openDBConnection(IConstantPath.DB_URL, "root", "root");
	boolean status = databaseutility.verifyDataIntoDataBase("select* from doordash;", "user_name","rammesh");
	System.out.println(status);
}
}
