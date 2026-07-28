package chain_of_responsibility;

public abstract class BaseHandler implements Handler {
    private Handler next;

    @Override
    public Handler setNext(Handler handler) {
        this.next = handler;
        return handler;
    }

    @Override
    public boolean handle(SolicitudCambio solicitud) {
        if (next != null) {
            return next.handle(solicitud);
        }
        return true;
    }
}
