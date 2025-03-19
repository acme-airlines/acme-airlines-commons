package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "passenger")
public class PassengerEntity {

    @Id
    @Column(name = "code_passenger")
    private String codePassenger;

    @Column(name = "name_passenger")
    private String namePassenger;

    @Column(name = "lastname_passenger")
    private String lastNamePassenger;

    @Column(name = "phone_passenger")
    private String phonePassenger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_passenger",  referencedColumnName = "codeTypeDocument" )
    private DocumentTypeEntity documentTypePassengerFk;

    @Column(name = "number_document_passenger")
    private String numberDocumentPassenger;

    @Column(name = "email_passenger")
    private String emailPassenger;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "gender_passenger")
    private String genderPassenger;

    @Column(name = "hash_password", nullable = false, length = 100)
    private String hashPassword;
}
