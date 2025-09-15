package com.tcg.authorization.services;

import java.util.Set;

import com.tcg.authorization.dto.UserRequest;
import com.tcg.authorization.dto.UserResponse;

public interface UserService {
	
	Set<UserResponse> listarUsuarios();
	
	UserResponse crearUsusario(UserRequest request);
	
	UserResponse eliminarUsuario(UserRequest request);

	UserResponse eliminarUsuario(String username);

}
