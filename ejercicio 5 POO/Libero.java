public class Libero extends Jugador {
    private int recibos;

    /**
     * @param nombre
     * @param pais
     * @param errores
     * @param aces
     * @param totalServicios
     * @param recibos
     */
    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, int recibos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.recibos = recibos;
    }

    @Override
    public double calcularEfectividad() {
        return ((recibos - getErrores()) * 100.0 / (recibos + getErrores())) + (getAces() * 100.0 / getTotalServicios());
    }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%d,%d,%d,%d", getNombre(), getPais(), getErrores(), getAces(), getTotalServicios(), recibos);
    }

    @Override
    public String toString() {
        return String.format("Libero: Nombre=%s, País=%s, Errores=%d, Aces=%d, TotalServicios=%d, Recibos=%d, Efectividad=%.2f%%",
                getNombre(), getPais(), getErrores(), getAces(), getTotalServicios(), recibos, calcularEfectividad());
    }
}
