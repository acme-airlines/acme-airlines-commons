package co.edu.uni.acme.aerolinea.commons.utils.exceptions;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static co.edu.uni.acme.aerolinea.commons.utils.constants.Constants.*;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // Devolver un código 401 con un mensaje personalizado
        response.setContentType(RESPONSE_CONTENT_TYPE);
        response.setStatus(RESPONSE_STATUS_UNAUTHORIZED);
        response.getWriter().write("{\"error\": \"" + AUTHENTICATION_FAILED_MESSAGE + authException.getMessage() + "\"}");
    }

}
