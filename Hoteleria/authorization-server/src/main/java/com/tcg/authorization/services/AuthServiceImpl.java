package com.tcg.authorization.services;


import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.JWKMatcher;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.KeyType;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimNames;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

@Service
public class AuthServiceImpl implements AuthService{
	
	private final UserDetailsService userDetailsService;
	
	private final RSAKey rsaKey;
	

	public AuthServiceImpl (JWKSource<SecurityContext> jwkSource, UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
			try {
				JWKSelector jwkSelector = new JWKSelector(
						new JWKMatcher.Builder().keyType(KeyType.RSA).build()
						);
				var jwks = jwkSource.get(jwkSelector, null);
				if (jwks == null || jwks.isEmpty()) {
					throw new RuntimeException("No se pudo optener la clave RSA");
				}
				this.rsaKey = (RSAKey) jwks.get(0);
			}catch (Exception e) {
				throw new RuntimeException("No se pudo obtener la clave RSA");
			}
	}


	@Override
	public String authenticate(String username, String password) throws Exception {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		if (userDetails == null || !new BCryptPasswordEncoder().matches(password, userDetails.getPassword())) {
			
		}
		
		Instant now = Instant.now();
		JWTClaimsSet claims = new JWTClaimsSet.Builder()
				.issuer("http://localhost:9000")
				.subject(userDetails.getUsername())
				.issueTime(Date.from(now))
				.expirationTime(Date.from(now.plusSeconds(3600)))
				.jwtID(UUID.randomUUID().toString())
				.claim("roles", userDetails.getAuthorities().stream()
						.map(authority -> authority.getAuthority())
						.toList()
				)
				.build();
		SignedJWT signedJWT = new SignedJWT(
				new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaKey.getKeyID()).build(), claims);
		JWSSigner signer = new RSASSASigner(rsaKey.toPrivateKey());
		signedJWT.sign(signer);
		return signedJWT.serialize();
		}
	
}
