package com.optimus.genericUtils;

import java.util.Date;
import java.util.Random;
/**
 * This class used for java utility methods
 * @author vikra
 *
 */
public class JavaUtility {
/**
 * it generate random numbe rang 1 to 1000
 * @return String 
 */
	public static String getRandomData() {
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;
	}
	/**
	 * generates current system date
	 * @author rohit
	 * @return current date
	 */
	public static String getCurrentSystemDate() {
		Date date=new Date();
		String currentDate=date.toString();
		return currentDate;
	}
}
