package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private String codePayment;

    private PaymentFlightUserDTO codePaymentFlightUserDTO;

    private LocalDate datePayment;

    private LocalTime timePayment;

    private String totalPayment;

    private LocalDate dateCreated;
}
