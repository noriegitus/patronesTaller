package strategy;
import java.util.List;
import iterator.Producto;

public class TransporteAereo implements EstrategiaTransporte {
    @Override
    public void distribuir(List<Producto> productos, String destino) {
        System.out.println("Vía Aérea hacia: " + destino);
    }
}
