package pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.model.bd.Especialidad;
import pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.repository.EspecialidadRepository;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service

public class EspecialidadService implements IEspecialidadService {

    private EspecialidadRepository especialidadRepository;

    @Override
    public List<Especialidad> findAll() {
        return especialidadRepository.findAll();
    }

    @Override
    public Optional<Especialidad> findById(Integer id) {
        Optional<Especialidad> especialidad
                = especialidadRepository.findById(id);
        if(especialidad.isEmpty()){
            return Optional.empty();
        }
        return especialidad;
    }

    @Override
    public Especialidad guardarEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad ActualizarEspecialidad(Integer id, Especialidad especialidad) {
        if (especialidadRepository.existsById(id)) {
            especialidad.setIdEspecialidad(id);
            return especialidadRepository.save(especialidad);
        }
        return especialidad;
    }
}
