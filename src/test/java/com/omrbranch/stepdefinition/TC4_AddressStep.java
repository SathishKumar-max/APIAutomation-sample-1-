package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.EndPoints;
import com.omrbranch.payload.address.AddressPayLoad;
import com.omrbranch.pojo.address.Delete_Output_Pojo;
import com.omrbranch.pojo.address.GETUserAddres_Output_Pojo;
import com.omrbranch.pojo.address.UpdateUserAddres_Output_Pojo;
import com.omrbranch.pojo.address.UserAddAddress_Output_Pojo;

import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClass {

	Response response;
	static String address_id;

	AddressPayLoad addressPayLoad = new AddressPayLoad();

	// UserAddAddress
	@Given("User add Headers and Bearer Authorizatin for accessing address post endpoint")
	public void user_add_headers_and_bearer_authorizatin_for_accessing_address_post_endpoint() {

		List<Header> listHeader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");

		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);

		Headers headers = new Headers(listHeader);
		addHeaders(headers);

	}

	@When("User add request body for new address {string},{string},{string},{string},{int} and {int} and {int},{string},{string} and {string}")
	public void user_add_request_body_for_new_address_and_and_and(String first_name, String last_name, String mobile,
			String apartment, Integer state, Integer city, Integer country, String zipcode, String address,
			String address_type) {

		addBody(addressPayLoad.createAddUserAddress(first_name, last_name, mobile, apartment, state, city, country,
				zipcode, address, address_type));

	}

	@When("User send {string} request for adduserAddress endpoint")
	public void user_send_request_for_adduser_address_endpoint(String type) {

		response = addReqType(type, EndPoints.ADDUSERADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	@Then("User should verify adduserAddress response message matches {string} and save address_id")
	public void user_should_verify_adduser_address_response_message_matches_and_save_address_id(
			String expAdduserAddress) {

		UserAddAddress_Output_Pojo userAddAddress_Output_Pojo = response.as(UserAddAddress_Output_Pojo.class);

		String actMessage = userAddAddress_Output_Pojo.getMessage();
		int addressNum = userAddAddress_Output_Pojo.getAddress_id();
		address_id = String.valueOf(addressNum);
		System.out.println("User Add Adddress Id " + address_id);
		Assert.assertEquals("Verify Address added successfully", expAdduserAddress, actMessage);

	}

	// UPDATEAddress
	@Given("User add Headers and Bearer Authorizatin for accessing address put endpoint")
	public void user_add_headers_and_bearer_authorizatin_for_accessing_address_put_endpoint() {

		List<Header> listHeader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");

		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);

		Headers headers = new Headers(listHeader);
		addHeaders(headers);

	}

	@When("User add request body for update address {string},{string},{string},{string},{string},{int} and {int} and {int},{string},{string} and {string}")
	public void user_add_request_body_for_update_address_and_and_and(String address_id, String first_name,
			String last_name, String mobile, String apartment, Integer state, Integer city, Integer country,
			String zipcode, String address, String address_type) {

		addBody(addressPayLoad.updateAddress(address_id, first_name, last_name, mobile, apartment, state, city, country,
				zipcode, address, address_type));

	}

	@When("User send {string} request for UpdateuserAddress endpoint")
	public void user_send_request_for_updateuser_address_endpoint(String type) {

		response = addReqType(type, EndPoints.UPDATEUSERADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	@Then("User should verify UpdateuserAddress response message matches {string}")
	public void user_should_verify_updateuser_address_response_message_matches(String expUpdateUserAddress) {

		UpdateUserAddres_Output_Pojo updateUserAddres_Output_Pojo = response.as(UpdateUserAddres_Output_Pojo.class);
		String actResponse = updateUserAddres_Output_Pojo.getMessage();
		System.out.println(actResponse);
		String updateAddressId = updateUserAddres_Output_Pojo.getAddress_id();
		System.out.println("Updated User Id " + updateAddressId);

		Assert.assertEquals("Verify Address updated successfully", expUpdateUserAddress, actResponse);

	}

	// GETUserAddress
	@Given("User add Headers and Bearer Authorizatin for accessing address get endpoint")
	public void user_add_headers_and_bearer_authorizatin_for_accessing_address_get_endpoint() {

		List<Header> listHeader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);

		listHeader.add(h1);
		listHeader.add(h2);

		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	}

	@When("User send {string} request for getuserAddress endpoint")
	public void user_send_request_for_getuser_address_endpoint(String type) {

		response = addReqType(type, EndPoints.GETUSERADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	@Then("User should verify adduserAddress response message matches {string}")
	public void user_should_verify_adduser_address_response_message_matches(String expResponse) {

		GETUserAddres_Output_Pojo getUserAddres_Output_Pojo = response.as(GETUserAddres_Output_Pojo.class);
		String actMessage = getUserAddres_Output_Pojo.getMessage();
		System.out.println(actMessage);
		Assert.assertEquals("Verify Ok", expResponse, actMessage);
	}

	// DELETEaddress
	@Given("User add Headers and Bearer Authorizatin for accessing address delete endpoint")
	public void user_add_headers_and_bearer_authorizatin_for_accessing_address_delete_endpoint() {

		List<Header> listHeader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);

		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	}

	@When("User add request body for delete address {string}")
	public void user_add_request_body_for_delete_address(String address_idd) {

		addBody(addressPayLoad.deleteAddress(address_id));

	}

	@When("User send {strin66g} request for deleteuserAddress endpoint")
	public void user_send_request_for_deleteuser_address_endpoint(String type) {

		response = addReqType(type, EndPoints.DELETEUSERADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	@Then("User should verify deleteuserAddress response message matches {string}")
	public void user_should_verify_deleteuser_address_response_message_matches(String expResponse) {

		Delete_Output_Pojo delete_Output_Pojo = response.as(Delete_Output_Pojo.class);
		String actResponse = delete_Output_Pojo.getMessage();
		System.out.println(actResponse);
		Assert.assertEquals("Verify Address deleted successfully", expResponse, actResponse);

	}
}
