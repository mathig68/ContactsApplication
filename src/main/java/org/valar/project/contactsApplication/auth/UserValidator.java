package org.valar.project.contactsApplication.auth;

import javax.print.attribute.Size2DSyntax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.valar.project.contactsApplication.model.User;
import org.valar.project.contactsApplication.service.UserService;

public class UserValidator implements Validator {

	@Autowired
	private UserService userService;
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {

		User user = (User) o;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if ( user.getLastname().length() < 6 || user.getLastname().length() >32 ) {
			errors.rejectValue("username", "Size.userForm.username");
		}
 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
		
	}

}
