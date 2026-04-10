package universidad.service;

import universidad.model.Administrativo;
import java.util.ArrayList;
import java.util.List;

public class AdministrativoService {
    private List<Administrativo> administrativos = new ArrayList<>();

    public void registrar(Administrativo admin) {
        administrativos.add(admin);
        System.out.println("[Service] Administrativo registrado: " + admin.getNombre());
    }

    public List<Administrativo> obtenerTodos() {
        return administrativos;
    }

    public void autenticar(Administrativo admin, String password) {
        boolean exito = admin.login(admin.getCorreo(), password);
        System.out.println("[Service] Autenticación Administrativo (" + admin.getCorreo() + "): " + (exito ? "Exitosa" : "Fallida"));
    }

    public void aprobarSolicitud(Administrativo admin, String codigoSolicitud) {
        admin.aprobarSolicitud(codigoSolicitud);
    }

    public void enviarNotificacion(Administrativo admin, String mensaje) {
        admin.enviarNotificacion(mensaje);
    }
}
