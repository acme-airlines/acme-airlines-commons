package co.edu.uni.acme.aerolinea.commons.entity;

import co.edu.uni.acme.aerolinea.commons.utils.enums.PromotionTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "promotion_type")
public class PromotionTypeEntity {

    @Id
    @Column(name = "code_promotion_type")
    private String codePromotionType;

    @Column(name = "name_promotion_type")
    @Enumerated(EnumType.STRING)
    private PromotionTypeEnum namePromotionType;
}
