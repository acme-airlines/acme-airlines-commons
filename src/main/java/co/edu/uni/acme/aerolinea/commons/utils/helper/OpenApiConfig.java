package co.edu.uni.acme.aerolinea.commons.utils.helper;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "API Documentation", version = "v1"), // Información básica de la API
        security = {@SecurityRequirement(name = "bearer-key")} // Requisitos de seguridad para la API
)
@SecurityScheme(
        name = "bearer-key", // Nombre del esquema de seguridad
        type = SecuritySchemeType.HTTP, // Tipo de esquema de seguridad (HTTP)
        scheme = "bearer", // Esquema utilizado (Bearer)
        bearerFormat = "JWT" // Formato del token (JWT)
)
public class OpenApiConfig {
}
