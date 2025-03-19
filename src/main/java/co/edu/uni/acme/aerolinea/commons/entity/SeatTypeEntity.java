package co.edu.uni.acme.aerolinea.commons.entity;

import co.edu.uni.acme.aerolinea.commons.utils.enums.SeatTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "seat_type")
public class SeatTypeEntity {

    @Id
    @Column(name = "code_seat_type")
    private String codeTypeSeat;

    @Column(name = "name_seat_type")
    @Enumerated(EnumType.STRING)
    private SeatTypeEnum nameSeatType;
}
