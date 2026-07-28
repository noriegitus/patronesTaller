import java.util.ArrayList;
import java.util.List;
package iterator;

public class Inventario implements IterableCollection {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public Iterator<Producto> createDisponibleIterator() {
        return new DisponibleIterator(this);
    }

    @Override
    public Iterator<Producto> createGarantiaFallasIterator() {
        return new GarantiaFallasIterator(this);
    }
}
