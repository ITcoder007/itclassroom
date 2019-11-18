package com.xg.demo.object;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ResponseErrorCodeEnum {
	SUCCESS(Integer.valueOf(0), "SUCCESS", "成功"),

	SYSTEM_ERR(Integer.valueOf(1), "SYSTEM_ERR", "系统异常"),

	UNKNOWN_ERR(Integer.valueOf(-1), "UNKNOWN_ERR", "未知错误"),

	PARAMETER_ERR(Integer.valueOf(41001), "PARAMETER_ERR", "入参错误"),

	PARAMETER_NULL_ERR(Integer.valueOf(41002), "PARAMETER_NULL_ERR", "参数为空"),

	PARAMETER_MISSING_ERR(Integer.valueOf(41003), "PARAMETER_MISSING_ERR", "参数缺失"),

	DB_CONNECT_ERR(Integer.valueOf(43001), "DB_CONNECT_ERR", "数据库连接异常"),

	NO_RECORD_ERR(Integer.valueOf(43002), "NO_RECORD_ERR", "没有查询到相关记录");

	private Integer code;
	
	private String name;

	private String message;

	private ResponseErrorCodeEnum(Integer code, String name, String message) {
		this.code = code;
		this.name = name;
		this.message = message;
	}

	public static boolean contains(Integer code) throws NullPointerException {
		if (null == code) {
			throw new NullPointerException("constant code is null");
		}

		for (ResponseErrorCodeEnum eum : values()) {
			if (code.equals(eum.getCode())) {
				return true;
			}
		}
		return false;
	}

	public static ResponseErrorCodeEnum valueOf(Integer code)
			throws NullPointerException, EnumConstantNotPresentException {
		if (null == code) {
			throw new NullPointerException("constant code is null");
		}
		for (ResponseErrorCodeEnum responseErrorCodeEnum : values()) {
			if (code.equals(responseErrorCodeEnum.getCode())) {
				return responseErrorCodeEnum;
			}
		}
		throw new EnumConstantNotPresentException(ResponseErrorCodeEnum.class, code.toString());
	}
}
