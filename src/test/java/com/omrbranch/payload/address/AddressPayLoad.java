package com.omrbranch.payload.address;

import com.omrbranch.pojo.address.CityList_Input_Pojo;
import com.omrbranch.pojo.address.Delete_Input_Pojo;
import com.omrbranch.pojo.address.UpdateUserAddres_Input_Pojo;
import com.omrbranch.pojo.address.UserAddAdress_Input_Pojo;

public class AddressPayLoad {

	public UserAddAdress_Input_Pojo createAddUserAddress(String first_name, String last_name, String mobile, String apartment,
			Integer state, Integer city, Integer country, String zipcode, String address, String address_type) {

		UserAddAdress_Input_Pojo addAdress_Input_Pojo = new UserAddAdress_Input_Pojo(first_name, last_name, mobile,
				apartment, state, city, country, zipcode, address, address_type);
		return addAdress_Input_Pojo;

	}

	public UpdateUserAddres_Input_Pojo updateAddress(String address_id, String first_name, String last_name, String mobile,
			String apartment, Integer state, Integer city, Integer country, String zipcode, String address,
			String address_type) {

		UpdateUserAddres_Input_Pojo addres_Input_Pojo = new UpdateUserAddres_Input_Pojo(address_id, first_name,
				last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		return addres_Input_Pojo;
	}

	public CityList_Input_Pojo getCityPayload(String state_id) {

		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(state_id);
		return cityList_Input_Pojo;

	}

	public Delete_Input_Pojo deleteAddress(String address_id) {

		Delete_Input_Pojo delete_Input_Pojo = new Delete_Input_Pojo(address_id);
		return delete_Input_Pojo;
	}

}
