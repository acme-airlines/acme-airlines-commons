package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QrDTO {

    private String codeQr;

    private LocalDateTime DateCreatedQr;

    private LocalDateTime DateExpiredQr;

    private byte[] imagenQr;


}
