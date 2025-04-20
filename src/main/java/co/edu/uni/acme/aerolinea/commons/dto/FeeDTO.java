package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeeDTO {

    private String codeFee;

    private FeeTypeDTO codeFeeTypeFk;

    private String valueFee;

    private boolean available;

    private boolean refundable;

    private LocalDate availableFrom;

    private LocalDate availableTo;
}
