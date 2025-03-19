package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @Column(name = "code_payment")
    private String codePayment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_payment_flight_passenger_fk",  referencedColumnName = "codePaymentFlightPassengerFk" )
    private PaymentFlightPassengerEntity codePaymentFlightPassengerFk;

    @Column(name = "date_payment")
    private LocalDate datePayment;

    @Column(name = "time_payment")
    private LocalTime timePayment;

    @Column(name = "total_payment")
    private String totalPayment;

    @Column(name = "date_created")
    private LocalDate dateCreated;
}
