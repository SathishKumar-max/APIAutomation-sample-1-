package com.omrbranch.pojo.address;

import java.util.ArrayList;

public class GETUserAddres_Output_Pojo {

	public int status;
	public String message;
	public ArrayList<GetUserAddress> data;

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

	public ArrayList<GetUserAddress> getData() {
		return data;
	}

	public void setData(ArrayList<GetUserAddress> data) {
		this.data = data;
	}

}
