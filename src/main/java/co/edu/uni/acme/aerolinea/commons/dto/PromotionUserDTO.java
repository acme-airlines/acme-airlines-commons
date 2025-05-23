package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionUserDTO {

    private String codePromotionUser;

    private UserDTO codeUserFk;

    private PromotionDTO codePromotionFk;
}
