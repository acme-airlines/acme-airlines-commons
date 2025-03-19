package co.edu.uni.acme.aerolinea.commons.dto;

import co.edu.uni.acme.aerolinea.commons.utils.enums.PromotionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionTypeDTO {

    private String codePromotionType;

    private PromotionTypeEnum namePromotionType;
}
