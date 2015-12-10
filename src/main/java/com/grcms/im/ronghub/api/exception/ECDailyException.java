package com.grcms.im.ronghub.api.exception;

import com.grcms.core.exception.ECCustomException;

/**
 * ECMember 异常
 * @author Administrator
 *
 */
public class ECDailyException extends ECCustomException {
	/**
	 *
	 */
	private static final long serialVersionUID = 5899388806754727066L;

	public ECDailyException(){}

	public ECDailyException(String message){
		super(message);
	}
}
