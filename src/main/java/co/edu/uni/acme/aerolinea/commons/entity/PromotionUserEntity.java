package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "promotion_user")
public class PromotionUserEntity {

    @Id
    @Column(name = "code_promotion_user")
    private String codePromotionUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_user_fk",  referencedColumnName = "code_user" )
    private UserEntity codeUserFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_promotion_fk",  referencedColumnName = "code_promotion" )
        private PromotionEntity codePromotionFk;


}
