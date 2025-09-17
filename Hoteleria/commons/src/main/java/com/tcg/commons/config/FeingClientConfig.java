package com.tcg.commons.config;

import com.tcg.commons.CommonsApplication;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeingClientConfig {

    private final CommonsApplication commonsApplication;

    FeingClientConfig(CommonsApplication commonsApplication) {
        this.commonsApplication = commonsApplication;
    }
	
	@Bean
	RequestInterceptor requestInterceptor() {
		return (RequestTemplate template) -> {
			ServletRequestAttributes attributes =
					(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			if (attributes !=null ) {
				HttpServletRequest request = attributes.getRequest();
				String authorizationHeader = request.getHeader ("Authorization");
				if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
					template.header("Authorization", authorizationHeader);
				}
			}
		};
	}

}
