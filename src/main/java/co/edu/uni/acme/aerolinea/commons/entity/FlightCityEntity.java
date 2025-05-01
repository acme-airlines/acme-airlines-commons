package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "flight_city")
public class FlightCityEntity {

    @Id
    @Column(name = "code_flight_city")
    private String flightCityCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_flight_fk", referencedColumnName = "code_flight")
    private FlightEntity flight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_city_fk", referencedColumnName = "code_city")
    private CityEntity city;

    @Column(name = "number_flight")
    private String numberFlight;

}
