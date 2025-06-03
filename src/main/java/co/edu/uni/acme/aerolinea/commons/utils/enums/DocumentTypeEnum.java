package co.edu.uni.acme.aerolinea.commons.utils.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentTypeEnum {

    CC("Citizen Identification Card"),
    TI("Identity Card"),
    CE("Foreigner Identification Card"),
    PP("Passport"),
    RC("Birth Certificate");


    private final String description;

    DocumentTypeEnum(String description) {
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

    @JsonCreator
    public static DocumentTypeEnum fromValue(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        // Primero, intentar por código (CC, TI, CE, PP, RC)
        for (DocumentTypeEnum dt : DocumentTypeEnum.values()) {
            if (dt.name().equalsIgnoreCase(value)) {
                return dt;
            }
        }
        // Si no coinciden los códigos, probar con la descripción
        for (DocumentTypeEnum dt : DocumentTypeEnum.values()) {
            if (dt.description.equalsIgnoreCase(value)) {
                return dt;
            }
        }
        return null; // o lanzar IllegalArgumentException si prefieres
    }

    public static boolean exists(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        for (DocumentTypeEnum documentType : DocumentTypeEnum.values()) {
            if (documentType.name().equalsIgnoreCase(value) || documentType.description.equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDescription(String description) {
        if (description == null || description.isEmpty()) {
            return false;
        }
        for (DocumentTypeEnum documentType : DocumentTypeEnum.values()) {
            if (documentType.description.equalsIgnoreCase(description)) {
                return true;
            }
        }
        return false;
    }

    public static String getNameByDescription(String description) {
        if (description == null || description.isEmpty()) {
            return null;
        }
        for (DocumentTypeEnum documentType : DocumentTypeEnum.values()) {
            if (documentType.description.equalsIgnoreCase(description)) {
                return documentType.name();
            }
        }
        return null;
    }
}
