package com.restassured.base;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	public static RequestSpecification httpRequest;
	public static Response response;
	
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		logger = LogManager.getLogger("RestAssured");
		Configurator.setLevel(logger.getName(), Level.DEBUG);
		
	}
	
}
