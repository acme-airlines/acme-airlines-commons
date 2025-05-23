package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "service_flight_extra")
public class ServiceFlightExtraEntity {

    @Id
    @Column(name = "code_service_flight_extra")
    private String codeServiceFlightExtra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_service_fk",  referencedColumnName = "code_service" )
    private ServiceEntity codeServiceFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_flight_fk",  referencedColumnName = "code_flight" )
    private FlightEntity codeFlightFk;

    @Column(name = "status")
    private String status;

    @Column(name = "quantity")
    private Long quantity;

}
