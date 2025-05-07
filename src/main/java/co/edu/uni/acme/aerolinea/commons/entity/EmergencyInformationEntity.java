package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emergency_information", schema = "acme_airlines")
@Data
@NoArgsConstructor
public class EmergencyInformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emergency_informarion")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "relationShip", nullable = false, length = 30)
    private String relationShip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_passenger_fk", nullable = false)
    private PassengerEntity passenger;
}

