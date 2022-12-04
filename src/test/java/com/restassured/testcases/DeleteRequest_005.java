package com.restassured.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restassured.base.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class DeleteRequest_005 extends Base {
	

	@BeforeClass
	public void setUp() {
		
		logger.info("**********DeleteRequest_005_Started*************");
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		
		httpRequest = RestAssured.given();		
		response = httpRequest.request(Method.DELETE,"/delete/2");
	}
	
	@Test
	public void testStatusCode() {
		
		logger.info("*******Checking_Status_code**********");
		int actualStatusCode = 200;
		int expectedStatusCode = response.getStatusCode();
		assertEquals(actualStatusCode,expectedStatusCode,"Status Code MisMatched");
	}
	
	@Test
	public void testStatusLine() {
		
		logger.info("********Checking_Status_line*********");
		String actualStatusLine ="HTTP/1.1 200 OK";
		String expectedStatusLine = response.getStatusLine();
		assertEquals(actualStatusLine,expectedStatusLine,"Status line mismatched");
	}
	
	@Test
	public void checkResponseBody() {
		
		logger.info("**********Checking_Respponse_Body************");
		String responseBody = response.getBody().asString();
		assertTrue(responseBody!=null);
	}
	
	@Test
	public void checkResponseTime() {
		
		logger.info("**************Checking_Response_Time*************");
		long responseTime = response.getTime();
		assertTrue(responseTime<5000,"Response Time exceeded 2000");
		
	}
	
	@Test
	public void checkServerType() {
		
		logger.info("************Checking_Server_Type***************");
		String expectedServerType = response.getHeader("Server");
		String actualServerType = "nginx";
		assertEquals(expectedServerType,actualServerType,"Mismatched Server Type");
		
	}
	
	@AfterClass
	public void tearDown() {
		logger.info("*******finished_testing*****************");
	}
	

}
