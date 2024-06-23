package pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.service;

import pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.model.bd.Especialidad;
import pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.model.bd.Medico;

import java.util.List;
import java.util.Optional;

public interface IEspecialidadService {
    List<Especialidad> findAll();
    Optional<Especialidad> findById(Integer id);
    Especialidad guardarEspecialidad(Especialidad especialidad);
    Especialidad ActualizarEspecialidad(Integer id, Especialidad especialidad);
}
