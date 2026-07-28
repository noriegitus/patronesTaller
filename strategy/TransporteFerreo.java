package strategy;
import java.util.List;
import iterator.Producto;

public class TransporteFerreo implements EstrategiaTransporte {
    @Override
    public void distribuir(List<Producto> productos, String destino) {
        System.out.println("Enviando " + productos.size() + " productos vía férrea a: " + destino);
    }
}
