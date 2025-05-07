package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeeServiceTypeDTO {

    private FeeTypeDTO codeFeeFk;

    private ServiceDTO codeServiceFk;

    private String status;

}
