package co.edu.uni.acme.aerolinea.commons.dto;

import jakarta.validation.constraints.*;
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

    @NotBlank(message = "El nombre del pasajero es obligatorio")
    private String nameUser;

    @NotBlank(message = "El apellido del pasajero es obligatorio")
    private String lastNameUser;

    @NotBlank(message = "El número de teléfono es obligatorio")
    @Pattern(regexp = "\\d{7,15}", message = "El número de teléfono debe tener entre 7 y 15 dígitos")
    private String phoneUser;

    @NotNull(message = "El tipo de documento es obligatorio")
    private DocumentTypeDTO documentTypeUserFk;

    @NotBlank(message = "El número de documento es obligatorio")
    private String numberDocumentUser;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico debe ser válido")
    private String emailUser;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate birthDate;

    private LocalDate creationDate;

    @NotBlank(message = "El género es obligatorio")
    @Pattern(regexp = "M|F", message = "El género debe ser M, F")
    private String genderUser;

    private String hashPassword;

    private FlightDTO codeFlightFk;
}
