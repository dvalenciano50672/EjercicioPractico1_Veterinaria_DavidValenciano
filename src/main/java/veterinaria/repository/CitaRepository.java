package veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import veterinaria.domain.Cita;

public interface CitaRepository extends JpaRepository<Cita, Integer> {

}
