package cn.hongtianren.entity;

import cn.hongtianren.util.Constant;

public class ApiResponse {

	public static final ApiResponse SUCCESS = new ApiResponse(Constant.SUCCESS_CODE, Constant.SUCCESS_MSG);
	public static final ApiResponse PARAMETER = new ApiResponse(Constant.PARAMETER_CODE, Constant.PARAMETER_MSG);
	private String code;
	private String message;

	private ApiResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public static ApiResponse result(String code, String message) {
		return new ApiResponse(code, message);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
