package hu.pe.mik.timetable.converters;

import hu.pe.mik.timetable.commands.UserForm;
import hu.pe.mik.timetable.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserForm implements Converter<User, UserForm> {
    @Override
    public UserForm convert(User user) {
        UserForm userForm = new UserForm();
        userForm.setId(user.getId());
        userForm.setName(user.getName());
        userForm.setEmail(user.getEmail());
        return userForm;
    }
}
