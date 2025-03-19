package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionPassengerDTO {

    private String codePromotionPassenger;

    private PassengerDTO codePassengerFk;

    private PromotionDTO codePromotionFk;
}
