package org.doordash.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpementation implements IRetryAnalyzer{
   int count=0;
   int maxReties=4;
@Override
public boolean retry(ITestResult result) {
	if(count<maxReties) {
		count++;
	}
	return false;

	
}
}
