package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionDTO {

    private String codePromotion;

    private LocalDate daysOfValidity;

    private String valuePromotion;

    private PromotionTypeDTO promotionTypeFk;

}
