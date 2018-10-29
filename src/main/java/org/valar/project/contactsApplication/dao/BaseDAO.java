package org.valar.project.contactsApplication.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

// This will not work independently so don't put inside IOC container using
// @Repository @Service @Component
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {

	@Autowired
	public void setDataSourceObj(DataSource ds) {
		super.setDataSource(ds);
	}
	
}
