package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.payload.address.AddressPayLoad;
import com.omrbranch.payload.searchproduct.SearchProduct;
import com.omrbranch.pojo.address.SearchProduct_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_SearchProductStep extends BaseClass {

	Response response;
	SearchProduct searchProduct = new SearchProduct();

	@Given("User add Headers for to search Product")
	public void user_add_headers_for_to_search_product() {

		List<Header> listHeader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);

		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	}

	@When("User add Request Body for {string}")
	public void user_add_request_body_for(String product) {

		addBody(searchProduct.searchProduct(product));
	}

	@When("User send {string} request for search Product")
	public void user_send_request_for_search_product(String type) {

		response = addReqType(type, EndPoints.SEARCHPRODUCT);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	@Then("User should verify the search Product response message matches {string}")
	public void user_should_verify_the_search_product_response_message_matches(String expResponse) {

		SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);
		String actResponse = searchProduct_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Ok", expResponse, actResponse);
	}

}
