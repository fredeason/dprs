/**
 * myweimai.com Inc.
 * All Rights Reserved.
 * Copyright (c) 2013-2017 .
 */
package com.weimai.dprs.service;


/**
 *
 *
 * Copyright (c) 2017 Choice, Inc.
 * All Rights Reserved.
 * Choice Proprietary and Confidential.
 *
 * @author qianlishui
 * @since 2017年9月14日
 */
public interface LoginService {

	/**  
	 * 患者端app验证码登录
	 * @return
	 */
	public boolean appLoginByCode(String phoneNumber,String code) ;
	
	/**  
	 * 患者端用户名和密码登录
	 * @return
	 */
	public boolean appLoginByPassword();

	/**  
	 * 微信验证码登录
	 * @return
	 */
	public boolean weixinLoginByCode();
	/**  
	 * H5页面验证码登录
	 * @return
	 */
	public boolean pageLoginByCode();


}

