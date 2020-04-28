package hu.pe.mik.timetable.controllers;

import hu.pe.mik.timetable.repositories.UserRepository;
import hu.pe.mik.timetable.storage.user.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/login")
    private void login(@RequestParam("email") String email,
                       @RequestParam("password") String password) {
        System.out.println(email);
        UserEntity userEntity = userRepository.findByEmail(email);
        if (bCryptPasswordEncoder.matches(password, userEntity.getPassword())) {
            autoLogin(email, password);
        }
    }

    public void autoLogin(String username, String password) {
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
