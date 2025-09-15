package com.tcg.authorization.dto;

public record LoginRequest(
		String username,
		String password
		) {}
