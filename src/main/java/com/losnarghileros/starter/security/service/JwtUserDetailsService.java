package com.losnarghileros.starter.security.service;

import com.losnarghileros.starter.entities.User;
import com.losnarghileros.starter.repository.UserRepository;
import com.losnarghileros.starter.security.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(mail);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", mail));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
