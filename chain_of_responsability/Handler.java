public interface Handler {
    Handler setNext(Handler handler);
    boolean handle(SolicitudCambio solicitud);
}
