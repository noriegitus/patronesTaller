package chain_of_responsibility;

public class JefeBodegaHandler extends BaseHandler {
    
    @Override
    public void handle(SolicitudCambio solicitud) {
        System.out.println("Jefe de Bodega: Certificando la existencia del producto en bodega... Validado.");
        
        super.handle(solicitud);
    }
}
