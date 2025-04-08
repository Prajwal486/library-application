package com.wisdom.Student.Library.App.service;

import com.wisdom.Student.Library.App.entity.Student;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JwtService {
    private String secretKey=null;
    public String generateToken(Student student) {
        Map<String,Object> claims=new HashMap<>();
        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(student.getUserName())
                .issuer("wisdom")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+60*10*1000))
                .and()
                .signWith(generatekey())
                .compact();


    }

    private SecretKey generatekey() {
        byte[] decode = Decoders.BASE64.decode(getSecretKey());

        return Keys.hmacShaKeyFor(decode);
    }

    public String getSecretKey(){
        return secretKey="q5hS9s1g5gnrJH48HHblnIL/8Kde/UFg2CD7f5snKuQ=";
    }

    public String extractUserName(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims,T> claimResolver) {
        Claims claims=extractClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractClaims(String token) {
       return Jwts
                .parser()
                .verifyWith(generatekey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName=extractUserName(token);
        return (userName.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
     return extractClaims(token,Claims::getExpiration);
    }
}
