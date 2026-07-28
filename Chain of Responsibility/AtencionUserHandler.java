public class AtencionUserHandler extends BaseHandler {
    @Override
    public boolean handle(SolicitudCambio solicitud) {
        if (!solicitud.isDentroDeGarantia()) {
            System.out.println("Atención al Cliente: El producto está fuera del periodo de garantía.");
            return false;
        }
        System.out.println("Atención al Cliente: Periodo de garantía validado.");
        return super.handle(solicitud);
    }
}
