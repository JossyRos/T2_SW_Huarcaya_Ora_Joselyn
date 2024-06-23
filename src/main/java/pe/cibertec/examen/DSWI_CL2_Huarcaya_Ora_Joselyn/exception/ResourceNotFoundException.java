package pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
