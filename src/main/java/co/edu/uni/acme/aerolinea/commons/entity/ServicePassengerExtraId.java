package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServicePassengerExtraId implements Serializable {

    @Column(name = "code_passenger", length = 10)
    private String codePassenger;

    @Column(name = "code_service", length = 10)
    private String codeService;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServicePassengerExtraId)) return false;
        ServicePassengerExtraId that = (ServicePassengerExtraId) o;
        return Objects.equals(codePassenger, that.codePassenger) &&
                Objects.equals(codeService, that.codeService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codePassenger, codeService);
    }

}

