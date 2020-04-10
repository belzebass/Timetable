package hu.pe.mik.timetable.controllers;

import hu.pe.mik.timetable.domain.UserEntity;
import hu.pe.mik.timetable.repositories.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping(value = "/add",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void addUser(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam String email,
                        @RequestParam String emailVerify,
                        @RequestParam String password,
                        @RequestParam String passwordVerify) {
        System.out.println(repository.save(new UserEntity(1L, firstName, lastName, email, password, new ArrayList<>())));
    }
}
