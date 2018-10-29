package org.valar.project.contactsApplication.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import org.valar.project.contactsApplication.model.Contact;

// Creates model object and bind vales from result set
public class ContactRowMapper implements RowMapper<Contact> {

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setContactId(rs.getInt("contactid"));
		contact.setUserId(rs.getInt("userid"));
		contact.setPhone(rs.getString("phone"));
		contact.setName(rs.getString("name"));
		contact.setEmail(rs.getString("email"));
		contact.setAddress(rs.getString("address"));
		contact.setRemark(rs.getString("remark"));
		return contact;
	}

}
