package com.optimus.genericUtils;

import static io.restassured.RestAssured.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class BaseClass {

	public DataBaseUtility dbLib = new DataBaseUtility();
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID = "7"; //hard corded
	public Logger logger;
    
	 @BeforeClass
	 public void setup() 
	 {   baseURI="https://dummy.restapiexample.com";
		 logger = Logger.getLogger("Optimus"); //Added Logger
		 PropertyConfigurator.configure("Log4j2.properties");
		 logger.setLevel(Level.DEBUG);
	 }			
}
