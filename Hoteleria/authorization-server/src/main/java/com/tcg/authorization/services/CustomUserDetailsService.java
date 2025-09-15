package com.tcg.authorization.services;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tcg.authorization.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) {
	this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		com.tcg.authorization.models.User user = userRepository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado en BD"));
		
		return new User(
				user.getUsername(),
				user.getPassword(),
				user.getRoles().stream()
				.map(r -> new SimpleGrantedAuthority(r.getNombre()))
				.collect(Collectors.toSet())
				);
	}
}
