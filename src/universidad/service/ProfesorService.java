package universidad.service;

import universidad.model.Profesor;
import universidad.model.Estudiante;
import java.util.ArrayList;
import java.util.List;

public class ProfesorService {
    private List<Profesor> profesores = new ArrayList<>();

    public void registrar(Profesor profesor) {
        profesores.add(profesor);
        System.out.println("[Service] Profesor registrado: " + profesor.getNombre());
    }

    public List<Profesor> obtenerTodos() {
        return profesores;
    }

    public void autenticar(Profesor profesor, String password) {
        boolean exito = profesor.login(profesor.getCorreo(), password);
        System.out.println("[Service] Autenticación Profesor (" + profesor.getCorreo() + "): " + (exito ? "Exitosa" : "Fallida"));
    }

    public void evaluar(Profesor profesor, Estudiante estudiante, double nota) {
        profesor.evaluar(estudiante, nota);
    }
}
