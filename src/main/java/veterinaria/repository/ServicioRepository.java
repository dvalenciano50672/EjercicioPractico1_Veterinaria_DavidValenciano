package veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import veterinaria.domain.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

}
