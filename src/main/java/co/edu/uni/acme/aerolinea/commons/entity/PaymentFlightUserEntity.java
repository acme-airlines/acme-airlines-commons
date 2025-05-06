package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payment_flight_user")
public class PaymentFlightUserEntity {

    @Id
    @Column(name = "code_payment_flight_user")
    private String codeUserFlightUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_flight_fk",  referencedColumnName = "code_flight" )
    private FlightEntity codeFlightFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_user_fk",  referencedColumnName = "code_user" )
    private UserEntity codeUserFk;
}
