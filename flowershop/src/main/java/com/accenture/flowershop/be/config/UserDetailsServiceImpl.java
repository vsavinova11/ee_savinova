package com.accenture.flowershop.be.config;

import com.accenture.flowershop.be.entity.user.Admin;
import com.accenture.flowershop.be.entity.user.Client;
import com.accenture.flowershop.be.entity.user.User;
import com.accenture.flowershop.be.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(s);
        if (user == null){
            throw new UsernameNotFoundException(s);
        }
        SimpleGrantedAuthority simpleGrantedAuthority = null;
        if (user instanceof Client){
            simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_CLIENT");
        }
        if (user instanceof Admin){
            simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        }
        if (simpleGrantedAuthority == null){
            throw new RuntimeException("Unknown account type");
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), Collections.singleton(simpleGrantedAuthority));
        return userDetails;
    }
}
