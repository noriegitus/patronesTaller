package chain_of_responsibility;

public class AtencionUserHandler extends BaseHandler {
    
    @Override
    public void handle(SolicitudCambio solicitud) {
        System.out.println("Atención al Cliente: Verificando que el producto esté en periodo de garantía... Validado.");
        
        super.handle(solicitud);
    }
}
