package pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEspecialidad;

    private String Titulo;
    private String Funcion;
    private Date FechGraduacion;

    @ManyToOne
    private Medico medico;
}
