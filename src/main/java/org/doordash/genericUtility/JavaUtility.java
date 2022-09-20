package org.doordash.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Random;

import net.bytebuddy.asm.Advice.Return;
import test.junit.testsetup.Data;
/**
 * this class consists all Java reusable actions
 * @author admin
 *
 */
public class JavaUtility {
/**
 * this method is used to generate the random number
 * @param limit
 * @return
 */
	public int getRandomNumber(int limit) {
		return new Random().nextInt(limit);
	}
	/**
	 * this method is used to convert String to any datatype based on Strategy
	 * @param data
	 * @param strategy
	 * @return
	 */
	public Object convertStringIntoAnyDataType(String data,DataType strategy) {
		Object obj=null;
		if(strategy.toString().equalsIgnoreCase("long")) {
			obj=Long.parseLong(data);
		}
		else if(strategy.toString().equalsIgnoreCase("int")) {
			obj=Integer.parseInt(data);
	}
		else if(strategy.toString().equalsIgnoreCase("double")) {
			obj=Double.parseDouble(data);
	
} 
		return obj;
}
	public String currentTime() {
		Data date = new Data();
		SimpleDateFormat sd=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualdata = sd.format(date);
		return actualdata;
	}
}