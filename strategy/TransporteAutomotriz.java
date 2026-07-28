package strategy;
import java.util.List;

public class TransporteAutomotriz implements EstrategiaTransporte {
    @Override
    public void realizarEnvio(List<Producto> productos, String destino) {
        System.out.println("Enviando " + productos.size() + " productos vía automotriz a: " + destino);
    }
}
