package com.nagarro.communityapplication.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nagarro.communityapplication.services.CustomUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain){
            
     //1. get token from header 

     String requestToken = request.getHeader("Authorization");

     //Bearer 31kjlqi30q00990q
     String username = null;
     String token = null;

     if(requestToken!=null && requestToken.startsWith("Bearer")){

        token = requestToken.substring(7);
        try{
        username = this.jwtTokenHelper.getUsernameFromToken(token);
        }catch(IllegalArgumentException e){
            System.out.println("Unable to get Jwt token");
        }catch(ExpiredJwtException e){
            System.out.println("Jwt token has exipred");
        }catch(MalformedJwtException e){
            System.out.println("Jwt token does not begin with Bearer");
        }
     }else{
        //we can add exception here
        System.out.println("Jwt token not begin with Bearer");
     }

     //once we get token , now validate token

     if(username != null && SecurityContextHolder.getContext().getAuthentication()==null){

        UserDetails user = this.customUserDetailsService.loadUserByUsername(username);
        if(this.jwtTokenHelper.validateToken(token, user)){
            //if token is correct 
            //then authication is done 
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }else{
            System.out.println("Invalid jwt token");
        }
     }else{

        System.out.println("Username is null or Context is null");

     }

     //filter
     try {
        filterChain.doFilter(request, response);
    } catch (IOException | ServletException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
     

    }
    
}
