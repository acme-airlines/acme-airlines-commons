package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class ServicePassengerExtraDto {

    @Data
    @NoArgsConstructor
    public static class Id implements Serializable {
        private String codePassenger;

        private String codeService;
    }

    private Id id;

    private PassengerDto passenger;

    private ServiceDTO service;
}
