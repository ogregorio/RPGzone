package com.rpgzonewebrest.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
@Component
@Order(1)
public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		
		if(!httpRequest.getServletPath().startsWith("/api")) {//Requisição de recursos estáticos caso sejam necessários futuramente
			chain.doFilter(request, response);
			return;
		}
		
		
		if(httpRequest.getServletPath().startsWith("/auth/login")) {//se o usuário estiver na rota de login ele não precisa estar autenticado porque essa rota é justamente a rota de autenticação
			chain.doFilter(request, response);
			return;
		}
		
		Cookie token = WebUtils.getCookie(httpRequest, "token");
		System.out.println(token);
		if(token == null) {
			httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
			return;
		}
		
		try {
			String jwt = token.getValue();
			DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("Fraseautenticacao123"))//Colocar essa fraseautenticacao123 em outro lugar depois
								.build()
								.verify(jwt);
			
			Long userLoggedID = decodedJWT.getClaim("userID").asLong();
			
			httpRequest.setAttribute("userID", userLoggedID);
			
			//chamada autenticada 
			chain.doFilter(request, response);//COM o userID no corpo da requisição, chain é como se fosse um parâmetro next no caso do node ou um throws, ou seja lança para frente
			
		} catch(JWTVerificationException ex) {
			httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
			return;
		}
		
	}
	@Override
	public void init(FilterConfig filterConfig) {
	}
	
	 @Override
	  public void destroy() {
		 
	  }
	
}
