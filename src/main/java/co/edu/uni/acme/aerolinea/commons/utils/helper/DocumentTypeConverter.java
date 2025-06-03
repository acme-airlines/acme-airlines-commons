package co.edu.uni.acme.aerolinea.commons.utils.helper;

import co.edu.uni.acme.aerolinea.commons.utils.enums.DocumentTypeEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DocumentTypeConverter implements AttributeConverter<DocumentTypeEnum, String> {

    @Override
    public String convertToDatabaseColumn(DocumentTypeEnum attribute) {
        // Escribe la descripción en la BD, no el name()
        return (attribute == null) ? null : attribute.getDescription();
    }

    @Override
    public DocumentTypeEnum convertToEntityAttribute(String dbData) {
        // Lee desde la BD (descripción) y devuelve el enum correspondiente
        return DocumentTypeEnum.fromValue(dbData);
    }
}

