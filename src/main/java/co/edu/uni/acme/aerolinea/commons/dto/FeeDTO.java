package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeeDTO {

    private String codeFee;

    private FeeTypeDTO codeFeeTypeFk;

    private String valueFee;

}
