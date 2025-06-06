package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightCityDTO {

    private String flightCityCode;

    private FlightDTO flight;

    private CityDTO city;

    private String numberFlight;

}
