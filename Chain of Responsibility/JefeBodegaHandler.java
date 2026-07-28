public class JefeBodegaHandler extends BaseHandler {
    @Override
    public boolean handle(SolicitudCambio solicitud) {
        if (!solicitud.isExisteEnBodega()) {
            System.out.println("Jefe de Bodega: No existe stock disponible para reposición.");
            return false;
        }
        System.out.println("Jefe de Bodega: Existencia en bodega certificada.");
        return super.handle(solicitud);
    }
}
