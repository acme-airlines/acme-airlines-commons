package co.edu.uni.acme.aerolinea.commons.dto;


import co.edu.uni.acme.aerolinea.commons.entity.FlightEntity;
import co.edu.uni.acme.aerolinea.commons.entity.PassengerEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class PassengerFlightDto {
    private PassengerFlightIdDto id;

    private PassengerDto passenger;

    private FlightDTO flight;
}
