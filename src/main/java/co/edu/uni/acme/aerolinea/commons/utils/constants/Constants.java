package co.edu.uni.acme.aerolinea.commons.utils.constants;

import jakarta.servlet.http.HttpServletResponse;

public class Constants {

    // Claims and messages related to JWT
    public static final String CLAIM_CODE_PASSENGER = "codePassenger";
    public static final String ERROR_INVALID_IDENTIFIER = "The token does not contain a valid identifier.";
    public static final long EXPIRATION_TIME_IN_MILLIS = 24 * 60 * 60 * 1000; // 24 hours

    // Validation Messages
    public static final String DEFAULT_MESSAGE_POSITION_VALIDATION = "The entered position is not valid.";
    public static final String DEFAULT_MESSAGE_DATE_VALIDATION = "The entered date is not valid.";
    public static final String DEFAULT_MESSAGE_DOCUMENT_TYPE_VALIDATION = "The entered document type does not exist.";

    // Configuration Constants
    public static final String ERROR_USER_NOT_FOUND = "Error while searching for the user: ";
    public static final String DEVELOPMENT_ORIGIN = "http://localhost:4200";

    // Paths
    public static final String V3_API_DOCS_PATH = "/v3/api-docs/**";
    public static final String SWAGGER_UI_PATH = "/doc/swagger-ui/***";
    public static final String PASSENGER_PATH = "/passenger/**";
    public static final String WS_PATH = "/ws/**";

    // HTTP Response: content and statuses
    public static final String RESPONSE_CONTENT_TYPE = "application/json";
    public static final int RESPONSE_STATUS_FORBIDDEN = HttpServletResponse.SC_FORBIDDEN;
    public static final String ACCESS_DENIED_MESSAGE = "{\"error\": \"Access denied: You do not have permission to access this resource.\"}";

    public static final int RESPONSE_STATUS_UNAUTHORIZED = HttpServletResponse.SC_UNAUTHORIZED;
    public static final String AUTHENTICATION_FAILED_MESSAGE = "Authentication failed: ";

    // Response keys and messages
    public static final String TIMESTAMP_KEY = "timestamp";
    public static final String PATH_KEY = "path";
    public static final String STATUS_KEY = "status";
    public static final String MESSAGE_KEY = "message";
    public static final String ERRORS_KEY = "errors";
    public static final String VALIDATION_ERRORS_MESSAGE = "Validation errors";
    public static final String NOT_FOUND_ERROR = "Not found";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error";

    // Error messages in logs
    public static final String VALIDATION_ERRORS = "Validation errors: {}";
    public static final String RESOURCE_NOT_FOUND = "Resource not found: {}";
    public static final String UNEXPECTED_ERROR = "Unexpected error: {}";

    // Date format
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    // Bearer token prefix and size
    public static final String BEARER_PREFIX = "Bearer ";
    public static final int SIZE_BEARER = 7;

    // Code limits
    public static final int MAX_CODE = 5;
    public static final int MIN_CODE = 0;

    // Characters and messages related to validations
    public static final String MIDDLE_LINE = "-";
    public static final String TYPE_CONVERSION_ERROR = "Type conversion error: ";
    public static final String POSITION_NOT_AVAILABLE = "The entered position is not valid, use one of the available options: ";
    public static final String DOCUMENT_TYPE_NOT_AVAILABLE = "The entered document type is not valid, use one of the following: ";
    public static final String COMMA = ", ";

    // Regular expression for date validation
    public static final String REGEX_DATE = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";
    public static final String STRING_DOES_NOT_MEET_FORMAT = "The string does not match the yyyy-MM-dd format.";

}
