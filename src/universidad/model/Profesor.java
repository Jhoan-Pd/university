package universidad.model;

public class Profesor extends Persona implements Autenticable, Evaluador {
    private String especialidad;

    public Profesor(String nombre, String correo, String especialidad) {
        super(nombre, correo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public boolean login(String usuario, String password) {
        // Implementación dummy de autenticación
        return this.correo.equals(usuario) && password != null;
    }

    @Override
    public void evaluar(Estudiante estudiante, double nota) {
        System.out.println("Profesor " + getNombre() + " evaluó al estudiante " + estudiante.getNombre() + " con nota " + nota);
    }
}
