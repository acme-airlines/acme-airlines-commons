package co.edu.uni.acme.aerolinea.commons.dto;

import co.edu.uni.acme.aerolinea.commons.utils.enums.SeatTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatTypeDTO {

    private String codeTypeSeat;

    private SeatTypeEnum nameSeatType;
}
