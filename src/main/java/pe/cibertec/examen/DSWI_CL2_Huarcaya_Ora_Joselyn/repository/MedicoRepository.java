package pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.model.bd.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
