import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Torneo {
    /**
     *
     */
    private List<Jugador> jugadores;

    /**
     * 
     */
    public Torneo() {
        jugadores = new ArrayList<>();
    }

    /**
     * @param jugador
     */
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    /**
     * 
     */
    public void mostrarTodosLosJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados en el torneo.");
        } else {
            System.out.println("Lista de Jugadores:");
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }

    /**
     * @param cantidad
     * @return
     */
    public List<Libero> encontrarMejoresLiberos(int cantidad) {
        List<Libero> liberos = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Libero) {
                liberos.add((Libero) jugador);
            }
        }

        liberos.sort((l1, l2) -> Double.compare(l2.calcularEfectividad(), l1.calcularEfectividad()));

        return liberos.subList(0, Math.min(cantidad, liberos.size()));
    }

    /**
     * @return
     */
    public int contarPasadoresEfectivos() {
        long pasadoresEfectivos = jugadores.stream()
                .filter(jugador -> jugador instanceof Pasador)
                .filter(jugador -> jugador.calcularEfectividad() > 80)
                .count();
        return (int) pasadoresEfectivos;
    }

    /**
     * @param archivo
     */
    public void cargarCatalogoDesdeCSV(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] partes = line.split(",");
                if (partes.length >= 7) {
                    String nombre = partes[0];
                    String pais = partes[1];
                    int errores = Integer.parseInt(partes[2]);
                    int aces = Integer.parseInt(partes[3]);
                    int totalServicios = Integer.parseInt(partes[4]);
                    int pases = Integer.parseInt(partes[5]);
                    Jugador jugador;
                    if (partes.length == 7) {
                        jugador = new Libero(nombre, pais, errores, aces, totalServicios, pases);
                    } else {
                        int ataques = Integer.parseInt(partes[7]);
                        int bloqueosEfectivos = Integer.parseInt(partes[8]);
                        int bloqueosFallidos = Integer.parseInt(partes[9]);
                        jugador = new Auxiliar(nombre, pais, errores, aces, totalServicios, ataques, bloqueosEfectivos, bloqueosFallidos);
                    }
                    agregarJugador(jugador);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo CSV: " + e.getMessage());
        }
    }

    /**
     * @param archivo
     */
    public void guardarCatalogoEnCSV(String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Jugador jugador : jugadores) {
                bw.write(jugador.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo CSV: " + e.getMessage());
        }
    }
}
