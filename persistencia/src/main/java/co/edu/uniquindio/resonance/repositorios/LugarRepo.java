package co.edu.uniquindio.resonance.repositorios;

import co.edu.uniquindio.resonance.entidades.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase Repository para la entidad Lugar
 * @author Brian Giraldo - Cesar Marquez - Esteban Sanchez
 */
@Repository
public interface LugarRepo extends JpaRepository<Lugar, Integer>{
}
