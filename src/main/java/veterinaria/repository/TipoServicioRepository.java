package veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import veterinaria.domain.TipoServicio;

public interface TipoServicioRepository extends JpaRepository<TipoServicio, Integer> {

}