package universidad.controller;

import universidad.model.Administrativo;
import universidad.service.AdministrativoService;

public class AdministrativoController {
    private AdministrativoService administrativoService;

    public AdministrativoController() {
        this.administrativoService = new AdministrativoService();
    }

    public void registrarAdministrativo(String nombre, String correo, String area) {
        Administrativo admin = new Administrativo(nombre, correo, area);
        administrativoService.registrar(admin);
    }

    public void probarAutenticacion(String correo, String password) {
        for (Administrativo a : administrativoService.obtenerTodos()) {
            if (a.getCorreo().equals(correo)) {
                administrativoService.autenticar(a, password);
                return;
            }
        }
        System.out.println("[Controller] Error: Administrativo no encontrado.");
    }

    public void aprobarDocumento(String correoAdmin, String codigoSolicitud) {
        for (Administrativo a : administrativoService.obtenerTodos()) {
            if (a.getCorreo().equals(correoAdmin)) {
                administrativoService.aprobarSolicitud(a, codigoSolicitud);
                return;
            }
        }
        System.out.println("[Controller] Error: Administrativo no encontrado para aprobar.");
    }
}
