package org.valar.project.contactsApplication.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration
@ComponentScan(basePackages="org.valar.project.contactsApplication")
public class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer{

}
