package co.edu.uni.acme.aerolinea.commons.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "city")
public class CityEntity {

    @Id
    @Column(name = "code_city")
    private String codeCity;

    @Column(name = "name_city")
    private String nameCity;
}
