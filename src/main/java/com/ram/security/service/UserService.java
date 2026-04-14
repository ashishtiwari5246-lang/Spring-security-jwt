package com.ram.security.service;

import com.ram.security.model.Users;
import com.ram.security.repo.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private Userrepo userrepo;
    @Autowired
    private JWTsercive jwtsercive;
    @Autowired
    AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public Users register(Users user) throws Exception{
        user.setPassword(encoder.encode(user.getPassword()));
        return userrepo.save(user);

    }

    public String verify(Users user) {
       Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
     if(  authentication.isAuthenticated())
      return jwtsercive.generateToken(user.getUsername());
     return "success";
     //return "fail";
    }
}
