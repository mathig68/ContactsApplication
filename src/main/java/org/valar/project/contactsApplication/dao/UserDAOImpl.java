package org.valar.project.contactsApplication.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.valar.project.contactsApplication.model.User;
import org.valar.project.contactsApplication.rowMapper.UserRowMapper;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	@Override
	public Integer save(User user) {
		String sql = "INSERT INTO user_details(firstname, lastname, password, loginstatus, phone, email, address, role, username)"
				+ " VALUES (:firstname, :lastname, :password, :loginstatus, :phone, :email, :address, :role, :username)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("firstname", user.getFirstname());
		paramMap.put("lastname", user.getLastname());
		paramMap.put("password", user.getPassword());
		paramMap.put("loginstatus", user.getLoginStatus());
		paramMap.put("phone", user.getPhone());
		paramMap.put("email", user.getEmail());
		paramMap.put("address", user.getAddress());
		paramMap.put("role", user.getRole());
		paramMap.put("username", user.getUsername());

		// Auto incremented values will present in the keyHolder
		KeyHolder kh = new GeneratedKeyHolder();

		// Source of the values for NamedParameter
		// MapSqlParameterSource is for map based implementation
		SqlParameterSource ps = new MapSqlParameterSource(paramMap);

		try {
			super.getNamedParameterJdbcTemplate().update(sql, ps, kh, new String[] { "userid" });
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
		Integer userId = kh.getKey().intValue();
		user.setUserid(userId);
		return userId;
	}

	public User login(String username, String password) {
		User user = new User();
		String sql = "SELECT userid, firstname, lastname, username, phone, email, address, role, loginstatus"
				+ " FROM user_details WHERE username=:username AND password=:password";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("username", username);
		paramMap.put("password", password);

		try {
			// User user = getNamedParameterJdbcTemplate().queryForObject(sql, ps, new
			// UserRowMapper());
			user = getNamedParameterJdbcTemplate().queryForObject(sql, paramMap, new UserRowMapper());
			System.out.println("User Object : " + user.toString());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			throw e;
		}
		return user;
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE user_details" + " SET firstname = :firstname," + " lastname = :lastname,"
				+ " loginstatus = :loginstatus," + " phone = :phone," + " email = :email," + " address = :address,"
				+ " role = :role" + " WHERE userid = :userid";

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("firstname", user.getFirstname());
		paramMap.put("lastname", user.getLastname());
		paramMap.put("loginstatus", user.getLoginStatus());
		paramMap.put("phone", user.getPhone());
		paramMap.put("email", user.getEmail());
		paramMap.put("address", user.getAddress());
		paramMap.put("role", user.getRole());
		paramMap.put("userid", user.getUserid());

		SqlParameterSource ps = new MapSqlParameterSource(paramMap);

		try {
			super.getNamedParameterJdbcTemplate().update(sql, ps);
		} catch (DataAccessException e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public int delete(User user) {
		return this.deleteById(user.getUserid());
	}

	@Override
	public int deleteById(Integer userid) {
		String sql = "DELETE FROM user_details WHERE userid=?";
		return getJdbcTemplate().update(sql, userid);
	}

	@Override
	public User findById(Integer userid) {
		String sql = "SELECT userid, username, phone, email, address, loginname, loginstatus, role "
				+ "FROM user_details WHERE userid=?";
		// This method match the query object to UserRowMapper object
		User user = getJdbcTemplate().queryForObject(sql, new UserRowMapper(), new Object[] { userid });
		return user;
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT userid, username, phone, email, address, loginname, loginstatus, role "
				+ " FROM user_details";
		List<User> userList = new ArrayList<User>();
		userList = getJdbcTemplate().query(sql, new UserRowMapper());
		return userList;
	}

	// Find values by property and property value
	@Override
	public List<User> findByProperty(String propName, Object value) {
		String sql = "SELECT userid, username, phone, email, address, loginname, loginstatus, role "
				+ "FROM user_details WHERE " + propName + "=?";

		return getJdbcTemplate().query(sql, new UserRowMapper(), value);
	}

}
