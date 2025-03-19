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
public class PassengerDTO {

    private String codePassenger;

    private String namePassenger;

    private String lastNamePassenger;

    private String phonePassenger;

    private DocumentTypeDTO documentTypePassengerFk;

    private String numberDocumentPassenger;

    private String emailPassenger;

    private LocalDate birthDate;

    private LocalDate creationDate;

    private String genderPassenger;

    private String hashPassword;
}
