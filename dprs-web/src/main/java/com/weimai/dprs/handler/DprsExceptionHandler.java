package com.weimai.dprs.handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weimai.wmcommon.exception.GlobalExceptionHandler;


/**
 *
 *
 * Copyright (c) 2017 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 *
 * @author qianlishui
 * @since 2017年9月15日
 */
@ControllerAdvice
public class DprsExceptionHandler extends GlobalExceptionHandler  {
	private final static Logger logger = LoggerFactory.getLogger(DprsExceptionHandler.class);

	@Resource
	private Environment env;


	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {

//		e.printStackTrace();
		logger.error(e.getMessage());
		
		return this.errorHandler(e);
	}

	

}
