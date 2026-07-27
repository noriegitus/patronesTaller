public class Producto {
    private String nombre;
    private double precio;
    private String tiendaId;
    private boolean enGarantiaFalla;
    private boolean enReparacion;

    public Producto(String nombre, double precio, String tiendaId, boolean enGarantiaFalla, boolean enReparacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiendaId = tiendaId;
        this.enGarantiaFalla = enGarantiaFalla;
        this.enReparacion = enReparacion;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getTiendaId() { return tiendaId; }
    public boolean isEnGarantiaFalla() { return enGarantiaFalla; }
    public boolean isEnReparacion() { return enReparacion; }
}

