package co.edu.uni.acme.aerolinea.commons.dto;

import co.edu.uni.acme.aerolinea.commons.entity.PassengerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentFlightUserDTO {

    private String codePaymentFlightUser;

    private FlightDTO codeFlightFk;

    private UserDTO codeUserFk;

    private PassengerDto codePassengerFk;

}
