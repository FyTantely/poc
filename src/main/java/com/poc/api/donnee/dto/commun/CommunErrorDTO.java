package com.poc.api.donnee.dto.commun;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CommunErrorDTO extends BaseDTO {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String code;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private boolean success;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String precision;
	
	public static final String MSG_SUCCESS_STRING = "Successfully done";
	public static final String MSG_KO_STRING = "KO";
}
