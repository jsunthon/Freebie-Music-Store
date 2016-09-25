package springmusic.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import springmusic.model.User;
import springmusic.model.dao.UserDao;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        if (!userDao.isEmailUnique(user.getEmail().trim()))
            errors.rejectValue("email", "error.email.unique");

        if (!StringUtils.hasText(user.getPassword().trim()))
            errors.rejectValue("password", "error.field.empty");

        if (!StringUtils.hasText(user.getEmail().trim()))
            errors.rejectValue("email", "error.field.empty");

        if (!StringUtils.hasText(user.getFirstName().trim()))
            errors.rejectValue("firstName", "error.field.empty");

        if (!StringUtils.hasText(user.getLastName().trim()))
            errors.rejectValue("lastName", "error.field.empty");
    }

}
