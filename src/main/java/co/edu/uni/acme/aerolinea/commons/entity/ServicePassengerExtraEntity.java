package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "service_passenger_extra", schema = "acme_airlines")
@Data
@NoArgsConstructor
public class ServicePassengerExtraEntity {

    @Embeddable
    @Data
    @NoArgsConstructor
    public static class Id implements Serializable {
        @Column(name = "code_passenger", length = 10)
        private String codePassenger;

        @Column(name = "code_service", length = 10)
        private String codeService;
    }

    @EmbeddedId
    private Id id;

    @MapsId("codePassenger")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_passenger")
    private PassengerEntity passenger;

    @MapsId("codeService")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_service")
    private ServiceEntity service;

}
