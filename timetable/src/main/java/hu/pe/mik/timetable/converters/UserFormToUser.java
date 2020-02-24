package hu.pe.mik.timetable.converters;

import hu.pe.mik.timetable.commands.UserForm;
import hu.pe.mik.timetable.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class UserFormToUser implements Converter<UserForm, User> {
    @Override
    public User convert(UserForm userForm) {
        User user = new User();
        if (userForm.getId() != null && !StringUtils.isEmpty(userForm.getId())) {
            user.setId(new Long(userForm.getId()));
        }
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        return user;
    }
}
