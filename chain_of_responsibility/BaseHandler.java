package chain_of_responsibility;

public abstract class BaseHandler implements Handler {
    private Handler next;

    @Override
    public Handler setNext(Handler handler) {
        this.next = handler;
        return handler;
    }

    @Override
    public void handle(SolicitudCambio solicitud) {
        if (next != null) {
            next.handle(solicitud);
        }
    }
}
