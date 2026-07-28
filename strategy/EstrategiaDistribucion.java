package strategy;
import java.util.List;


public class EstrategiaDistribucion {
    private RutaDistribucion strategy;

    public void setStrategy(RutaDistribucion strategy) {
        this.strategy = strategy;
    }

    public void ejecutarEnvio(List<Producto> productos, String destino) {
        if (strategy == null) {
            throw new IllegalStateException("Estrategia de distribución no configurada.");
        }
        strategy.realizarEnvio(productos, destino);
    }
}
