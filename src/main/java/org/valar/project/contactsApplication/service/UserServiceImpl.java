package org.valar.project.contactsApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.valar.project.contactsApplication.dao.BaseDAO;
import org.valar.project.contactsApplication.dao.UserDAOImpl;
import org.valar.project.contactsApplication.exception.UserBlockedException;

import org.valar.project.contactsApplication.model.User;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {

	@Autowired
	private UserDAOImpl userDAo;
	
	@Override
	public Integer registerUser(User user) {
		System.out.println("User Object inside DAO : " + user.toString());
		return userDAo.save(user);
	}

	@Override
	public User login(String username, String password) throws UserBlockedException {
		
		User user = userDAo.login(username, password);
		if(user.getLoginStatus().equals(LOGIN_STATUS_BLOCKED)) {
			throw new UserBlockedException("User has been blocked. Please contact Admin");
		}
		return user;
	}

	@Override
	public List<User> getUserList() {
		return null;
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
	}

}
