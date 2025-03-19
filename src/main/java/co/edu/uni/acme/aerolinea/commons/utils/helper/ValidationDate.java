package co.edu.uni.acme.aerolinea.commons.utils.helper;

import co.edu.uni.acme.aerolinea.commons.utils.anotations.DateValidationAnotation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

import static co.edu.uni.acme.aerolinea.commons.utils.constants.Constants.REGEX_DATE;
import static co.edu.uni.acme.aerolinea.commons.utils.constants.Constants.STRING_DOES_NOT_MEET_FORMAT;


public class ValidationDate implements ConstraintValidator<DateValidationAnotation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            // Expresión regular para validar el formato de la fecha
            String regex = REGEX_DATE;

            // Compila la expresión regular
            Pattern pattern = Pattern.compile(regex);

            // Verifica si el valor no coincide con el patrón
            if (!pattern.matcher(value).matches()) {
                // Deshabilita el mensaje de error predeterminado
                context.disableDefaultConstraintViolation();

                // Construye un mensaje de error personalizado
                context.buildConstraintViolationWithTemplate(
                        STRING_DOES_NOT_MEET_FORMAT
                ).addConstraintViolation();

                return false;
            }
        }
        return true;
    }

}
