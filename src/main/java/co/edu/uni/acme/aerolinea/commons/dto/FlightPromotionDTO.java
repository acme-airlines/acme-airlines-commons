package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightPromotionDTO {

    private String codeFlightPromotion;

    private PromotionDTO codePromotionFk;

    private LocalTime flightStartTime;

    private LocalTime flightEndTime;

    private LocalDate flightDate;


}
