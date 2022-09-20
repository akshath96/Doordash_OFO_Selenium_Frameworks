package org.doordash.genericUtility;
/**
 * this interface consists all the external file paths
 * @author admin
 *
 */
public interface IConstantPath {

	String PROJECT_PATH=System.getProperty("user.dir");
    String EXCEL_PATH=PROJECT_PATH+"/src/test/resources/TestData.xlsx";
	String PROPERTY_FILE_PATH=PROJECT_PATH+"/src/test/resources/CommonData.Properties";
	String DB_URL="jdbc:mysql://localhost:3306/tyss";
}
