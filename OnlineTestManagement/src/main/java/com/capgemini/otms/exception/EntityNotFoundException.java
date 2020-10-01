package com.capgemini.otms.exception;
/**
 * 
 * Entity notfound experience
 *
 */

public class EntityNotFoundException extends RuntimeException {
	
	public EntityNotFoundException(String msg) {
		super(msg);
	}

}
