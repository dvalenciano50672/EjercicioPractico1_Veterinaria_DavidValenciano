package veterinaria.service;

import java.util.List;
import veterinaria.domain.Servicio;

public interface ServicioService {

    List<Servicio> listar();

    Servicio buscar(Integer id);

    void guardar(Servicio servicio);

    void eliminar(Integer id);
}
