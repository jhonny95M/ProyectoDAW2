package com.cibertec.response;

import lombok.Data;

@Data
public class OkResponse {
	private String message;
public OkResponse(String message) {
	this.message=message;
}
public OkResponse() {}
}
