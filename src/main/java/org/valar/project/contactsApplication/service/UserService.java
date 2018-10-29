package org.valar.project.contactsApplication.service;

import java.util.List;

import org.valar.project.contactsApplication.exception.UserBlockedException;

import org.valar.project.contactsApplication.model.User;

public interface UserService {

	public static final Integer LOGIN_STATUS_ACTIVE = 1;
	public static final Integer LOGIN_STATUS_BLOCKED = 2;
	
	public static final Integer ROLE_ADMIN = 1;
	public static final Integer ROLE_USER = 2;
	
	
	/*
	 * To register user object
	 */
	public Integer registerUser(User user);
	/*
	 * THis method handles login operations, 
	 * and returns the user object when success and null when failed
	 * @throws When user account is blocked it will throw exception
	 */
	public User login(String loginName, String Password) throws UserBlockedException;
	/*
	 * Provides list of users
	 */
	public List<User> getUserList();
	/*
	 * change login status from active to blocked
	 */
	public void changeLoginStatus(Integer userId, Integer loginStatus);

}
