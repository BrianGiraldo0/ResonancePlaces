package co.edu.uniquindio.resonance.repositorios;

import co.edu.uniquindio.resonance.entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepo extends JpaRepository<Horario,Integer> {
}
