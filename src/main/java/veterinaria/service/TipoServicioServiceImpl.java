package veterinaria.service;

import java.util.List;
import org.springframework.stereotype.Service;
import veterinaria.domain.TipoServicio;
import veterinaria.repository.TipoServicioRepository;

@Service
public class TipoServicioServiceImpl implements TipoServicioService {

    private final TipoServicioRepository repository;

    public TipoServicioServiceImpl(TipoServicioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TipoServicio> listar() {
        return repository.findAll();
    }

    @Override
    public TipoServicio buscar(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void guardar(TipoServicio tipoServicio) {
        repository.save(tipoServicio);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
