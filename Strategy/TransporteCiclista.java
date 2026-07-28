import java.util.List;

public class TransporteCiclista implements RutaDistribucion {
    @Override
    public void realizarEnvio(List<Producto> productos, String destino) {
        System.out.println("Enviando " + productos.size() + " productos vía ciclista a: " + destino);
    }
}
