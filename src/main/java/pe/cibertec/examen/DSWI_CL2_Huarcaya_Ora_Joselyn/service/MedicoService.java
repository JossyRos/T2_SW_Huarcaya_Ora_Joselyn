package pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.model.bd.Medico;
import pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.repository.MedicoRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MedicoService implements IMedicoService {

    private MedicoRepository medicoRepository;

    @Override
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    @Override
    public Optional<Medico> findById(Integer id) {
        Optional<Medico> medico
                = medicoRepository.findById(id);
        if(medico.isEmpty()){
            return Optional.empty();
        }
        return medico;
    }

    @Override
    public Medico guardarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public Medico actualizarMedico(Integer id, Medico medico) {
        if (medicoRepository.existsById(id)) {
            medico.setIdmedico(id);
            return medicoRepository.save(medico);
        }
        return medico;

    }
}
