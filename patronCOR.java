// Implementación de Chain Of Responsability para Cambios y Garantías

public class Producto {
    public String nombre;
    public double precioUSD;
    public boolean enGarantia;
    public boolean falloCubierto;
    public boolean enBodega;
    
    public Producto(String n, double p, boolean g, boolean f, boolean b) {
        this.nombre = n; this.precioUSD = p; this.enGarantia = g;
        this.falloCubierto = f; this.enBodega = b;
    }
}

// Manejador Abstracto
public abstract class ManejadorCambio {
    protected ManejadorCambio siguiente;

    public void setSiguiente(ManejadorCambio siguiente) {
        this.siguiente = siguiente;
    }

    public abstract void procesarCambio(Producto producto);
}

// Manejador Concreto 1: Atención al Usuario
public class AtencionUsuario extends ManejadorCambio {
    @Override
    public void procesarCambio(Producto producto) {
        if (producto.enGarantia) {
            System.out.println("Atención al Usuario: Producto dentro de garantía.");
            if (siguiente != null) siguiente.procesarCambio(producto);
        } else {
            System.out.println("Rechazado: Fuera del periodo de garantía.");
        }
    }
}

// Manejador Concreto 2: Departamento Técnico
public class DepartamentoTecnico extends ManejadorCambio {
    @Override
    public void procesarCambio(Producto producto) {
        if (producto.falloCubierto) {
            System.out.println("Depto Técnico: Fallo cubierto por garantía.");
            if (siguiente != null) siguiente.procesarCambio(producto);
        } else {
            System.out.println("Rechazado: El fallo no está cubierto por la garantía.");
        }
    }
}

// Manejador Concreto 3: Gerente de Tienda (Lógica Condicional de Monto)
public class GerenteTienda extends ManejadorCambio {
    @Override
    public void procesarCambio(Producto producto) {
        if (producto.precioUSD > 1000) {
            System.out.println("Gerente: Aprobando reemplazo de producto de alto valor (>" + producto.precioUSD + ").");
        }
        System.out.println("Proceso de cambio completado exitosamente.");
    }
} 
