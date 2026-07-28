package chain_of_responsibility;

public interface Handler {
    Handler setNext(Handler handler);
    void handle(SolicitudCambio solicitud);
}
