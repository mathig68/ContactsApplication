package org.valar.project.contactsApplication.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import org.valar.project.contactsApplication.model.User;

// Row mapper object used to map the results
// one database record to one object
public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserid(rs.getInt("userid"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setPhone(rs.getString("phone"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setUsername(rs.getString("username"));
		user.setLoginStatus(rs.getInt("loginstatus"));
		user.setRole(rs.getInt("role"));
		return user;
	}

}
