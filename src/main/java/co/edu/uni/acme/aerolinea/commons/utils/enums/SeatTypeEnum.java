package co.edu.uni.acme.aerolinea.commons.utils.enums;

public enum SeatTypeEnum {

    ECONOMY("Economy Class"),
    PREMIUM_ECONOMY("Premium Economy"),
    BUSINESS("Business Class"),
    FIRST_CLASS("First Class");

    private final String description;

    SeatTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
