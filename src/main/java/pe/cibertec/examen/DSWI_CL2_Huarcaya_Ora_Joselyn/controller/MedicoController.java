package pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.model.bd.Medico;
import pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.service.MedicoService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/medico")

public class MedicoController {

    private MedicoService medicoService;

    @GetMapping("medicos")
    public List<Medico> getAllMedicos() {
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> getMedicoById(@PathVariable Integer id) {
        Optional<Medico> medico = medicoService.findById(id);
        return medico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Medico createMedico(@RequestBody Medico medico) {
        return medicoService.guardarMedico(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable Integer id, @RequestBody Medico medicoDetails) {
        Medico updatedMedico = medicoService.actualizarMedico(id, medicoDetails);
        if (updatedMedico.getIdmedico() != null) {
            return ResponseEntity.ok(updatedMedico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
