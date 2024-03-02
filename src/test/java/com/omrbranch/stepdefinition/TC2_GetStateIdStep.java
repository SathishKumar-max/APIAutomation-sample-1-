package com.omrbranch.stepdefinition;

import java.util.ArrayList;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.pojo.address.StateList;
import com.omrbranch.pojo.address.StateList_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC2_GetStateIdStep extends BaseClass{

	Response response;
	
	@Given("User add Headers for to stateList")
	public void user_add_headers_for_to_state_list() {
		
		addHeader("accept", "application/json");
		
	}

	@When("User send {string} request for the stateList")
	public void user_send_request_for_the_state_list(String type) {
		
		response  = addReqType(type, EndPoints.STATELIST);
		int statusCode = getStatusCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
		
	}

	@Then("User should verify the stateList response message matches {string} and saved stateId")
	public void user_should_verify_the_state_list_response_message_matches_and_saved_state_id(String stateName) {


		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);
		
		ArrayList<com.omrbranch.pojo.address.StateList> stateList = stateList_Output_Pojo.getData();

		for (StateList eachStateList2 : stateList) {
			String eachStateName = eachStateList2.getName();
			if (eachStateName.equals(stateName)) {
				int stateIdNum = eachStateList2.getId();
				TC1_LoginStep.globalDatas.setStateIdNum(stateIdNum);
				String stateId = String.valueOf(stateIdNum);
				TC1_LoginStep.globalDatas.setStateIdText(stateId);
				System.out.println(stateIdNum);

				//Assert.assertEquals(stateIdNum, 35, "verify State Id");
				org.junit.Assert.assertEquals("verify State of TN", stateIdNum, 35);
				break;
			}

		}

		
	}

}