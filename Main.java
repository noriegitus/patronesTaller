import chain_of_responsibility.*;
import iterator.*;
import strategy.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("   DEMOSTRACIÓN DE PATRONES DE DISEÑO Y UML");
        System.out.println("=================================================\n");

        System.out.println("--- 1. PATRÓN ITERATOR ---");
        Inventario inventario = new Inventario();

        Producto p1 = new Producto("Laptop Gamer Asus", 1250.0, true, true, false);
        Producto p2 = new Producto("Televisor 55 Smart", 650.0, true, false, false);
        Producto p3 = new Producto("Celular Samsung Galaxy", 950.0, false, true, true);
        Producto p4 = new Producto("Impresora Multifuncional", 300.0, true, true, true);

        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);

        System.out.println("\n[Comprador Web] Navegando productos disponibles:");
        Iterator<Producto> iteradorDisponibles = inventario.createDisponibleIterator();
        while (iteradorDisponibles.hasMore()) {
            Producto prod = iteradorDisponibles.getNext();
            System.out.println(" -> " + prod.getNombre() + " ($" + prod.getPrecio() + ")");
        }

        System.out.println("\n[Proveedor] Navegando productos con fallas en período de garantía:");
        Iterator<Producto> iteradorFallas = inventario.createGarantiaFallasIterator();
        while (iteradorFallas.hasMore()) {
            Producto prod = iteradorFallas.getNext();
            System.out.println(" -> " + prod.getNombre() + " ($" + prod.getPrecio() + ")");
        }

        System.out.println("\n-------------------------------------------------");
        System.out.println("--- 2. PATRÓN STRATEGY ---");

        EstrategiaDistribucion contextoDistribucion = new EstrategiaDistribucion();

        System.out.println("\n[Logística] Seleccionando transporte Automotriz:");
        contextoDistribucion.setStrategy(new TransporteAutomotriz());
        contextoDistribucion.ejecutarEnvio(inventario.getProductos(), "Bodega Tienda Quito");

        System.out.println("\n[Logística] Cambiando estrategia a transporte Ciclista:");
        contextoDistribucion.setStrategy(new TransporteCiclista());
        contextoDistribucion.ejecutarEnvio(inventario.getProductos(), "Tienda Centro Guayaquil");

        System.out.println("\n-------------------------------------------------");
        System.out.println("--- 3. PATRÓN CHAIN OF RESPONSIBILITY ---");

        Handler atencionCliente = new AtencionUserHandler();
        Handler soporteTecnico = new DptoTecnicoHandler();
        Handler jefeBodega = new JefeBodegaHandler();
        Handler gerenteTienda = new GerenteTiendaHandler();

        atencionCliente.setNext(soporteTecnico)
                       .setNext(jefeBodega)
                       .setNext(gerenteTienda);

        System.out.println("\n>>> PROCESANDO SOLICITUD A (Laptop Gamer - $1250 USD):");
        SolicitudCambio solicitudA = new SolicitudCambio(p1, true, true, true);
        boolean resultadoA = atencionCliente.handle(solicitudA);
        System.out.println("Resultado Solicitud A: " + (resultadoA ? "APROBADA" : "RECHAZADA"));

        System.out.println("\n>>> PROCESANDO SOLICITUD B (Impresora - $300 USD):");
        SolicitudCambio solicitudB = new SolicitudCambio(p4, true, true, true);
        boolean resultadoB = atencionCliente.handle(solicitudB);
        System.out.println("Resultado Solicitud B: " + (resultadoB ? "APROBADA" : "RECHAZADA"));

        System.out.println("\n>>> PROCESANDO SOLICITUD C (Televisor fuera de garantía):");
        SolicitudCambio solicitudC = new SolicitudCambio(p2, false, true, true);
        boolean resultadoC = atencionCliente.handle(solicitudC);
        System.out.println("Resultado Solicitud C: " + (resultadoC ? "APROBADA" : "RECHAZADA"));

        System.out.println("\n=================================================");
        System.out.println("   FIN DE LA EJECUCIÓN");
        System.out.println("=================================================");
    }
}