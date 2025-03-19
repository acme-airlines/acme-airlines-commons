package co.edu.uni.acme.aerolinea.commons.utils.enums;

public enum DocumentTypeEnum {

    CC("Identity Card"),
    CE("Alien Identity Card"),
    PAS("Passport");

    private final String description;

    DocumentTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
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
