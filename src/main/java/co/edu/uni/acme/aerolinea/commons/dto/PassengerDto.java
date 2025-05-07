package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PassengerDto {

    private String code;

    private String firstName;

    private String lastName;

    private String document;

    private String age;

    private String role;

    private DocumentTypeDTO typeDocument;

    private String email;

    private LocalDate birthDate;

    private String relationship;

    private PassengerDto companion;

    private FeeDTO fee;

    private String genre;

}
