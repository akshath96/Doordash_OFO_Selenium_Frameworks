package org.doorDash.home;

import org.doordash.genericUtility.BaseClass;
import org.doordash.genericUtility.ListenerImplementataion;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenshotPractice extends BaseClass{

@Test
public void screenShot()throws Throwable{
    ListenerImplementataion.stest.assignAuthor("akshatha");
    ListenerImplementataion.stest.assignCategory("smoke");
    ListenerImplementataion.stest.info("Browser launched successfuly");
    //ListenerImplementataion.stest.assignAuthor("");
    
      Assert.fail();
}
}