package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServicePassengerExtraIdDto {

    private String codePassenger;

    private String codeService;

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServicePassengerExtraIdDto)) return false;
        ServicePassengerExtraIdDto that = (ServicePassengerExtraIdDto) o;
        return Objects.equals(codePassenger, that.codePassenger) &&
                Objects.equals(codeService, that.codeService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codePassenger, codeService);
    }


}
