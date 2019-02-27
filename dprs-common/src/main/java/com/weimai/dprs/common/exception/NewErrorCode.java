package com.weimai.dprs.common.exception;

import com.weimai.wmcommon.result.WmResult;


/**
 * 
 * 新标准返回结果
 * Copyright (c) 2017 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 *
 * @author xxx
 * @since 2017年9月11日
 */
public enum NewErrorCode {

	/**
	 * 实例，具体请参考开发标准
	 */
	TEST(1, "test"),
	;

	private int code;
    private String message;

    private NewErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public WmResult getErrorWmResult() {
    	
    	return WmResult.error(this.code, this.message);
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
