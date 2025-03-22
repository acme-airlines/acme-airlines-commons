package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "seat")
public class SeatEntity {

    @Id
    @Column(name = "code_seat")
    private String codeSeat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_type_service_fk",  referencedColumnName = "code_seat_type" )
    private SeatTypeEntity codeTypeSeatFk;

    @Column(name = "number_seat")
    private String numberSeat;

    @Column(name = "group_seat")
    private String groupSeat;
}
