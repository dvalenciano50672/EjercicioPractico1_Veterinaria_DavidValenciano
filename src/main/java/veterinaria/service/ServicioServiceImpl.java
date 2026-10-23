package veterinaria.service;

import java.util.List;
import org.springframework.stereotype.Service;
import veterinaria.domain.Servicio;
import veterinaria.repository.ServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository repository;

    public ServicioServiceImpl(ServicioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Servicio> listar() {
        return repository.findAll();
    }

    @Override
    public Servicio buscar(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Servicio servicio) {
        repository.save(servicio);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
