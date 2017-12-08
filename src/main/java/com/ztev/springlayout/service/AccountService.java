package com.ztev.springlayout.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Created by ${xiaozb} on 2017/12/8.
 *
 * @copyright by ztev
 */
@Service
public class AccountService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User("admin","password", Collections.singleton(createAuthority()));
    }

    private GrantedAuthority createAuthority() {
       return new SimpleGrantedAuthority("role_admin");
    }
}
