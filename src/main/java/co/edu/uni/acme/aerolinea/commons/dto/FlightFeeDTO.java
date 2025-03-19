package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightFeeDTO {

    private String codeFlightFee;

    private FlightDTO codeFlightFk;

    private FeeDTO codeFeeFk;

    private String status;
}
