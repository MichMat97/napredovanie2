package com.vaii.napredovanie2.security;

import com.vaii.napredovanie2.entity.Role;
import com.vaii.napredovanie2.entity.User;
import com.vaii.napredovanie2.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            User user = userRepository.findByEmail(email);

            if (user != null) {
                return new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPassword(),
                        mapRolesToAuthorities(user.getRole()));
            }else{
                throw new UsernameNotFoundException("Invalid username or password.");
            }
        }

        private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Role role) {
            return Collections.singletonList(new SimpleGrantedAuthority(role.getName()));
        }
}
