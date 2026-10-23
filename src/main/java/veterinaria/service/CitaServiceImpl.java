package veterinaria.service;

import java.util.List;
import org.springframework.stereotype.Service;
import veterinaria.domain.Cita;
import veterinaria.repository.CitaRepository;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository repository;

    public CitaServiceImpl(CitaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cita> listar() {
        return repository.findAll();
    }
}
