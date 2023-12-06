package com.emi.medicalimageprocessing.services.auth;

import com.emi.medicalimageprocessing.exception.EntityNotFoundException;
import com.emi.medicalimageprocessing.exception.ErrorCodes;
import com.emi.medicalimageprocessing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.emi.medicalimageprocessing.model.User user = userRepository.findByUsername(username).orElseThrow(() ->
                new EntityNotFoundException("test erreur", ErrorCodes.USER_NOT_FOUND));
        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
