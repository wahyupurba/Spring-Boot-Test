/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.userrequestapp;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import static org.springframework.web.filter.OncePerRequestFilter.ALREADY_FILTERED_SUFFIX;

/**
 *
 * @author yuu
 */
public class CorsFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        response.setHeader("Access-Control-Allow-Origin", ALREADY_FILTERED_SUFFIX);
        response.setHeader("Access-Control-Allow-Method", "GET,POST,PUT,DELETE,OPTION");
        response.setHeader("Access-Control-Allow-Headers", "Content-type,xsrf-token,Cache-Control");
        response.setHeader("Access-Control-Expose-Header", "xrsf-token");
        if("OPTION".equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            filterChain.doFilter(request, response); 
        }
    }
    
}
