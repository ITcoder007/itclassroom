package com.xg.demo.object;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@ApiModel
public final class WrapperResponse<T> implements Serializable {

	private static final long serialVersionUID = -9105315405259128875L;

	@ApiModelProperty("返回码")
	private Integer errcode = ResponseErrorCodeEnum.SUCCESS.getCode();

	@ApiModelProperty("返回信息")
	private String msg = ResponseErrorCodeEnum.SUCCESS.getMessage();

	@ApiModelProperty("数据")
	private T data;

	/**
	 * 正常结果 构造函数（无数据）
	 */
	public WrapperResponse() {
	}

	/**
	 * 正常结果 构造函数（有数据）
	 * @param data
	 */
	public WrapperResponse(T data) {
		this.data = data;
	}

	/**
	 * 异常结果 构造函数
	 * @param errcode
	 * @param msg
	 */
	public WrapperResponse(Integer errcode, String msg) {
		this.errcode = errcode;
		this.msg = msg;
	}
	
	/**
	 * 异常结果 构造函数
	 * @param responseErrorCodeEnum
	 */
	public WrapperResponse(ResponseErrorCodeEnum responseErrorCodeEnum) {
		this.errcode = responseErrorCodeEnum.getCode();
		this.msg = responseErrorCodeEnum.getMessage();
	}
	
	/**
	 * 通用构造器
	 * @param code
	 * @param msg
	 * @param data
	 */
	public WrapperResponse(Integer errcode, String msg, T data) {
		this.errcode = errcode;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 通用构造器
	 * @param responseErrorCodeEnum
	 * @param data
	 */
	public WrapperResponse(ResponseErrorCodeEnum responseErrorCodeEnum, T data) {
		this.errcode = responseErrorCodeEnum.getCode();
		this.msg = responseErrorCodeEnum.getMessage();
		this.data = data;
	}
}
