package co.edu.uni.acme.aerolinea.commons.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "card_type", schema = "acme_airlines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardTypeEntity {

    @Id
    @Column(name = "code_card_type", length = 50, nullable = false)
    private String codeCardType;

    @Column(name = "name_card_type", length = 100, nullable = false)
    private String nameCardType;

}
