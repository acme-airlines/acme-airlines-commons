package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "flight_promotion")
public class FlightPromotionEntity {

    @Id
    @Column(name = "code_flight_promotion")
    private String codeFlightPromotion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_promotion_fk",  referencedColumnName = "code_promotion" )
    private PromotionEntity codePromotionFk;

    @Column(name = "flight_start_time")
    private LocalDate flightStartTime;

    @Column(name = "flight_end_time")
    private LocalDate flightEndTime;

    @Column(name = "flight_date")
    private LocalDate flightDate;
}

