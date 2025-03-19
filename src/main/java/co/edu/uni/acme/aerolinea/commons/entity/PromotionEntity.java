package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "promotion")
public class PromotionEntity {

    @Id
    @Column(name = "code_promotion")
    private String codePromotion;

    @Column(name = "days_of_validity")
    private LocalDate daysOfValidity;

    @Column(name = "value_promotion")
    private String valuePromotion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_type_fk",  referencedColumnName = "codePromotionTypeFk" )
    private PromotionTypeEntity codePromotionTypeFk;

}
