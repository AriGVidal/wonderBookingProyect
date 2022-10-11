package com.house.digital.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.house.digital.entity.Rol;
import com.house.digital.entity.Usuario;
import com.house.digital.exception.ResourceNotFoundException;
import com.house.digital.repository.UsuarioRepository;

@Service
public class ConfigurationUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	/*
	 * Method to verify and load the logged in user's data
	 * 
	 * @param String usernane
	 * 
	 * @return User with the data of user logged
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(
				() -> new ResourceNotFoundException("No se encontraron usuario con el email: " + email));
		
		return new User(usuario.getEmail(), usuario.getPassword(), mapperRoles(usuario.getRol()));
	}
	
	/*
	 * Method to obtain the roles of the logged in users
	 * 
	 * @param Set<Role> role of the user logged
	 * 
	 * @return Collection<? extends GrantedAuthority> with the roles of users
	 */
	private Collection<? extends GrantedAuthority> mapperRoles(Rol rol){
		
		Set<Rol> roles = new HashSet<>();
		roles.add(rol);
		
		return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getNombre().toUpperCase().replace(" ", "_"))).collect(Collectors.toList());
	}
}
