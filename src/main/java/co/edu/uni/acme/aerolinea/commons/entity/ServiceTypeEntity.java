package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "service_type")
public class ServiceTypeEntity {

    @Id
    @Column(name = "code_service_type")
    private String codeServiceType;

    @Column(name = "name_service_type")
    private String nameServiceType;

}
