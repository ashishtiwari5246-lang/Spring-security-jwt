package com.ram.security.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTsercive {
    private Key getkey() {
        return Keys.hmacShaKeyFor("mysecretkeymysecretmysecretkey12".getBytes());
    }
    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() +1000* 60 * 60 * 30))
                .and().signWith( getkey(),SignatureAlgorithm.HS256  )
                .compact();
    }
}
