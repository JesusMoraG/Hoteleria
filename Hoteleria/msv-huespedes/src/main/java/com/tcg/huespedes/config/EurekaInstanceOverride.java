package com.tcg.huespedes.config;

import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EurekaInstanceOverride {

  @Bean
  public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils, Environment env) {
    EurekaInstanceConfigBean cfg = new EurekaInstanceConfigBean(inetUtils);

    String app = env.getProperty("spring.application.name", "msv-huespedes");
    int port   = Integer.parseInt(env.getProperty("server.port", "8083"));
    String ip  = env.getProperty("eureka.instance.ip-address", "127.0.0.1");
    String host= env.getProperty("eureka.instance.hostname", "localhost");

    cfg.setAppname(app);
    cfg.setPreferIpAddress(true);
    cfg.setIpAddress(ip);
    cfg.setHostname(host);
    cfg.setNonSecurePort(port);

    // Si quieres, puedes añadir estas URLs, pero no son obligatorias:
    // cfg.setHomePageUrl("http://"+ip+":"+port+"/");
    // cfg.setStatusPageUrl("http://"+ip+":"+port+"/actuator/info");
    // cfg.setHealthCheckUrl("http://"+ip+":"+port+"/actuator/health");
    return cfg;
  }
}
