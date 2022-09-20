package testNgTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class practice1Test {
	
	
	
   @BeforeSuite
   public void  suiteSetUp() {
	   System.out.println("testsuite");
   }
   @BeforeTest
   public void testSetup() {
	   System.out.println("testtest");
   }
   @BeforeClass
   public void  classSetUp() {
	   System.out.println("testclass");
   
}
   @BeforeMethod
   public void  MethodSetUp() {
	   System.out.println("testmethod");
   }
   
   
@Test
public void stepTest() {
	System.out.println("script1");
}
@AfterMethod
public void  MethodTearDown() {
	   System.out.println("aftertestmethod");
}
@AfterClass
public void  classTearDown() {
	   System.out.println("aftertestclass");

}
@AfterTest
public void testTearDown() {
	System.out.println("aftertesttest");
}
@AfterSuite
public void  suiteTearDown() {
	   System.out.println("aftertestsuite");
}
}