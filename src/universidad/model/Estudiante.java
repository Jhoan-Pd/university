package universidad.model;

public class Estudiante extends Persona implements Notificable, Autenticable {
    private String codigo;

    public Estudiante(String nombre, String correo, String codigo) {
        super(nombre, correo);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando notificación a estudiante " + getNombre() + ": " + mensaje);
    }

    @Override
    public boolean login(String usuario, String password) {
        // Implementación dummy de autenticación
        return this.correo.equals(usuario) && password != null;
    }
}
