package com.omrbranch.payload.searchproduct;

import com.omrbranch.pojo.address.SearchProduct_Input_Pojo;

public class SearchProduct {

	public SearchProduct_Input_Pojo searchProduct(String text) {

		SearchProduct_Input_Pojo input_Pojo = new SearchProduct_Input_Pojo(text);
		return input_Pojo;
	}
}
