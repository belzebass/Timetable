package hu.pe.mik.timetable.controllers.user;

import hu.pe.mik.timetable.storage.user.UserEntity;
import hu.pe.mik.timetable.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
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

}
