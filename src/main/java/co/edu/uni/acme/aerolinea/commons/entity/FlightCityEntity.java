package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "flight_city")
public class FlightCityEntity {

    @Id
    @Column(name = "code_flight_city")
    private String codeFlightCity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_flight_fk", referencedColumnName = "code_flight")
    private FlightEntity codeFlightFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_city_fk", referencedColumnName = "code_city")
    private CityEntity codeCityFk;

}
