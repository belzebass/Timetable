package hu.pe.mik.timetable.controllers;

import hu.pe.mik.timetable.domain.UserEntity;
import hu.pe.mik.timetable.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @GetMapping("/all")
    public List<UserEntity> listUsers() {
        return repository.findAll();
    }

    @PostMapping(value = "/add")
    public void addUser(@RequestBody UserEntity entity) {
        System.out.println(entity);
    }
}
