package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserDTO {

    private String codeUser;

    private String nameUser;

    private String lastNameUser;

    private String phoneUser;

    private DocumentTypeDTO documentTypeUserFk;

    private String numberDocumentUser;

    private String emailUser;

    private LocalDate birthDate;

    private LocalDate creationDate;

    private String genderUser;

    private String hashPassword;
}
