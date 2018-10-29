package org.valar.project.contactsApplication.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = { "org.valar.project.contactsApplication.dao" })
@PropertySource("classpath:config/config.properties")
public class RootConfig {

	@Value("${oracle.drivername}")
	private String drivername;

	@Value("${oracle.url}")
	private String url;

	@Value("${oracle.username}")
	private String username;

	@Value("${oracle.password}")
	private String password;

	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(drivername);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setMaxTotal(2);
		ds.setInitialSize(1);
		// * when the connection is borrowed from the connection pool
		// * connection will be tested
		ds.setTestOnBorrow(true);
		// test the connection
		ds.setValidationQuery("SELECT 1 from dual");
		ds.setDefaultAutoCommit(true);
		return ds;
	}
}
