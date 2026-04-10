package universidad.controller;

import universidad.model.Estudiante;

/**
 * Clase principal para probar toda la estructura de controladores y servicios.
 */
public class MainApp {

    public static void main(String[] args) {
        System.out.println("=== Iniciando Sistema Universitario Refactorizado ===\n");

        // 1. Inicializar Controladores
        EstudianteController estController = new EstudianteController();
        ProfesorController profController = new ProfesorController();
        AdministrativoController adminController = new AdministrativoController();

        // 2. Registrar Usuarios usando Controladores
        System.out.println(">> Registrando Usuarios:");
        estController.registrarEstudiante("Carlos", "carlos@univ.edu", "12345");
        profController.registrarProfesor("Roberto", "roberto@univ.edu", "Matemáticas");
        adminController.registrarAdministrativo("Ana", "ana@univ.edu", "Finanzas");

        // 3. Probar Autenticaciones
        System.out.println("\n>> Probando Autenticaciones:");
        estController.probarAutenticacion("carlos@univ.edu", "1234");
        profController.probarAutenticacion("roberto@univ.edu", "1234");
        adminController.probarAutenticacion("ana@univ.edu", "1234");

        // 4. Probar Reglas de Negocio Específicas
        System.out.println("\n>> Probando Lógica de Negocio (Interfaces):");
        
        // Administrativo aprobando
        adminController.aprobarDocumento("ana@univ.edu", "DOC-992");
        
        // Estudiante recibiendo notificación
        estController.notificarAEstudiantes("Las clases inician la próxima semana.");
        
        // Profesor evaluando
        Estudiante estudianteObjetivo = estController.buscarPorCorreo("carlos@univ.edu");
        profController.evaluarEstudiante("roberto@univ.edu", estudianteObjetivo, 4.8);

        System.out.println("\n=== Fin de la Prueba ===");
    }
}
