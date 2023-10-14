public class Auxiliar extends Jugador {
    /**
     *
     */
    private int ataques;
    /**
     *
     */
    private int bloqueosEfectivos;
    /**
     *
     */
    private int bloqueosFallidos;

    /**
     * @param nombre
     * @param pais
     * @param errores
     * @param aces
     * @param totalServicios
     * @param ataques
     * @param bloqueosEfectivos
     * @param bloqueosFallidos
     */
    public Auxiliar(String nombre, String pais, int errores, int aces, int totalServicios, int ataques, int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    @Override
    public double calcularEfectividad() {
        return ((ataques + bloqueosEfectivos - bloqueosFallidos - getErrores()) * 100.0)
                / (ataques + bloqueosEfectivos + bloqueosFallidos + getErrores()) + (getAces() * 100.0 / getTotalServicios());
    }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%d,%d,%d,%d,%d,%d,%d", getNombre(), getPais(), getErrores(), getAces(), getTotalServicios(), ataques, bloqueosEfectivos, bloqueosFallidos);
    }

    @Override
    public String toString() {
        return String.format("Auxiliar: Nombre=%s, País=%s, Errores=%d, Aces=%d, TotalServicios=%d, Ataques=%d, BloqueosEfectivos=%d, BloqueosFallidos=%d, Efectividad=%.2f%%",
                getNombre(), getPais(), getErrores(), getAces(), getTotalServicios(), ataques, bloqueosEfectivos, bloqueosFallidos, calcularEfectividad());
    }
}
