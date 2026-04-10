package universidad.controller;

import universidad.model.Estudiante;
import universidad.service.EstudianteService;

public class EstudianteController {
    private EstudianteService estudianteService;

    public EstudianteController() {
        this.estudianteService = new EstudianteService();
    }

    public void registrarEstudiante(String nombre, String correo, String codigo) {
        Estudiante est = new Estudiante(nombre, correo, codigo);
        estudianteService.registrar(est);
    }

    public void probarAutenticacion(String correo, String password) {
        // En una app real, buscaríamos al estudiante por correo en la DB
        // Aquí lo buscamos en la lista en memoria
        for (Estudiante e : estudianteService.obtenerTodos()) {
            if (e.getCorreo().equals(correo)) {
                estudianteService.autenticar(e, password);
                return;
            }
        }
        System.out.println("[Controller] Error: Estudiante no encontrado.");
    }
    
    public void notificarAEstudiantes(String mensaje) {
        for (Estudiante e : estudianteService.obtenerTodos()) {
            estudianteService.enviarNotificacion(e, mensaje);
        }
    }

    // Método para obtener un estudiante (usado por otros controles en nuestro simulador)
    public Estudiante buscarPorCorreo(String correo) {
        for (Estudiante e : estudianteService.obtenerTodos()) {
            if (e.getCorreo().equals(correo)) return e;
        }
        return null;
    }
}
