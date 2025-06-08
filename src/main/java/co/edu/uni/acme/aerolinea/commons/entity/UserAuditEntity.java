package co.edu.uni.acme.aerolinea.commons.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "user_audit")
@NoArgsConstructor
@AllArgsConstructor
public class UserAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_audit")
    private Long idAudit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_user",  referencedColumnName = "code_user" )
    private UserEntity codeUser;

    @Column(name = "event_timestamp", nullable = false)
    private OffsetDateTime eventTimestamp;

    @Column(name = "action", nullable = false, length = 50)
    private String action;

}
