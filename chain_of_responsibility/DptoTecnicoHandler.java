package chain_of_responsibility;

public class DptoTecnicoHandler extends BaseHandler {
    
    @Override
    public void handle(SolicitudCambio solicitud) {
        System.out.println("Dpto. Técnico: Constatando que el fallo ('" + solicitud.getMotivo() + "') esté cubierto... Validado.");
        
        super.handle(solicitud);
    }
}
