package com.xg.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class LogAspect {
	
	@Pointcut("@annotation(com.xg.demo.aspect.LogBeforeHandle)")
	public void rule() {
	}

	@Before("rule()")
	public void doBefore(JoinPoint joinPoint) {
		// [{"companyId":585862873129979900,"contentId":636583088411013100}]
        Object[] args = joinPoint.getArgs();
        JSONObject json = JSON.parseObject( JSON.toJSONString( args[0]) );
        
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        log.info("declaringTypeName is {} , arg is {}" , declaringTypeName , json.toString());
        
	}
}
