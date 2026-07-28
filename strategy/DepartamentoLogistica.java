public class DepartamentoLogistica {
    private EstrategiaTransporte strategy;

    public void setStrategy(EstrategiaTransporte strategy) {
        this.strategy = strategy;
    }

    public void ejecutarDistribucion(List<Producto> productos, String destino) {
        if (strategy != null) {
            strategy.distribuir(productos, destino);
        } else {
            System.out.println("No hay estrategia seleccionada.");
        }
    }
}
