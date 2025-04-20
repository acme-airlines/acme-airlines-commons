package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "fee")
public class FeeEntity {

    @Id
    @Column(name = "code_fee")
    private String codeFee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_fee_type_fk", referencedColumnName = "code_fee_type")
    private FeeTypeEntity nameFeeType;

    @Column(name = "value_fee")
    private String valueFee;

    @Column(name = "available")
    private boolean available;

    @Column(name = "refundable")
    private boolean refundable;

    @Column(name = "available_from")
    private LocalDate availableFrom;

    @Column(name = "available_to")
    private LocalDate availableTo;
}
