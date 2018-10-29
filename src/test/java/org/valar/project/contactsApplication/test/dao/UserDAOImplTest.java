package org.valar.project.contactsApplication.test.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.valar.project.contactsApplication.config.RootConfig;
import org.valar.project.contactsApplication.dao.UserDAOImpl;
import org.valar.project.contactsApplication.model.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UserDAOImplTest {

	@Autowired
	UserDAOImpl userDao;
	
	/*@Test
	public void testSave() {
		User user = new User("jery", "doe", "jery01", "123", "dianee@gmail.com", "Hicksville,NY", "9808089809", 1, 1);
		assertNotNull(userDao.save(user));
	}*/
	@Test
	public void testLogin() {
		User user = userDao.login("valar08", "123");
		System.out.println("User Object: "+user.toString());
		assertNotNull(userDao.login("valar08", "123"));
	}
/*
	@Test
	public void testUpdate() {
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testDeleteById() {
	}

	@Test
	public void testFindById() {
	}

	@Test
	public void testFindAll() {
	}

	@Test
	public void testFindByProperty() {
	}
*/
}
