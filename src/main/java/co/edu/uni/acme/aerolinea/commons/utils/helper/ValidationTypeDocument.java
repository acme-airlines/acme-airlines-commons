package co.edu.uni.acme.aerolinea.commons.utils.helper;

import co.edu.uni.acme.aerolinea.commons.utils.anotations.TypeDocumentValidation;
import co.edu.uni.acme.aerolinea.commons.utils.enums.DocumentTypeEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static co.edu.uni.acme.aerolinea.commons.utils.constants.Constants.*;

public class ValidationTypeDocument implements ConstraintValidator<TypeDocumentValidation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Verifica si el valor corresponde a un tipo de documento válido
        if (DocumentTypeEnum.exists(value)) {
            return true;
        }

        // Construye un mensaje de error personalizado con los tipos de documento disponibles
        StringBuilder texto = new StringBuilder();
        texto.append(DOCUMENT_TYPE_NOT_AVAILABLE);
        for (DocumentTypeEnum typeDocument : DocumentTypeEnum.values()) {
            texto.append(typeDocument.name()).append(MIDDLE_LINE).append(typeDocument.getDescription()).append(COMMA);
        }

        // Deshabilita el mensaje de error predeterminado
        context.disableDefaultConstraintViolation();

        // Agrega el mensaje de error personalizado
        context.buildConstraintViolationWithTemplate(
                texto.toString()
        ).addConstraintViolation();

        return false;
    }
}
