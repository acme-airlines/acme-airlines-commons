package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "promotion_passenger")
public class PromotionPassengerEntity {

    @Id
    @Column(name = "code_promotion_passenger")
    private String codePromotionPassenger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_passenger_fk",  referencedColumnName = "codePassengerFk" )
    private PassengerEntity codePassengerFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_promotion_fk",  referencedColumnName = "codePromotionFk" )
        private PromotionEntity codePromotionFk;


}
