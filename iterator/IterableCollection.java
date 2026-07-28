package iterator;

public interface IterableCollection {
    Iterator<Producto> createDisponibleIterator();
    Iterator<Producto> createGarantiaFallasIterator();
}
