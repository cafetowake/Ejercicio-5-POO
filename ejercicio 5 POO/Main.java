import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Torneo torneo = new Torneo();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Agregar Jugador");
            System.out.println("2. Mostrar todos los Jugadores");
            System.out.println("3. Encontrar los mejores Liberos");
            System.out.println("4. Contar Pasadores efectivos");
            System.out.println("5. Cargar catálogo desde archivo CSV");
            System.out.println("6. Guardar catálogo en archivo CSV");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarJugador(torneo, scanner);
                    break;
                case 2:
                    torneo.mostrarTodosLosJugadores();
                    break;
                case 3:
                    encontrarMejoresLiberos(torneo, scanner);
                    break;
                case 4:
                    contarPasadoresEfectivos(torneo);
                    break;
                case 5:
                    cargarCatalogoDesdeCSV(torneo, scanner);
                    break;
                case 6:
                    guardarCatalogoEnCSV(torneo, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    /**
     * @param torneo
     * @param scanner
     */
    private static void agregarJugador(Torneo torneo, Scanner scanner) {
        System.out.print("Nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("País del jugador: ");
        String pais = scanner.next();
        System.out.print("Errores: ");
        int errores = scanner.nextInt();
        System.out.print("Aces: ");
        int aces = scanner.nextInt();
        System.out.print("Total de Servicios: ");
        int totalServicios = scanner.nextInt();
        System.out.print("Pases: ");
        int pases = scanner.nextInt();

        System.out.println("Tipo de Jugador:");
        System.out.println("1. Libero");
        System.out.println("2. Auxiliar");
        System.out.print("Seleccione el tipo de jugador: ");
        int tipoJugador = scanner.nextInt();

        if (tipoJugador == 1) {
            torneo.agregarJugador(new Libero(nombre, pais, errores, aces, totalServicios, pases));
        } 
        else if (tipoJugador == 2) {
            System.out.print("Ataques: ");
            int ataques = scanner.nextInt();
            System.out.print("Bloqueos Efectivos: ");
            int bloqueosEfectivos = scanner.nextInt();
            System.out.print("Bloqueos Fallidos: ");
            int bloqueosFallidos = scanner.nextInt();

            torneo.agregarJugador(new Auxiliar(nombre, pais, errores, aces, totalServicios, ataques, bloqueosEfectivos, bloqueosFallidos));
        } 
        else {
            System.out.println("Tipo de Jugador no válido.");
        }
    }

    /**
     * @param torneo
     * @param scanner
     */
    private static void encontrarMejoresLiberos(Torneo torneo, Scanner scanner) {
        System.out.print("Cantidad de mejores Liberos a mostrar: ");
        int cantidad = scanner.nextInt();
        torneo.encontrarMejoresLiberos(cantidad).forEach(System.out::println);
    }

    /**
     * @param torneo
     */
    private static void contarPasadoresEfectivos(Torneo torneo) {
        int cantidadPasadoresEfectivos = torneo.contarPasadoresEfectivos();
        System.out.println("Cantidad de Pasadores efectivos: " + cantidadPasadoresEfectivos);
    }

    /**
     * @param torneo
     * @param scanner
     */
    private static void cargarCatalogoDesdeCSV(Torneo torneo, Scanner scanner) {
        System.out.print("Nombre del archivo CSV para cargar: ");
        String archivo = scanner.next();
        torneo.cargarCatalogoDesdeCSV(archivo);
        System.out.println("Catálogo cargado exitosamente desde " + archivo);
    }

    /**
     * @param torneo
     * @param scanner
     */
    private static void guardarCatalogoEnCSV(Torneo torneo, Scanner scanner) {
        System.out.print("Nombre del archivo CSV para guardar: ");
        String archivo = scanner.next();
        torneo.guardarCatalogoEnCSV(archivo);
        System.out.println("Catálogo guardado exitosamente en " + archivo);
    }
}
