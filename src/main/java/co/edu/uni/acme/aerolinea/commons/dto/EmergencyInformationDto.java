package co.edu.uni.acme.aerolinea.commons.dto;


import lombok.Data;

@Data
public class EmergencyInformationDto {
    private Long id;
    private String name;
    private String phone;
    private String relationShip;
    private String passengerCode;
}

