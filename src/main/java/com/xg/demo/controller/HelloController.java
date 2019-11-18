package com.xg.demo.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xg.demo.aspect.LogBeforeHandle;
import com.xg.demo.object.WrapperResponse;
import com.xg.demo.object.request.HelloReq;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "demo")
public class HelloController {

	@GetMapping("/hello/bean")
	@ApiOperation("")
	public String ghello(@Valid HelloReq req) {
		return "hello world!" + req.getName();
	}

	@GetMapping("/hello/apiparam")
	@ApiOperation("")
	public String ghello2(@ApiParam("名称")@RequestParam("name") String name) {
		return "hello world!" + name;
	}

	@GetMapping("/hello/{name}")
	@ApiOperation("")
	public String ghello(@PathVariable(value = "name") String name) {
		return "hello world!" + name;
	}

	@PostMapping("/hello/post")
	@LogBeforeHandle
	@ApiOperation("")
	public WrapperResponse<String> phello(@Valid @RequestBody HelloReq req) {
		final String greetings = "hello world!" + req.getName();
		return new WrapperResponse<String>(greetings);
	}
}
