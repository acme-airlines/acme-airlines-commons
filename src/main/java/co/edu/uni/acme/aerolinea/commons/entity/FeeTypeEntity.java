package co.edu.uni.acme.aerolinea.commons.entity;

import co.edu.uni.acme.aerolinea.commons.utils.enums.FeeTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fee_type")
public class FeeTypeEntity {

    @Id
    @Column(name = "code_fee_type")
    private String codeFeeType;

    @Column(name = "name_fee_type")
    @Enumerated(EnumType.STRING)
    private FeeTypeEnum nameFeeType;

}
