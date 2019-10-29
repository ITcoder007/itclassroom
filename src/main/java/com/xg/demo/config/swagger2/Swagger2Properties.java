package com.xg.demo.config.swagger2;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * Swagger2配置
 * 
 * @author chenfanglin
 * @version v1.0.0
 */
@ConfigurationProperties(prefix = Swagger2Properties.SWAGGER2_PREFIX)
@Setter
@Getter
public class Swagger2Properties {

	public static final String SWAGGER2_PREFIX = "spring.swagger2";

	/**
	 * 是否开启swagger
	 */
	private Boolean enabled;

	/**
	 * 文档标题
	 */
	private String title;

	/**
	 * 文档描述
	 */
	private String description;

	/**
	 * 联系人名称
	 */
	private String name;

	/**
	 * 联系人个人站点
	 */
	private String url;

	/**
	 * 联系人邮箱
	 */
	private String email;

	/**
	 * 文档版本
	 */
	private String version;


}