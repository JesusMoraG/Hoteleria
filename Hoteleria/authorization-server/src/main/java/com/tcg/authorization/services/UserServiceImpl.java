package com.tcg.authorization.services;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.aspectj.lang.reflect.NoSuchAdviceException;
import org.springframework.security.core.Transient;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcg.authorization.dto.UserRequest;
import com.tcg.authorization.dto.UserResponse;
import com.tcg.authorization.models.Role;
import com.tcg.authorization.models.User;
import com.tcg.authorization.repositories.RoleRepository;
import com.tcg.authorization.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    private final AuthServiceImpl authServiceImpl;
	
	private final UserRepository userRepository;
	
	private final RoleRepository roleRepository;
	
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(RoleRepository roleRepository,
			PasswordEncoder passwordEncoder, AuthServiceImpl authServiceImpl, UserRepository userRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
		this.authServiceImpl = authServiceImpl;
	}

	@Override
	@Transactional(readOnly = true)
	public Set<UserResponse> listarUsuarios() {
		return userRepository.findAll().stream()
				.map(user -> new UserResponse( user.getUsername(), user.getRoles().stream()
							.map(Role::getNombre).collect(Collectors.toSet()) )
					).collect(Collectors.toSet());
				
	}

	@Override
	public UserResponse crearUsusario(UserRequest request) {
		if (userRepository.findByUsername(request.username()).isPresent()) {
			throw new IllegalArgumentException("Ya esta registrado el usuario: " + request.username());
		}
		
		Set<Role> roles = request.roles().stream().map(rol -> roleRepository.findByNombre(rol)
				.orElseThrow(() -> new NoSuchElementException("Rol no encontrado: " + rol)))
				.collect(Collectors.toSet());
		User user = new User();
		user.setUsername(request.username());
		user.setPassword(passwordEncoder.encode(request.password()));
		user.setRoles(roles);
		user = userRepository.save(user);
		return new UserResponse(user.getUsername(), user.getRoles().stream()
				.map(Role::getNombre).collect(Collectors.toSet()));
	}

	@Override
	public UserResponse eliminarUsuario(String username) {
		User user = userRepository.findByUsername(username).orElseThrow(
				() -> new NoSuchElementException("No se encontró el ususario:" + username));
		userRepository.deleteById(user.getId());
		return new UserResponse(user.getUsername(), user.getRoles().stream()
				.map(Role::getNombre).collect(Collectors.toSet())
				);
	}

	@Override
	public UserResponse eliminarUsuario(UserRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
