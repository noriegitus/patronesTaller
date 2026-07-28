import java.util.ArrayList;
import java.util.List;

import chain_of_responsibility.*;
import iterator.*;
import strategy.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("   DEMOSTRACIÓN DE PATRONES DE DISEÑO Y UML");
        System.out.println("=================================================\n");

        System.out.println("--- 1. PATRÓN ITERATOR ---");
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Laptop Gamer Asus", 1250.0, true, true, false));
        listaProductos.add(new Producto("Televisor 55 Smart", 650.0, true, false, false));
        listaProductos.add(new Producto("Celular Samsung Galaxy", 950.0, false, true, true));
        listaProductos.add(new Producto("Impresora Multifuncional", 300.0, true, true, true));
        
        Inventario inventario = new Inventario(listaProductos);

        System.out.println("\n[Comprador Web] Navegando productos disponibles:");
        iterator.Iterator iteradorDisponibles = inventario.createDisponibleIterator();
        while (iteradorDisponibles.hasMore()) {
            Producto prod = iteradorDisponibles.getNext();
            System.out.println(" -> " + prod.getNombre() + " ($" + prod.getPrecio() + ")");
        }

        System.out.println("\n[Proveedor] Navegando productos con fallas en período de garantía:");
        iterator.Iterator iteradorFallas = inventario.createGarantiaFallasIterator();
        while (iteradorFallas.hasMore()) {
            Producto prod = iteradorFallas.getNext();
            System.out.println(" -> " + prod.getNombre() + " ($" + prod.getPrecio() + ")");
        }

        System.out.println("\n-------------------------------------------------");
        System.out.println("--- 2. PATRÓN STRATEGY ---");

        DepartamentoLogistica departamentoLogistica = new DepartamentoLogistica();

        System.out.println("\n[Logística] Seleccionando transporte Automotriz:");
        departamentoLogistica.setStrategy(new TransporteAutomotriz());
        departamentoLogistica.ejecutarDistribucion(inventario.getProductos(), "Bodega Tienda Quito");

        System.out.println("\n[Logística] Cambiando estrategia a transporte Ciclista:");
        departamentoLogistica.setStrategy(new TransporteCiclista());
        departamentoLogistica.ejecutarDistribucion(inventario.getProductos(), "Tienda Centro Guayaquil");

        System.out.println("\n-------------------------------------------------");
        System.out.println("--- 3. PATRÓN CHAIN OF RESPONSIBILITY ---");

        Handler atencionCliente = new AtencionUserHandler();
        Handler soporteTecnico = new DptoTecnicoHandler();
        Handler jefeBodega = new JefeBodegaHandler();
        Handler gerenteTienda = new GerenteTiendaHandler();

        atencionCliente.setNext(soporteTecnico);
        soporteTecnico.setNext(jefeBodega);
        jefeBodega.setNext(gerenteTienda);

        System.out.println("\n>>> PROCESANDO SOLICITUD A (Laptop Gamer - $1250 USD):");
        SolicitudCambio solicitudA = new SolicitudCambio("Pantalla parpadea", 1250.0);
        atencionCliente.handle(solicitudA); 

        System.out.println("\n>>> PROCESANDO SOLICITUD B (Impresora - $300 USD):");
        SolicitudCambio solicitudB = new SolicitudCambio("No enciende", 300.0);
        atencionCliente.handle(solicitudB);

        System.out.println("\n=================================================");
        System.out.println("   FIN DE LA EJECUCIÓN");
        System.out.println("=================================================");
    }
}
        System.out.println("\n=================================================");
        System.out.println("   FIN DE LA EJECUCIÓN");
        System.out.println("=================================================");
    }
}
