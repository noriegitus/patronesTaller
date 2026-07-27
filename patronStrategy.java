## Implementacion Strategy para Logistica


// Interfaz Strategy
public interface EstrategiaDistribucion {
    void distribuir(String producto, String destino);
}

// Estrategia Concreta 1
public class DistribucionAutomotriz implements EstrategiaDistribucion {
    @Override
    public void distribuir(String producto, String destino) {
        System.out.println("Distribuyendo " + producto + " a " + destino + " vía automotriz.");
    }
}

// Estrategia Concreta 2
public class DistribucionAerea implements EstrategiaDistribucion {
    @Override
    public void distribuir(String producto, String destino) {
        System.out.println("Distribuyendo " + producto + " a " + destino + " vía aérea.");
    }
}

// Contexto
public class DepartamentoLogistica {
    private EstrategiaDistribucion estrategia;

    // Las estrategias son intercambiables en tiempo de ejecución
    public void setEstrategia(EstrategiaDistribucion estrategia) {
        this.estrategia = estrategia;
    }

    public void iniciarDistribucion(String producto, String destino) {
        if (estrategia == null) {
            throw new IllegalStateException("Estrategia no definida");
        }
        estrategia.distribuir(producto, destino);
    }
