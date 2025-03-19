package co.edu.uni.acme.aerolinea.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO {

    private String codeSeat;

    private SeatTypeDTO codeTypeSeatFk;

    private String numberSeat;

    private String groupSeat;

}
