package iterator;

public class Producto {
    private String nombre;
    private double precio;
    private boolean disponible;
    private boolean enGarantia;
    private boolean conFalla;

    public Producto(String nombre, double precio, boolean disponible, boolean enGarantia, boolean conFalla) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.enGarantia = enGarantia;
        this.conFalla = conFalla;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public boolean isDisponible() { return disponible; }
    public boolean isEnGarantia() { return enGarantia; }
    public boolean isConFalla() { return conFalla; }
}
