package universidad.model;

public class Administrativo extends Persona implements Aprobador, Notificable, Autenticable {
    private String area;

    public Administrativo(String nombre, String correo, String area) {
        super(nombre, correo);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public void aprobarSolicitud(String codigoSolicitud) {
        System.out.println("Administrativo " + getNombre() + " aprobó la solicitud: " + codigoSolicitud);
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando notificación a administrativo " + getNombre() + ": " + mensaje);
    }

    @Override
    public boolean login(String usuario, String password) {
        // Implementación dummy de autenticación
        return this.correo.equals(usuario) && password != null;
    }
}
