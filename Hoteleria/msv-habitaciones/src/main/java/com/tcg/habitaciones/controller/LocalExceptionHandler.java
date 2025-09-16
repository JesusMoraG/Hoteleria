package com.tcg.habitaciones.controller;


import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tcg.commons.exceptions.GlobalExceptionHandler;



@RestControllerAdvice
public class LocalExceptionHandler {
	
	private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class.getName());
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Map <String, Object>> handlerDataIntegrityViolationException(DataIntegrityViolationException e){
		LOGGER.log(Level.SEVERE, "Error en la integridad de los datos: "+
	(e.getCause()!=null?e.getCause():e.getMessage()));
		return ResponseEntity.badRequest().body(Map.of(
				"code",HttpStatus.BAD_REQUEST.value(),
				"response","Error en la integridad de los datos: "+e.getMessage()
				));
	}

}
