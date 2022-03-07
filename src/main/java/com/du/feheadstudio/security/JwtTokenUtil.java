package com.du.feheadstudio.security;

import com.du.feheadstudio.handler.CustomizeAuthenticationFailureHandler;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
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

    @Autowired
    private MyUserDetails myUserDetails;

//    @PostConstruct
//    protected void init() {
//        secret = Base64.getEncoder().encodeToString(secret.getBytes());
//    }

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
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public Authentication getAuthentication(String token){
        UserDetails userDetails = myUserDetails.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails," ", userDetails.getAuthorities());
    }

    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }

    public String resolveToken(HttpServletRequest request){
        String bearToken = request.getHeader("Authorization");
        if (bearToken != null && bearToken.startsWith("Bearer")){
            return bearToken.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) throws CustomizeAuthenticationFailureHandler {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (JwtException | IllegalArgumentException e){
            throw new CustomizeAuthenticationFailureHandler();
        }
    }

    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

}
