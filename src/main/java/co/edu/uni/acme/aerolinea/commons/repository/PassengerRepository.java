package co.edu.uni.acme.aerolinea.commons.repository;

import co.edu.uni.acme.aerolinea.commons.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, String> {

    Optional<PassengerEntity> findByEmailPassenger(String emailPassenger);

}
