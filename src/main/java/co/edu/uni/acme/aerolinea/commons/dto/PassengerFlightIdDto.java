package co.edu.uni.acme.aerolinea.commons.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PassengerFlightIdDto implements Serializable {

    private String passengerCode;

    private String flightCode;

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerFlightIdDto)) return false;
        PassengerFlightIdDto that = (PassengerFlightIdDto) o;
        return Objects.equals(passengerCode, that.passengerCode) &&
                Objects.equals(flightCode, that.flightCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerCode, flightCode);
    }

}
