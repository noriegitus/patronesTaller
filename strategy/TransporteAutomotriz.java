package strategy;
import java.util.List;
import iterator.Producto;

public class TransporteAutomotriz implements EstrategiaTransporte {
    @Override
    public void distribuir(List<Producto> productos, String destino) {
        System.out.println("Enviando " + productos.size() + " productos vía automotriz a: " + destino);
    }
}
