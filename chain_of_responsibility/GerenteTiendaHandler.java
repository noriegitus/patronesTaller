package chain_of_responsibility;

public class GerenteTiendaHandler extends BaseHandler {
    @Override
    public boolean handle(SolicitudCambio solicitud) {
        if (solicitud.getProducto().getPrecio() > 1000) {
            System.out.println("Gerente de Tienda: Aprobación requerida por superar los $1000 USD. APROBADO.");
        } else {
            System.out.println("Gerente de Tienda: No requiere aprobación especial (menor a $1000 USD).");
        }
        return super.handle(solicitud);
    }
}
