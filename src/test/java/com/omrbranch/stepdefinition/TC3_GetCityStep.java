package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.payload.address.AddressPayLoad;
import com.omrbranch.pojo.address.CityList;
import com.omrbranch.pojo.address.City_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC3_GetCityStep extends BaseClass{

	static AddressPayLoad addressPayload = new AddressPayLoad();
	Response response;
	

	@Given("User add header for to get CityList")
	public void user_add_header_for_to_get_city_list() {
		
		List<Header> listheader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h3 = new Header("Content-Type", "application/json");
		listheader.add(h1);
		listheader.add(h3);
		Headers headers = new Headers(listheader);
		addHeaders(headers);
	}	
	
	@When("User add request body stateid for get CityList")
	public void user_add_request_body_stateid_for_get_city_list() {
		addBody(addressPayload.getCityPayload(TC1_LoginStep.globalDatas.getStateIdText()));
		
	}
	@When("User Send {string} request for CityList endpoint")
	public void user_send_request_for_city_list_endpoint(String type) {
		 response = addReqType(type, EndPoints.CITYLIST);
			int statusCode = getStatusCode(response);
			System.out.println(statusCode);
			 TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	   
	}
	@Then("User should verify the cityList response message matches {string} and saved cityId")
	public void user_should_verify_the_city_list_response_message_matches_and_saved_city_id(String cityname) {
		
		City_Output_Pojo cityList_output_pojo  =  response.as(City_Output_Pojo.class);
		
		ArrayList<CityList> citylist = cityList_output_pojo.getData();
		for (CityList eachcitylist : citylist) {
			String eachcityname = eachcitylist.getName();
			if (eachcityname.equals(cityname)) {
				int cityid = eachcitylist.getId();
				TC1_LoginStep.globalDatas.setCityIdNum(cityid);
				System.out.println(cityid);
				Assert.assertEquals("Verify the Cityid",cityid, 4440);
				break;
			}
		}
	}

}