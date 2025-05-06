package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.Data;

@Data
public class PassengerDto {

    private String code;

    private String firstName;

    private String lastName;

    private String document;

    private String age;

    private String role;

    private DocumentTypeDTO typeDocument;

}
