package org.valar.project.contactsApplication.service;

import java.util.List;

import org.valar.project.contactsApplication.model.Contact;

public interface ContactService {
	public Integer save(Contact contact);
	public Integer update(Contact c);
	public Integer delete(Contact c);
	public Integer delete(Integer[] contactId);
	
	/**
	 * Return all the contacts associated with the logged in user 
	 * @userId Logged in user's id
	 */
	public List<Contact> findUserContact(Integer userId);
	/**
	 * Getting contacts associated with user
	 * @param userId
	 * @param txt by given free text
	 * @return
	 */
	public List<Contact> findUserContact(Integer userId, String txt);
	
	
	

}
