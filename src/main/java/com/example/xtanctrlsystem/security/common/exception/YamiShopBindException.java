/*
 * Copyright (c) 2018-2999 广州市蓝海创新科技有限公司 All rights reserved.
 *
 * https://www.mall4j.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package com.example.xtanctrlsystem.security.common.exception;


import com.example.xtanctrlsystem.security.common.enums.YamiHttpStatus;
import org.springframework.http.HttpStatus;

public class YamiShopBindException extends RuntimeException{

	/**
	 *
	 */
	private static final long serialVersionUID = -4137688758944857209L;

	/**
	 * http状态码
	 */
	private Integer httpStatusCode;

	private Object object;


	/**
	 * @param yamiHttpStatus http状态码
	 */
	public YamiShopBindException(YamiHttpStatus yamiHttpStatus) {
		super(yamiHttpStatus.getMsg());
		this.httpStatusCode = yamiHttpStatus.value();
	}

	/**
	 * @param yamiHttpStatus http状态码
	 */
	public YamiShopBindException(YamiHttpStatus yamiHttpStatus, String msg) {
		super(msg);
		this.httpStatusCode = yamiHttpStatus.value();
	}


	public YamiShopBindException(String msg) {
		super(msg);
		this.httpStatusCode = HttpStatus.BAD_REQUEST.value();
	}

	public YamiShopBindException(String msg, Object object) {
		super(msg);
		this.httpStatusCode = HttpStatus.BAD_REQUEST.value();
		this.object = object;
	}

	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}

}
