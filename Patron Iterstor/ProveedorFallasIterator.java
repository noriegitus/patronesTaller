import java.util.List;

public class ProveedorFallasIterator implements Iterator<Producto> {
    private List<Producto> productos;
    private int posicion = 0;

    public ProveedorFallasIterator(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public boolean hasNext() {
        while (posicion < productos.size()) {
            if (productos.get(posicion).isEnGarantiaFalla()) {
                return true;
            }
            posicion++;
        }
        return false;
    }

    @Override
    public Producto next() {
        if (hasNext()) {
            return productos.get(posicion++);
        }
        return null;
    }
  }
