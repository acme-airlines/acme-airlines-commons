package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.Data;


@Data
public class ServicePassengerExtraDto {

    private ServicePassengerExtraIdDto id;

    private PassengerDto passenger;

    private ServiceDTO service;

    private Long quantity;

}
