package co.edu.uni.acme.aerolinea.commons.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "passenger_flight", schema = "acme_airlines")
@Data
public class PassengerFlightEntity {
    @EmbeddedId
    private PassengerFlightId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("passengerCode")
    @JoinColumn(name = "code_passenger")
    private PassengerEntity passenger;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("flightCode")
    @JoinColumn(name = "code_flight")
    private FlightEntity flight;
}
