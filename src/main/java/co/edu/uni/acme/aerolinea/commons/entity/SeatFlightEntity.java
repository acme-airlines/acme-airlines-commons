package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "seat_flight")
public class SeatFlightEntity {

    @Id
    @Column(name = "code_seat_flight")
    private String codeSeatFlight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_flight_fk",  referencedColumnName = "code_flight" )
    private FlightEntity codeFlightFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_seat_fk",  referencedColumnName = "code_seat" )
    private SeatEntity codeSeatFk;

    @Column(name = "status")
    private String status;
}
