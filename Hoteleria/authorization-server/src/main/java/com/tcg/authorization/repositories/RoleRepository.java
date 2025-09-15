package com.tcg.authorization.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcg.authorization.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Optional<Role> findByNombre(String nombre);

}
