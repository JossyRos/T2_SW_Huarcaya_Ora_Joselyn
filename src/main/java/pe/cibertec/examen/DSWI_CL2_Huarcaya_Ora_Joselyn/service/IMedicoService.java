package pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.service;

import pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.model.bd.Medico;

import java.util.List;
import java.util.Optional;

public interface IMedicoService {
    List<Medico> findAll();
    Optional<Medico> findById(Integer id);
    Medico guardarMedico(Medico medico);
    Medico actualizarMedico(Integer id, Medico medico);
}
