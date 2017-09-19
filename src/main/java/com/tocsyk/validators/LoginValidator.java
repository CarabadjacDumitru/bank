package com.tocsyk.validators;

import com.tocsyk.dao.LoginOld.LoginDAO;
import com.tocsyk.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {
    @Autowired
    private LoginDAO loginDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return Login.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Login login = (Login) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (login.getUserName().length() < 6 || login.getUserName().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (loginDAO.findLogin(login.getUserName()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (login.getPassword().length() < 8 || login.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }


    }
}
