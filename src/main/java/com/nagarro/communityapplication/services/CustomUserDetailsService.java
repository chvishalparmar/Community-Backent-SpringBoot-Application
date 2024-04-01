package com.nagarro.communityapplication.services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.communityapplication.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override //you can use database here 
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        
        com.nagarro.communityapplication.entities.User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
        .orElseThrow(() ->new UsernameNotFoundException("User not found with username or email: "+ usernameOrEmail));
        // .orElseThrow(() ->
        //         new UsernameNotFoundException("User not found with username or email: "+ usernameOrEmail));
        // // System.out.print("checking" + userName);
        // if(userName.equals("admin")){
        //     return new User("admin", "admin", new ArrayList<>() );
        // }else{
        //     throw new UnsupportedOperationException("User not Found !!");
        // }

        System.out.println(usernameOrEmail);
        System.out.println(user.toString());

        if(user.getUsername().equals(usernameOrEmail))
        {
            return new User(user.getUsername(),user.getPassword(), new ArrayList<>());
                
        }else{ 
             throw new UnsupportedOperationException("User not Found !!");

        }

    }
    
}
