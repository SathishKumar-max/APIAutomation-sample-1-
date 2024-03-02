package com.omrbranch.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	Response response;
	RequestSpecification reqSpec;

	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given();
	}

	public void addPathParameter(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);

	}

	public void addBody(String body) {
		reqSpec = reqSpec.body(body);
	}

	public void addBody(Object body) {
		reqSpec = reqSpec.body(body);
	}

	public Response addReqType(String type, String endpoint) {

		switch (type) {
		case "GET":
			response = reqSpec.get(endpoint);
			break;
		case "POST":
			response = reqSpec.post(endpoint);
			break;
		case "PUT":
			response = reqSpec.put(endpoint);
			break;
		case "PATCH":
			response = reqSpec.patch(endpoint);
			break;
		case "DELETE":
			response = reqSpec.delete(endpoint);
			break;

		default:
			break;
		}
		return response;
	}

	public void addBasicAuth(String username, String password) {

		reqSpec = reqSpec.auth().preemptive().basic(username, password);
	}

	public int getStatusCode(Response response) {

		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public String getResponseBodyAsString() {
		String asString = response.asString();
		return asString;
	}

	public String getResponseBodyAsPrettyString() {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;

	}

	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);

	}

	public static String getProjectPath() {

		return System.getProperty("user.dir");
		
	}

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream(getProjectPath() + "\\PropertyFile\\Config\\config.properties"));
		String value = (String)prop.get(key);   
		return value; 
		
	}
}
