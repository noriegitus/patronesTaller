package strategy;
import java.util.List;
import iterator.Producto;

public class TransporteCiclista implements EstrategiaTransporte {
    @Override
    public void distribuir(List<Producto> productos, String destino) {
        System.out.println("Enviando " + productos.size() + " productos vía ciclista a: " + destino);
    }
}
