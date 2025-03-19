package co.edu.uni.acme.aerolinea.commons.utils.enums;

public enum FeeTypeEnum {

    BASIC_ECONOMY("Basic Economy", "Lowest fare with restrictions"),
    STANDARD_ECONOMY("Standard Economy", "Includes carry-on baggage, limited changes allowed"),
    FLEXIBLE_ECONOMY("Flexible Economy", "Allows changes with minimal penalty"),

    BUSINESS_DISCOUNTED("Discounted Business", "Lower-priced business class with some restrictions"),
    BUSINESS_FULL_FARE("Full-Fare Business", "Business class with no restrictions and premium benefits"),

    FIRST_CLASS_STANDARD("First Class Standard", "Luxury travel with premium services"),
    FIRST_CLASS_FLEXIBLE("First Class Flexible", "First class with full flexibility and no change fees");

    private String description;

    private FeeTypeEnum(String description, String nameFeeType) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
