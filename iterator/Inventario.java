package iterator;

import java.util.ArrayList;
import java.util.List;

public class Inventario implements IterableCollection {
    private List<Producto> productos;

    public Inventario(List<Producto> productos) {
        this.productos = productos != null ? productos : new ArrayList<>();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public Iterator createDisponibleIterator() {
        return new DisponibleIterator(this);
    }

    @Override
    public Iterator createGarantiaFallasIterator() {
        return new GarantiaFallasIterator(this);
    }
}
