package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PassengerFlightId implements Serializable {

    @Column(name = "code_passenger", length = 10)
    private String passengerCode;

    @Column(name = "code_flight", length = 10)
    private String flightCode;

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerFlightId)) return false;
        PassengerFlightId that = (PassengerFlightId) o;
        return Objects.equals(passengerCode, that.passengerCode) &&
                Objects.equals(flightCode, that.flightCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerCode, flightCode);
    }

}
