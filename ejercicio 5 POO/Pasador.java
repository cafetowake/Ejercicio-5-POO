public class Pasador extends Jugador {
    /**
     *
     */
    private int pases;
    /**
     *
     */
    private int fintas;

    /**
     * @param nombre
     * @param pais
     * @param errores
     * @param aces
     * @param totalServicios
     * @param pases
     * @param fintas
     */
    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintas) {
        super(nombre, pais, errores, aces, totalServicios);
        this.pases = pases;
        this.fintas = fintas;
    }

    @Override
    public double calcularEfectividad() {
        return ((pases + fintas - getErrores()) * 100.0)
                / (pases + fintas + getErrores()) + (getAces() * 100.0 / getTotalServicios());
    }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%d,%d,%d,%d,%d", getNombre(), getPais(), getErrores(), getAces(), getTotalServicios(), pases, fintas);
    }

    @Override
    public String toString() {
        return String.format("Pasador: Nombre=%s, País=%s, Errores=%d, Aces=%d, TotalServicios=%d, Pases=%d, Fintas=%d, Efectividad=%.2f%%",
                getNombre(), getPais(), getErrores(), getAces(), getTotalServicios(), pases, fintas, calcularEfectividad());
    }
}
