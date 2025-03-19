package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "service")
public class ServiceEntity {

    @Id
    @Column(name = "code_service")
    private String codeService;

    @Column(name = "name_service")
    private String nameService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_service_type_fk",  referencedColumnName = "codeServiceTypeFk" )
    private ServiceTypeEntity codeServiceTypeFk;

    @Column(name = "value_service")
    private String valueService;

    @Column(name = "description_service")
    private String descriptionService;

}
