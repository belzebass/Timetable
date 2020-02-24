package hu.pe.mik.timetable.services;

import hu.pe.mik.timetable.commands.UserForm;
import hu.pe.mik.timetable.domain.User;

import java.util.List;

public interface UserService {
    List<User> listAll();

    User getById(Long id);

    User saveOrUpdate(User user);

    void delete(Long id);

    User saveOrUpdateUserForm(UserForm userForm);
}
