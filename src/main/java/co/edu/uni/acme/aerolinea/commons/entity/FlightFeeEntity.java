package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "flight_fee")
public class FlightFeeEntity {

    @Id
    @Column(name = "code_flight_fee")
    private String codeFlightFee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_flight_fk", referencedColumnName = "codeFlightFk")
    private FlightEntity codeFlightFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_fee_fk", referencedColumnName = "codeFeeFk")
    private FeeEntity codeFeeFk;
}
