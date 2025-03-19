package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceDTO {

    private String codeInvoice;

    private String descriptionInvoice;

    private PaymentDTO codePaymentFk;

    private String urlInvoice;

    private QrDTO codeQrFk;
}
