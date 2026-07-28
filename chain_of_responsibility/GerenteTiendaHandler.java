package chain_of_responsibility;

public class GerenteTiendaHandler extends BaseHandler {
    @Override
    public void handle(SolicitudCambio solicitud) { 
        if (solicitud.getMonto() > 1000) {
            System.out.println("Gerente de Tienda: Aprobación requerida por superar los $1000 USD. APROBADO.");
            super.handle(solicitud); 
        } else {
            System.out.println("Gerente de Tienda: No requiere aprobación especial (menor a $1000 USD).");
            super.handle(solicitud);
        }
    }
}
