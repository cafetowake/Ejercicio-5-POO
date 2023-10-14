public abstract class Jugador {
    /**
     *
     */
    private String nombre;
    /**
     *
     */
    private String pais;
    /**
     *
     */
    private int errores;
    /**
     *
     */
    private int aces;
    /**
     *
     */
    private int totalServicios;

    /**
     * @param nombre
     * @param pais
     * @param errores
     * @param aces
     * @param totalServicios
     */
    public Jugador(String nombre, String pais, int errores, int aces, int totalServicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
    }

    /**
     * @return
     */
    public abstract double calcularEfectividad();

    public abstract String toCSV();

    // Getters y setters para los atributos
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return
     */
    public int getErrores() {
        return errores;
    }

    /**
     * @param errores
     */
    public void setErrores(int errores) {
        this.errores = errores;
    }

    /**
     * @return
     */
    public int getAces() {
        return aces;
    }

    /**
     * @param aces
     */
    public void setAces(int aces) {
        this.aces = aces;
    }

    /**
     * @return
     */
    public int getTotalServicios() {
        return totalServicios;
    }

    /**
     * @param totalServicios
     */
    public void setTotalServicios(int totalServicios) {
        this.totalServicios = totalServicios;
    }

    @Override
    public String toString() {
        return String.format("Nombre=%s, País=%s, Errores=%d, Aces=%d, TotalServicios=%d, Efectividad=%.2f%%",
                nombre, pais, errores, aces, totalServicios, calcularEfectividad());
    }
}
