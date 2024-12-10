package com.example.AuthenticateAPI.service;

import com.example.AuthenticateAPI.Enums.AvailableStatus;
import com.example.AuthenticateAPI.exception.OurException;
import com.example.AuthenticateAPI.model.Users;
import com.example.AuthenticateAPI.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = usersRepository.findByUsernameAndAvailableStatus(username, AvailableStatus.ACTIVE).orElse(null);

        if(user == null){
            Users ourUser = usersRepository.findByUsernameAndAvailableStatus(username, AvailableStatus.ACTIVE).orElse(null);
            if(ourUser != null){
                return ourUser;
            }
        }

        if(user == null){
            throw new OurException("Username not found with username: " + username);
        }

        return user;
    }


}
