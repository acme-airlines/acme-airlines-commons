package co.edu.uni.acme.aerolinea.commons.utils.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static co.edu.uni.acme.aerolinea.commons.utils.constants.Constants.*;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put(TIMESTAMP_KEY, LocalDateTime.now());
        body.put(PATH_KEY, request.getDescription(false));
        body.put(STATUS_KEY, HttpStatus.BAD_REQUEST.value());
        body.put(MESSAGE_KEY, VALIDATION_ERRORS_MESSAGE);

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        body.put(ERRORS_KEY, errors);

        log.error(VALIDATION_ERRORS, ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put(TIMESTAMP_KEY, LocalDateTime.now());
        body.put(PATH_KEY, request.getDescription(false));
        body.put(STATUS_KEY, ex.getStatusCode().value());
        body.put(MESSAGE_KEY, ex.getReason());
        body.put(ERRORS_KEY, "Error en la solicitud");

        log.error("ResponseStatusException: {}", ex.getMessage());
        return new ResponseEntity<>(body, ex.getStatusCode());
    }

    @ExceptionHandler({Exception.class, HttpClientErrorException.class})
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put(TIMESTAMP_KEY, LocalDateTime.now());
        body.put(PATH_KEY, request.getDescription(false));
        body.put(STATUS_KEY, HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put(MESSAGE_KEY, INTERNAL_SERVER_ERROR);
        body.put(ERRORS_KEY, ex.getMessage());

        log.error(UNEXPECTED_ERROR, ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put(TIMESTAMP_KEY, LocalDateTime.now());
        body.put(PATH_KEY, request.getDescription(false));
        body.put(STATUS_KEY, HttpStatus.BAD_REQUEST.value());
        body.put(MESSAGE_KEY, ex.getMessage());
        body.put(ERRORS_KEY, "Verifica los datos ingresados");

        log.warn("IllegalArgumentException: {}", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
