package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payment_flight_passenger")
public class PaymentFlightPassengerEntity {

    @Id
    @Column(name = "code_payment_flight_pass")
    private String codePaymentFlightPassenger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_flight_fk",  referencedColumnName = "codeFlightFk" )
    private FlightEntity codeFlightFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_passenger_fk",  referencedColumnName = "codePassengerFk" )
    private PassengerEntity codePassengerFk;
}
