// Implementacion del patron Iterator 

import java.util.ArrayList;
import java.util.List;

// 1. Clase Producto (El elemento a iterar)
public class Producto {
    private String nombre;
    private boolean disponibleParaVenta;
    private boolean fallaEnGarantia;
    private boolean enReparacion;
    private String tiendaUbicacion;

    public Producto(String nombre, boolean disponible, boolean fallaEnGarantia, boolean enReparacion, String tienda) {
        this.nombre = nombre;
        this.disponibleParaVenta = disponible;
        this.fallaEnGarantia = fallaEnGarantia;
        this.enReparacion = enReparacion;
        this.tiendaUbicacion = tienda;
    }

    // Getters necesarios para los filtros de los iteradores
    public String getNombre() { return nombre; }
    public boolean isDisponibleParaVenta() { return disponibleParaVenta; }
    public boolean isFallaEnGarantia() { return fallaEnGarantia; }
    public boolean isEnReparacion() { return enReparacion; }
    public String getTiendaUbicacion() { return tiendaUbicacion; }
}

// 2. Interfaz del Iterador
public interface ProductoIterator {
    boolean hasNext();
    Producto next();
}

// 3. Iterador Concreto 1: Para el Comprador Web (Solo productos disponibles)
public class CompradorWebIterator implements ProductoIterator {
    private List<Producto> inventario;
    private int posicion = 0;

    public CompradorWebIterator(List<Producto> inventario) {
        this.inventario = inventario;
    }

    @Override
    public boolean hasNext() {
        while (posicion < inventario.size()) {
            if (inventario.get(posicion).isDisponibleParaVenta()) {
                return true;
            }
            posicion++; // Salta los productos que no cumplen la condición
        }
        return false;
    }

    @Override
    public Producto next() {
        if (this.hasNext()) {
            return inventario.get(posicion++);
        }
        return null;
    }
}

// 4. Iterador Concreto 2: Para el Proveedor (Solo productos con fallas en garantía)
public class ProveedorIterator implements ProductoIterator {
    private List<Producto> inventario;
    private int posicion = 0;

    public ProveedorIterator(List<Producto> inventario) {
        this.inventario = inventario;
    }

    @Override
    public boolean hasNext() {
        while (posicion < inventario.size()) {
            if (inventario.get(posicion).isFallaEnGarantia()) {
                return true;
            }
            posicion++; 
        }
        return false;
    }

    @Override
    public Producto next() {
        if (this.hasNext()) {
            return inventario.get(posicion++);
        }
        return null;
    }
}

// 5. Interfaz de la Colección Agregada
public interface Inventario {
    ProductoIterator crearIteradorWeb();
    ProductoIterator crearIteradorProveedor();
    // Aquí se agregarían: crearIteradorVendedor(), crearIteradorMantenimiento(), etc.
}

// 6. Colección Concreta: El inventario centralizado
public class InventarioNacional implements Inventario {
    private List<Producto> listaProductos;

    public InventarioNacional() {
        this.listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        this.listaProductos.add(producto);
    }

    @Override
    public ProductoIterator crearIteradorWeb() {
        return new CompradorWebIterator(this.listaProductos);
    }

    @Override
    public ProductoIterator crearIteradorProveedor() {
        return new ProveedorIterator(this.listaProductos);
    }
}
