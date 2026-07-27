package com.bankapp.config;

import com.bankapp.repo.UserEntity;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByUsername(username);

        if(userEntity == null){
            throw new UsernameNotFoundException("User not found");
        }
        //but now somehow i need convert UserEntity to UserDetails that is understood by spring security

        return new SecUserDetail(userEntity);
    }
}
