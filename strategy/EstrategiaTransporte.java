package strategy;

import java.util.List;
import iterator.Producto;

public interface EstrategiaTransporte {
    void distribuir(List<Producto> productos, String destino);
}
