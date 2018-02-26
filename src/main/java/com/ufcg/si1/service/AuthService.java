package com.ufcg.si1.service;

import com.ufcg.si1.model.Usuario;
import com.ufcg.si1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static java.util.Collections.emptyList;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario applicationUser = userRepository.findFirstByEmail(email);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(applicationUser.getEmail(), applicationUser.getPassword(), applicationUser.getAuthorities());
    }
}