package hu.pe.mik.timetable.controllers;

import hu.pe.mik.timetable.repositories.UserRepository;
import hu.pe.mik.timetable.storage.user.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

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
    private ResponseEntity registration(@RequestBody UserEntity entity) {
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        System.out.println(Instant.now());

        if (userRepository.findByEmail(entity.getEmail()) == null) {
            userRepository.save(entity);
            return new ResponseEntity("Succesfull registration with: " + entity.getEmail(), HttpStatus.OK);
        }
        return new ResponseEntity("Unuccesfull registration with: " + entity.getEmail(), HttpStatus.OK);
    }

    @PostMapping("/login")
    private void login(@RequestBody UserEntity entity) {
        System.out.println(entity.getEmail());
        UserEntity userEntity = userRepository.findByEmail(entity.getEmail());
        if (bCryptPasswordEncoder.matches(entity.getPassword(), userEntity.getPassword())) {
            autoLogin(entity.getEmail(), entity.getPassword());
        }
    }

    private void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            log.info(String.format("Auto login %s successfully!", username));
        }
    }

    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }
        return null;
    }
}
