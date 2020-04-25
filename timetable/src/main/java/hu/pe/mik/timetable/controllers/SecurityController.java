package hu.pe.mik.timetable.controllers;

import hu.pe.mik.timetable.repositories.UserRepository;
import hu.pe.mik.timetable.storage.user.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/registration")
    private void registration(@RequestBody UserEntity entity) {
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));

        if (userRepository.findByEmail(entity.getEmail()) == null) {
            userRepository.save(entity);
        }
    }
}
