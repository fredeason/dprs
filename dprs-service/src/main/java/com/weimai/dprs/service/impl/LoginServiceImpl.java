package com.weimai.dprs.service.impl;

import org.springframework.stereotype.Service;

import com.weimai.dprs.service.LoginService;

/**
 *
 *
 * Copyright (c) 2017 Choice, Inc. All Rights Reserved. Choice Proprietary and
 * Confidential.
 *
 * @author qianlishui
 * @since 2017年9月14日
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

	/*@Resource
	private PtgyWeimaihaoDao ptgyWeimaihaoDao;*/

	@Override
	public boolean appLoginByCode(String phoneNumber,String code) {
		// TODO Auto-generated method stub
//		ptgyWeimaihaoDao.selectByShoujihao(phoneNumber);
		
		//省略后续逻辑,代码重构中
		
		return false;
	}

	@Override
	public boolean appLoginByPassword() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean weixinLoginByCode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pageLoginByCode() {
		// TODO Auto-generated method stub
		return false;
	}

}
