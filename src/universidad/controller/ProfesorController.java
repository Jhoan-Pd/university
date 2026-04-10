package universidad.controller;

import universidad.model.Profesor;
import universidad.model.Estudiante;
import universidad.service.ProfesorService;

public class ProfesorController {
    private ProfesorService profesorService;

    public ProfesorController() {
        this.profesorService = new ProfesorService();
    }

    public void registrarProfesor(String nombre, String correo, String especialidad) {
        Profesor prof = new Profesor(nombre, correo, especialidad);
        profesorService.registrar(prof);
    }

    public void probarAutenticacion(String correo, String password) {
        for (Profesor p : profesorService.obtenerTodos()) {
            if (p.getCorreo().equals(correo)) {
                profesorService.autenticar(p, password);
                return;
            }
        }
        System.out.println("[Controller] Error: Profesor no encontrado.");
    }

    public void evaluarEstudiante(String correoProfesor, Estudiante est, double nota) {
        if (est == null) {
            System.out.println("[Controller] Error: El estudiante a evaluar no existe.");
            return;
        }

        for (Profesor p : profesorService.obtenerTodos()) {
            if (p.getCorreo().equals(correoProfesor)) {
                profesorService.evaluar(p, est, nota);
                return;
            }
        }
        System.out.println("[Controller] Error: Profesor no encontrado para evaluar.");
    }
}
