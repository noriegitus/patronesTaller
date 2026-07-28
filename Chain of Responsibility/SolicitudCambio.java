public class SolicitudCambio {
    private Producto producto;
    private boolean dentroDeGarantia;
    private boolean falloCubierto;
    private boolean existeEnBodega;

    public SolicitudCambio(Producto producto, boolean dentroDeGarantia, boolean falloCubierto, boolean existeEnBodega) {
        this.producto = producto;
        this.dentroDeGarantia = dentroDeGarantia;
        this.falloCubierto = falloCubierto;
        this.existeEnBodega = existeEnBodega;
    }

    public Producto getProducto() { return producto; }
    public boolean isDentroDeGarantia() { return dentroDeGarantia; }
    public boolean isFalloCubierto() { return falloCubierto; }
    public boolean isExisteEnBodega() { return existeEnBodega; }
}
