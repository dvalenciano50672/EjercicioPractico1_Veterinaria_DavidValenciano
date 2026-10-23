package veterinaria.service;

import java.util.List;
import veterinaria.domain.TipoServicio;

public interface TipoServicioService {

    List<TipoServicio> listar();

    TipoServicio buscar(Integer id);

    void guardar(TipoServicio tipoServicio);

    void eliminar(Integer id);
}
