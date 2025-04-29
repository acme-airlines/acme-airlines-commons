package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {

    private String codeFlight;

    private LocalDate flightDate;

    private LocalTime flightStartTime;

    private LocalTime flightEndTime;
}
