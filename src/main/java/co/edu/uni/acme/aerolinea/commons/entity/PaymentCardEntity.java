package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment_card", schema = "acme_airlines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCardEntity {

    @Id
    @Column(name = "code_card", length = 255, nullable = false)
    private String codeCard;

    @Column(name = "card_number", length = 20, nullable = false)
    private String cardNumber;

    @Column(name = "card_holder_name", length = 100, nullable = false)
    private String cardHolderName;

    @Column(name = "expiry_month", nullable = false)
    private Integer expiryMonth;

    @Column(name = "expiry_year", nullable = false)
    private Integer expiryYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_card_type_fk", referencedColumnName = "code_card_type")
    private CardTypeEntity cardType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_user_fk", referencedColumnName = "code_user", nullable = false)
    private UserEntity user;

}
