package com.omrbranch.pojo.address;

import java.util.ArrayList;

public class SearchProduct_Output_Pojo {

	private int status;
	private String message;
	private ArrayList<searchProduct> data;
	private String currency;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<searchProduct> getData() {
		return data;
	}

	public void setData(ArrayList<searchProduct> data) {
		this.data = data;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
