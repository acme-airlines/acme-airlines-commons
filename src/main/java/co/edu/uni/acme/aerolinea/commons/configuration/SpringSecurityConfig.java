package co.edu.uni.acme.aerolinea.commons.configuration;

import co.edu.uni.acme.aerolinea.commons.utils.helper.JWTAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

    private final JWTAuthenticationFilter jwtAuthenticationFilter;




}
