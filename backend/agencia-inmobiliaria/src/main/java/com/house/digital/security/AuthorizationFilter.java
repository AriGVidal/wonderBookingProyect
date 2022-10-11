package com.house.digital.security;

import static com.house.digital.security.SecurityConstants.BEARER;
import static com.house.digital.security.SecurityConstants.HEADER_AUTHORIZATION;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private ConfigurationUserDetailsService configurationUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (request.getServletPath().equals("/api/auth/login")) {
			filterChain.doFilter(request, response);
		} else {

			// Add messages of error for the token
			String authorizationHeader = request.getHeader(HEADER_AUTHORIZATION);

			if (authorizationHeader != null && authorizationHeader.startsWith(BEARER)) {

				String token = authorizationHeader.substring(7);
				String userName = tokenService.extractEmail(token);

				if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

					UserDetails userDetails = configurationUserDetailsService.loadUserByUsername(userName);

					if (tokenService.validateToken(token, userDetails)) {

						Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

						UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
								userDetails, null, authorities);

						authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

						SecurityContextHolder.getContext().setAuthentication(authToken);
						request.setAttribute("username", userDetails.getUsername());

					}
				}
			}

			filterChain.doFilter(request, response);
		}

	}

}