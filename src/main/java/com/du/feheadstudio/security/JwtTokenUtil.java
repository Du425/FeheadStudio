package com.du.feheadstudio.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

/**
 * @Author DU425
 * @Date 2022/3/6 17:03
 * @Version 1.0
 * @Description
 */
@Component
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private static String secret;

    @Value("${jwt.expire}")
    private static long expire;

    private static final String ISS = "Du425";

//    private static final long EXPIRE_REMEMBER = 604800L;

    public String generateToken(String username){
        String token = null;
        Claims claims = Jwts.claims().setSubject(username);
        try {
            token = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .setClaims(claims)
                    .setIssuer(ISS)
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + expire*1000))
                    .compact();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return token;
    }

    public static String getUsername(String token){
        return getTokenBody(token).getSubject();
    }

    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

}
