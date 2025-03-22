package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "invoice")
public class InvoiceEntity {

    @Id
    @Column(name = "code_invoice")
    private String codeInvoice;

    @Column(name = "description_invoice")
    private String descriptionInvoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_payment_fk",  referencedColumnName = "code_payment" )
    private PaymentEntity codePaymentFk;

    @Column(name = "url_invoice")
    private String urlInvoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_qr_fk")
    private QrEntity codigoQrFk;
}
