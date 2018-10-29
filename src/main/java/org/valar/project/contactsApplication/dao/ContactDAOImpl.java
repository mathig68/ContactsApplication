package org.valar.project.contactsApplication.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import org.valar.project.contactsApplication.model.Contact;
import org.valar.project.contactsApplication.rowMapper.ContactRowMapper;

@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAo {

	@Override
	public Integer save(Contact contact) {
		
		String sql = "INSERT INTO contact_details(userid, phone, name, email, address, remark) "
				+ "VALUES (:userid, :phone, :name, :email, :address, :remark)";
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userid", contact.getUserId());
		paramMap.put("phone", contact.getPhone());
		paramMap.put("name", contact.getName());
		paramMap.put("email", contact.getEmail());
		paramMap.put("address", contact.getAddress());
		paramMap.put("remark", contact.getRemark());

		SqlParameterSource ps = new MapSqlParameterSource(paramMap);

		KeyHolder kh = new GeneratedKeyHolder();
		try {
			super.getNamedParameterJdbcTemplate().update(sql, ps, kh, new String[] {"contactid"});
			Integer contactid = kh.getKey().intValue();
			contact.setContactId(contactid);
			return contactid;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public int delete(Contact contact) {
		return this.deleteById(contact.getContactId());
	}

	@Override
	public int deleteById(Integer contactId) {
		String sql = "DELETE FROM contact_details WHERE contactid = ?";
		try {
			return getJdbcTemplate().update(sql, contactId);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Contact findById(Integer contactId) {
		Contact contact = new Contact();
		String sql = "SELECT contactid, userid, phone, name, email, address, remark "
				+ " FROM contact_details WHERE contactid =?";
		try {
			contact = getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), contactId);
			return contact;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Contact> findAll() {
		List<Contact> contactList = new ArrayList<>();
		String sql = "SELECT contactid, userid, phone, name, email, address, remark FROM contact_details";
		try {
			contactList = getJdbcTemplate().query(sql, new ContactRowMapper());
			return contactList;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Contact> findByProperty(String propName, Object value) {
		System.out.println(propName + "---" + value);
		List<Contact> contactList = new ArrayList<>();
		String sql = "SELECT contactid, userid, phone, name, email, address, remark " + "FROM contact_details WHERE "
				+ propName + " =?";
		try{
			contactList = getJdbcTemplate().query(sql, new ContactRowMapper(), value);
			System.out.println(contactList.size());
			return contactList;
		} catch(DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Integer update(Contact contact) {
		return null;
	}

}
