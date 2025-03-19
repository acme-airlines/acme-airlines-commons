package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "qr")
public class QrEntity {

    @Id
    @Column(name = "codigo_qr", nullable = false)
    private String codigoQr;

    @Column(name = "date_created_qr", nullable = false)
    private LocalDate DateCreatedQr;

    @Column(name = "date_expired_qr", nullable = false)
    private LocalDate DateExpiredQr;

    @Column(name = "imagen_qr", nullable = false)
    private byte[] imagenQr;
}
