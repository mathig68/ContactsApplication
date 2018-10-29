package org.valar.project.contactsApplication.dao;

import java.util.List;

import org.valar.project.contactsApplication.model.Contact;

public interface ContactDAo {

	public Integer save(Contact contact);
	
	public Integer update(Contact contact);

	public int delete(Contact contact);

	public int deleteById(Integer contactId);

	public Contact findById(Integer contactId);

	public List<Contact> findAll();

	public List<Contact> findByProperty(String propName, Object value);

}
