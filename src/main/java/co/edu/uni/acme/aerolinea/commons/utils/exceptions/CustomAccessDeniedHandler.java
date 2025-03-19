package co.edu.uni.acme.aerolinea.commons.utils.exceptions;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static co.edu.uni.acme.aerolinea.commons.utils.constants.Constants.*;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // Devolver un código 403 con un mensaje personalizado
        response.setContentType(RESPONSE_CONTENT_TYPE);
        response.setStatus(RESPONSE_STATUS_FORBIDDEN);
        response.getWriter().write(ACCESS_DENIED_MESSAGE);
    }
}
