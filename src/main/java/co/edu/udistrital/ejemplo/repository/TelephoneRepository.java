package co.edu.udistrital.ejemplo.repository;

import co.edu.udistrital.ejemplo.domain.Telephone;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Telephone entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long> {

}
