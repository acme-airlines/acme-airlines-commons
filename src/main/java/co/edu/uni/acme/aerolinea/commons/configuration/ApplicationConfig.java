package co.edu.uni.acme.aerolinea.commons.configuration;

import co.edu.uni.acme.aerolinea.commons.dto.PassengerSecurityDTO;
import co.edu.uni.acme.aerolinea.commons.entity.PassengerEntity;
import co.edu.uni.acme.aerolinea.commons.repository.PassengerRepository;
import co.edu.uni.acme.aerolinea.commons.utils.mappers.PassengerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static co.edu.uni.acme.aerolinea.commons.utils.constants.Constants.DEVELOPMENT_ORIGIN;
import static co.edu.uni.acme.aerolinea.commons.utils.constants.Constants.ERROR_USER_NOT_FOUND;


@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final PassengerRepository passengerRepository;

    private final PassengerMapper passengerMapper;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailService() {
        return username -> {
            PassengerEntity passenger = passengerRepository.findByEmailPassenger(username)
                    .orElseThrow(() -> new UsernameNotFoundException(ERROR_USER_NOT_FOUND + username));
            return new PassengerSecurityDTO(passengerMapper.entityToDto(passenger));
        };
    }

    @Bean
    public WebMvcConfigurer corsConfigurerDev() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Aplica a todas las rutas
                        .allowedOrigins(DEVELOPMENT_ORIGIN) // Permitir solo el origen de desarrollo
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*"); // Permitir todos los headers en desarrollo
            }
        };
    }

}
