package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fee")
public class FeeEntity {

    @Id
    @Column(name = "code_fee")
    private String codeFee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_fee_type_fk", referencedColumnName = "codeFeeType")
    private FeeTypeEntity nameFeeType;

}
