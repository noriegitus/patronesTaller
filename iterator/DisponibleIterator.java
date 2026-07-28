package iterator;

public class DisponibleIterator implements Iterator<Producto> {
    private Inventario inventario;
    private int posicion = 0;

    public DisponibleIterator(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public boolean hasMore() {
        while (posicion < inventario.getProductos().size()) {
            if (inventario.getProductos().get(posicion).isDisponible()) {
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
