package universidad.service;

import universidad.model.Estudiante;
import java.util.ArrayList;
import java.util.List;

public class EstudianteService {
    private List<Estudiante> estudiantes = new ArrayList<>();

    public void registrar(Estudiante estudiante) {
        estudiantes.add(estudiante);
        System.out.println("[Service] Estudiante registrado: " + estudiante.getNombre());
    }

    public List<Estudiante> obtenerTodos() {
        return estudiantes;
    }

    public void autenticar(Estudiante estudiante, String password) {
        boolean exito = estudiante.login(estudiante.getCorreo(), password);
        System.out.println("[Service] Autenticación Estudiante (" + estudiante.getCorreo() + "): " + (exito ? "Exitosa" : "Fallida"));
    }

    public void enviarNotificacion(Estudiante estudiante, String mensaje) {
        estudiante.enviarNotificacion(mensaje);
    }
}
