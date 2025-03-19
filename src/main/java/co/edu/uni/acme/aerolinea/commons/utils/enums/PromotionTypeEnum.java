package co.edu.uni.acme.aerolinea.commons.utils.enums;

public enum PromotionTypeEnum {

    EARLY_BIRD("Early Bird", "Discount for booking in advance"),
    LAST_MINUTE("Last Minute", "Special deals for last-minute bookings"),
    SEASONAL_DISCOUNT("Seasonal Discount", "Promotion based on holiday seasons"),
    LOYALTY_REWARD("Loyalty Reward", "Exclusive discount for frequent flyers"),
    STUDENT_DISCOUNT("Student Discount", "Special fare for students"),
    MILITARY_DISCOUNT("Military Discount", "Exclusive offer for military personnel"),
    FAMILY_PACKAGE("Family Package", "Discounts for group or family bookings"),
    WEEKEND_SPECIAL("Weekend Special", "Lower fares for weekend travel"),
    BLACK_FRIDAY("Black Friday", "Special promotions during Black Friday sales"),
    CYBER_MONDAY("Cyber Monday", "Online-exclusive airfare discounts"),
    FLASH_SALE("Flash Sale", "Limited-time discount fares");

    private String description;

    PromotionTypeEnum(String description, String nameFeeType) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
