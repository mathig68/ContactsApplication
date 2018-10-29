package org.valar.project.contactsApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.valar.project.contactsApplication.dao.BaseDAO;
import org.valar.project.contactsApplication.dao.ContactDAo;
import org.valar.project.contactsApplication.model.Contact;
import org.valar.project.contactsApplication.rowMapper.ContactRowMapper;
import org.valar.project.contactsApplication.util.StringUtil;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {

	@Autowired
	private ContactDAo contactDao;
	
	@Override
	public Integer save(Contact contact) {
		return contactDao.save(contact);
	}

	@Override
	public Integer update(Contact contact) {
		return contactDao.update(contact);
	}

	@Override
	public Integer delete(Contact contact) {
		return contactDao.delete(contact);
	}

	@Override
	public Integer delete(Integer[] contactIds) {
		String contactIdString = StringUtil.toCommaSeparatedString(contactIds);
		String sql = "DELETE FROM contact_details WHERE contactid IN("+contactIdString+") ";
		return getJdbcTemplate().update(sql);
		}

	@Override
	public List<Contact> findUserContact(Integer userId, String txt) {
		String sql = "SELECT contactid, userid, phone, name, email, address, remark "
				+ " FROM contact_details WHERE contactid =? AND "
				+ "(name LIKE '%"+txt+"%' "
				+ "OR phone LIKE '%"+txt+"%' "
				+ "OR address LIKE '%"+txt+"%' "
				+ "OR email LIKE '%"+txt+"%' "
				+ "OR remark LIKE '%"+txt+"%')";
		return getJdbcTemplate().query(sql, new ContactRowMapper(), userId);
	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		return contactDao.findByProperty("userid", userId);
	}

}
