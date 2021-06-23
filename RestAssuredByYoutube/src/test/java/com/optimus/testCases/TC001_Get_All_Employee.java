package com.optimus.testCases;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.optimus.genericUtils.BaseClass;
import com.optimus.genericUtils.IEndPoints;


public class TC001_Get_All_Employee extends BaseClass {

	@BeforeClass
	void getAllEmployees() {
		logger.info("**********Sarted TC001_Get_All_Employees*********");
		response=given().get(IEndPoints.GET_ALL_EMPLOYEE);
	}
	
	@Test
	void checkResponseBody() {
		logger.info("********** Checking Response Body *********");
		String resBody = response.getBody().prettyPrint();
		logger.info("Response Body ==>"+resBody);
		Assert.assertTrue(resBody != null);
	}
	
	@Test
	void CheckingStatusCode() {
		logger.info("********** Checking Response Code *********");
		int statuscode = response.statusCode();
		logger.info("Response Body ==>"+statuscode);
        Assert.assertEquals(statuscode,200);
	}
	
	@Test
	void checkResponseTime() {
		logger.info("********** Checking Response Time *********");
		long resTime= response.getTime();
		logger.info("Response Time ==>"+resTime);
		if(resTime>2000) {
			logger.warn("Response Time is Greater than 2000");
		
		}
		Assert.assertTrue(resTime<10000);
	}
	
	@Test
	void checkContentType() {
		logger.info("********** Checking Content Type *********");
		String contentType = response.getHeader("Content-Type");
		logger.info("Content type is ==>"+contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}
	
	@Test 
	void checkserverType(){
		logger.info("********** Checking Server Type *********");
		String serverType = response.getHeader("Server");
		logger.info("server type is ==>"+serverType);
		Assert.assertEquals(serverType, "cloudflare");
	}
	@Test
	void checkContentLength() {
		logger.info("********** Checking Content length *********");
		String contentLenth = response.header("Content-Length");
		logger.info("Content length is ==>"+contentLenth);
		if(Integer.parseInt(contentLenth)<100) {
			logger.warn("content length is less than 100");
		}
		Assert.assertTrue(Integer.parseInt(contentLenth)>100);
		
	}
	@Test
	void checkCookies() {
		logger.info("********** Checking cookies *********");
		String cookie=response.getCookie("PHPSESSID");
		logger.info("cokiies value " +cookie);
		Assert.assertTrue(cookie != null);
	}
	
	@AfterClass
	void tearDown() {
		logger.info("********** finished TC001 TestCase *********");
		logger.info("----------------------------------------------------------------");
	}
}
