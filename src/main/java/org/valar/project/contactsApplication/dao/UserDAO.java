package org.valar.project.contactsApplication.dao;

import java.sql.SQLException;
import java.util.List;

import org.valar.project.contactsApplication.model.User;

public interface UserDAO {

	public Integer save(User user);

	public void update(User user);

	public int delete(User user);

	public int deleteById(Integer userId);

	public User findById(Integer userId) throws SQLException;

	public List<User> findAll();

	public List<User> findByProperty(String propName, Object value);

}
