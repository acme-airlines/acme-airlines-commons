package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "passenger")
@Data
public class PassengerEntity {

    @Id
    @Column(name = "code_passenger", length = 10)
    private String code;

    @Column(name = "name_passenger", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name_passenger", nullable = false, length = 50)
    private String lastName;

    @Column(name = "document_passenger", nullable = false, length = 12)
    private String document;

    @Column(name = "age_passenger", length = 3)
    private String age;

    @Column(name = "rol_passenger", length = 30)
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_document_passenger", nullable = false)
    private DocumentTypeEntity typeDocument;

    // Nuevo campo email
    @Column(name = "email_passenger", length = 100)
    private String email;

    // Nueva fecha de nacimiento
    @Column(name = "birth_date_passenger")
    private LocalDate birthDate;

    // Nuevo campo parentesco
    @Column(name = "relation_ship_passenger", length = 30)
    private String relationship;

    // Relación hacia otro pasajero como acompañante
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companion_passenger", nullable = true)
    private PassengerEntity companion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fee_flight_passenger", nullable = true)
    private FeeEntity fee;
}
