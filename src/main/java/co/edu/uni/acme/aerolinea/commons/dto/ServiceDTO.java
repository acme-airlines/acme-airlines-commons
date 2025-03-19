package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {

    private String codeService;

    private String nameService;

    private ServiceTypeDTO serviceTypeFk;

    private String valueService;

    private String descriptionService;


}
