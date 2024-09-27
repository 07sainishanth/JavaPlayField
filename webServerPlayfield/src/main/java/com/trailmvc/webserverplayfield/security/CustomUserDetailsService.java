package com.trailmvc.webserverplayfield.security;

import com.trailmvc.webserverplayfield.models.UserEntity;
import com.trailmvc.webserverplayfield.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findFirstByUsername(username);
        if (userEntity != null) {
            User authUser = new User(
                    userEntity.getEmail(),
                    userEntity.getPassword(),
                    userEntity.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toUnmodifiableList())
            );
            return authUser;
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }
}
