package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fee_service_type")
public class FeeServiceTypeEntity {

    @Id
    @Column(name = "code_fee_fk")
    private String codeFeeFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_service_fk",  referencedColumnName = "codeServiceFk" )
    private ServiceEntity codeServiceFk;

     @Column(name = "status")
    private String status;
}
