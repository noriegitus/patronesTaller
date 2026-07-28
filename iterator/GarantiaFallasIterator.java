package iterator;

public class GarantiaFallasIterator implements Iterator<Producto> {
    private Inventario inventario;
    private int posicion = 0;

    public GarantiaFallasIterator(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public boolean hasMore() {
        while (posicion < inventario.getProductos().size()) {
            Producto p = inventario.getProductos().get(posicion);
            if (p.isEnGarantia() && p.isConFalla()) {
                return true;
            }
            posicion++;
        }
        return false;
    }

    @Override
    public Producto getNext() {
        if (hasMore()) {
            return inventario.getProductos().get(posicion++);
        }
        return null;
    }
}
