package co.edu.uni.acme.aerolinea.commons.utils.anotations;

import co.edu.uni.acme.aerolinea.commons.utils.helper.ValidationTypeDocument;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static co.edu.uni.acme.aerolinea.commons.utils.constants.Constants.DEFAULT_MESSAGE_DOCUMENT_TYPE_VALIDATION;

@Constraint(validatedBy = ValidationTypeDocument.class)
@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeDocumentValidation {


    String message() default DEFAULT_MESSAGE_DOCUMENT_TYPE_VALIDATION;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
