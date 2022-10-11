package com.house.digital.security;

import static com.house.digital.security.SecurityConstants.BEARER;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.house.digital.entity.Usuario;
import com.house.digital.exception.ResourceNotFoundException;
import com.house.digital.repository.UsuarioRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Value("${app.jwt-secret-key}")
	private String secretKey;

	@Value("${app.jwt-expiration-token-milliseconds}")
	private Integer timeTokenExpiration;	

	public Map<String, String> createToken(Authentication authentication) {

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		final Map<String, String> informationToken = new HashMap<>();

		String jsonWebToken = Jwts.builder().setSubject(authentication.getName()).setIssuedAt(new Date())
				.claim("authorities", authorities)
				.setExpiration(new Date(System.currentTimeMillis() + timeTokenExpiration))
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();
		
		Optional<Usuario> usuarioAux = usuarioRepository.findByEmail(authentication.getName());

		if(usuarioAux.isPresent()) {
			Usuario usuario = usuarioAux.get();
			
			informationToken.put("access_token", jsonWebToken);
			informationToken.put("token_type", BEARER);
			informationToken.put("expires_in", String.valueOf(timeTokenExpiration / 1000));
			informationToken.put("created_at", new Date().toString());
			informationToken.put("email", authentication.getName());
			informationToken.put("nombre", usuario.getNombre());
			informationToken.put("apellido", usuario.getApellido());

			return informationToken;
		} else {
			throw new ResourceNotFoundException("Usuario no encontrado");
		}
		
		
	}


	public boolean validateToken(String token, UserDetails userDetails) {
		return userDetails.getUsername().equals(extractEmail(token)) && !isTokenExpired(token);
	}

	public String extractEmail(String token) {
		return getClaims(token).getSubject();
	}

	private Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}

	private boolean isTokenExpired(String token) {
		return getClaims(token).getExpiration().before(new Date());
	}
}