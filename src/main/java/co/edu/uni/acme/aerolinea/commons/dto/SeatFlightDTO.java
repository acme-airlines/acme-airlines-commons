package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatFlightDTO {

    private String codeSeatFlight;

    private FlightDTO codeFlightFk;

    private SeatDTO codeSeatFk;

    private String status;
}
