package com.shop.bridge.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericResponse {

	private String status;
	private int statusCode;
	private String message;
	private Object obj;

	public GenericResponse(Object obj) {

		this.status = "success";
		this.statusCode = 200;
		this.message = "success";
		this.obj = obj;
	}

	public GenericResponse(String message, int statusCode) {

		this.status = "failed";
		this.statusCode = statusCode;
		this.message = message;
	}

}
