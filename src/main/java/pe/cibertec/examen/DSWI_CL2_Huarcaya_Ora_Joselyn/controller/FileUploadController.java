package pe.cibertec.examen.DSWI_CL2_Huarcaya_Ora_Joselyn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
public class FileUploadController {

    // Directorio donde se guardarán los archivos
    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/uploadMultiple")
    public ResponseEntity<String> uploadMultipleFiles(MultipartHttpServletRequest request) {
        List<MultipartFile> files = request.getFiles("files");

        if (files.size() != 3) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Debe subir exactamente 3 archivos.");
        }

        for (MultipartFile file : files) {
            String filename = file.getOriginalFilename();
            if (filename == null || (!filename.endsWith(".pdf") && !filename.endsWith(".png") && !filename.endsWith(".docx"))) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Solo se permiten archivos con extensiones pdf, png, docx.");
            }
        }

        // Crear directorio si no existe
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Lógica para guardar los archivos
        try {
            for (MultipartFile file : files) {
                Path filePath = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
                Files.write(filePath, file.getBytes());
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar los archivos: " + e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("Archivos subidos exitosamente.");
    }

    @PostMapping("/uploadSingle")
    public ResponseEntity<String> uploadSingleFile(@RequestParam("file") MultipartFile file) {
        if (file.getSize() > 25 * 1024 * 1024) { // 25MB
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El archivo supera el tamaño máximo permitido de 25MB.");
        }

        // Crear directorio si no existe
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Lógica para guardar el archivo
        try {
            Path filePath = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
            Files.write(filePath, file.getBytes());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el archivo: " + e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("Archivo subido exitosamente.");
    }
}
