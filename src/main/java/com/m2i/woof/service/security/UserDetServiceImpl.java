package com.m2i.woof.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import com.m2i.woof.repository.UserRepository;

@Service
public class UserDetServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.m2i.woof.model.User user = userRepository.findByIdentifiant(username);
        if(user == null) throw new UsernameNotFoundException("User inconnu");
        return User.withUsername(user.getIdentifiant())
                .password(user.getPassword())
                .roles(user.getRole().toString()).build();
    }
}
