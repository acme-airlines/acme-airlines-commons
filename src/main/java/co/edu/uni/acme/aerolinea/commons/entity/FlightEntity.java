package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "flight")
public class FlightEntity {

    @Id
    @Column(name = "code_flight")
    private String codeFlight;

    @Column(name = "flight_date")
    private LocalDate flightDate;

    @Column(name = "flight_start_time")
    private LocalTime flightStartTime;

    @Column(name = "flight_end_time")
    private LocalTime flightEndTime;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "capacity")
    private Integer capacity;
}
