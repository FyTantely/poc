package com.poc.api.donnee.dto.commun;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public abstract class BaseDTO {
	private boolean isError = false;
	private boolean isInfo = false;
	private boolean isWarning = false;
	private String uuid;
	private String errorCode = null;
	private String errorMessagedeString = null;
	private String message = null;
	
	public BaseDTO() {
		super();
	}

	public BaseDTO(boolean isError, String errorCode, String errorMessage, String message) {
		super();
		this.isError = isError;
		this.errorCode = errorCode;
		this.errorMessagedeString = errorMessage;
		this.message = message;
	}

	public BaseDTO(boolean isError, boolean isInfo, boolean isWarning, String errorCode, String errorMessage,
                   String message, String uuid) {
		super();
		this.isError = isError;
		this.isInfo = isInfo;
		this.isWarning = isWarning;
		this.errorCode = errorCode;
		this.errorMessagedeString = errorMessage;
		this.message = message;
		this.uuid = uuid;
	}

	public BaseDTO(String uuid, String errorMessage, String message) {
		this.uuid = uuid;
		this.errorMessagedeString = errorMessage;
		this.message = message;
	}
}
