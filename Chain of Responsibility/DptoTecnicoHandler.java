public class DptoTecnicoHandler extends BaseHandler {
    @Override
    public boolean handle(SolicitudCambio solicitud) {
        if (!solicitud.isFalloCubierto()) {
            System.out.println("Dpto. Técnico: El tipo de fallo no está cubierto por la garantía.");
            return false;
        }
        System.out.println("Dpto. Técnico: Fallo validado correctamente.");
        return super.handle(solicitud);
    }
}
