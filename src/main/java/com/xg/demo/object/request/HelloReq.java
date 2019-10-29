package com.xg.demo.object.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@ApiModel
public class HelloReq {

	@ApiModelProperty(value = "姓名")
	@NotNull
	private String name;
}
