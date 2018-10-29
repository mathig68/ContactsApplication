package org.valar.project.contactsApplication.exception;

public class UserBlockedException extends RuntimeException{

	/*
	 * Create User object with out error description
	 */
	public UserBlockedException() {}
	/*
	 * Created user object with error description
	 */
	public UserBlockedException(String errDesc) {}
}
