package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceFlightExtraDTO {

    private String codeServiceFlightExtra;

    private ServiceDTO codeServiceFk;

    private FlightDTO codeFlightFk;

    private String status;

    private Long quantity;

}
