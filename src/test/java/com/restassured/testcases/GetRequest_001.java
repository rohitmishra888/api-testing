package com.restassured.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restassured.base.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class GetRequest_001 extends Base {

	@BeforeClass
	public void setUp() {
		
		logger.info("**********GetRequest_001_Started*************");
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		
		httpRequest = RestAssured.given();
		
		response = httpRequest.request(Method.GET,"/employees");
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
	
	@Test
	public void checkContentLength() {
		
		logger.info("***********Checking_Content_Length************");
		String contentLength = response.getHeader("Content-Length");
		assertTrue(Integer.parseInt(contentLength)>100,"Content Length is less than 100");
	}
	
	@Test
	public void checkContentEncoding() {
		
		logger.info("***********Checking_Content_Encoding***********");
		String actualContentEncoding = "gzip";
		String expectedContentEncoding = response.getHeader("Content-Encoding");
		assertEquals(expectedContentEncoding,actualContentEncoding,"Content Encoding Mismatched");
	}
	
	@AfterClass
	public void tearDown() {
		logger.info("*******finished_testing*****************");
	}
	
}
