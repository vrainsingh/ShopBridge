package com.shop.bridge.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)	
public class GenericException extends RuntimeException {

	private static final long serialVersionUID = -4829047277065627116L;

	private String message;
	private int statusCode;

}
