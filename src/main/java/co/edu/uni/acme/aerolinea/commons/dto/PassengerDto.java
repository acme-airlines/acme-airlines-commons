package co.edu.uni.acme.aerolinea.commons.dto;

import co.edu.uni.acme.aerolinea.commons.entity.FeeEntity;
import co.edu.uni.acme.aerolinea.commons.entity.PassengerEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
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

}
