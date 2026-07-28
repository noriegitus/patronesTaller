import java.util.List;

public interface RutaDistribucion {
    void realizarEnvio(List<Producto> productos, String destino);
}
