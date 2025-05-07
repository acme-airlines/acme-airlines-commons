package co.edu.uni.acme.aerolinea.commons.dto;


import co.edu.uni.acme.aerolinea.commons.entity.PassengerEntity;
import lombok.Data;

@Data
public class EmergencyInformationDto {
    private Long id;
    private String name;
    private String phone;
    private String relationShip;
    private PassengerDto passenger;
}

