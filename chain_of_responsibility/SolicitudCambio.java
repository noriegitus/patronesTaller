package chain_of_responsibility;

public class SolicitudCambio {
    private String motivo;
    private double monto;

    public SolicitudCambio(String motivo, double monto) {
        this.motivo = motivo;
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public double getMonto() {
        return monto;
    }
}
