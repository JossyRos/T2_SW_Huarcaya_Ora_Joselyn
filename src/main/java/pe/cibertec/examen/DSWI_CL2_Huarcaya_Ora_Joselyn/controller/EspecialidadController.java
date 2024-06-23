package pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.model.bd.Especialidad;
import pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.service.EspecialidadService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/especialidad")
public class EspecialidadController {

    private EspecialidadService especialidadService;

    @GetMapping
    public List<Especialidad> getAllEspecialidades() {
        return especialidadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> getEspecialidadById(@PathVariable Integer id) {
        Optional<Especialidad> especialidad = especialidadService.findById(id);
        return especialidad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Especialidad AgregarEspecialidad(@RequestBody Especialidad especialidad) {
        return especialidadService.guardarEspecialidad(especialidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> ActualizarEspecialidad(@PathVariable Integer id, @RequestBody Especialidad especialidadDetails) {
        Especialidad updatedEspecialidad = especialidadService.ActualizarEspecialidad(id, especialidadDetails);
        if (updatedEspecialidad.getIdEspecialidad() != null) {
            return ResponseEntity.ok(updatedEspecialidad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


