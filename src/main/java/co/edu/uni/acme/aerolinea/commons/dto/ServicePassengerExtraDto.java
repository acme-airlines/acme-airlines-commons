package co.edu.uni.acme.aerolinea.commons.dto;

import co.edu.uni.acme.aerolinea.commons.entity.PassengerEntity;
import co.edu.uni.acme.aerolinea.commons.entity.ServiceEntity;
import co.edu.uni.acme.aerolinea.commons.entity.ServicePassengerExtraEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class ServicePassengerExtraDto {
    public static class Id implements Serializable {
        private String codePassenger;

        private String codeService;
    }

    private Id id;

    private PassengerDto passenger;

    private ServiceDTO service;
}
