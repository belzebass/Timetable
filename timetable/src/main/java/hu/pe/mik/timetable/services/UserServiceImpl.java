package hu.pe.mik.timetable.services;

import hu.pe.mik.timetable.commands.UserForm;
import hu.pe.mik.timetable.converters.UserFormToUser;
import hu.pe.mik.timetable.domain.User;
import hu.pe.mik.timetable.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserFormToUser userFormToUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserFormToUser userFormToUser) {
        this.userRepository = userRepository;
        this.userFormToUser = userFormToUser;
    }

    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveOrUpdate(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User saveOrUpdateUserForm(UserForm userForm) {
        User savedUser = saveOrUpdate(userFormToUser.convert(userForm));

        System.out.println("Saved user Id: " + savedUser.getId());
        return savedUser;
    }
}
