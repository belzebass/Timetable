package hu.pe.mik.timetable.controllers;

import hu.pe.mik.timetable.repositories.UserRepository;
import hu.pe.mik.timetable.storage.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BaseController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    public String loggedInUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public UserEntity loggedInUser() {
        return userRepository.findByEmail(loggedInUserName());
    }
}
