package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(name = "code_user")
    private String codeUser;

    @Column(name = "name_user")
    private String nameUser;

    @Column(name = "lastname_user")
    private String lastNameUser;

    @Column(name = "phone_user")
    private String phoneUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_user",  referencedColumnName = "code_document_type" )
    private DocumentTypeEntity documentTypeUserFk;

    @Column(name = "number_document_user")
    private String numberDocumentUser;

    @Column(name = "email_user")
    private String emailUser;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "gender_user")
    private String genderUser;

    @Column(name = "hash_password", nullable = false, length = 100)
    private String hashPassword;
}
