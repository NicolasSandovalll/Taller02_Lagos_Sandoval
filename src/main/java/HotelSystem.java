import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelSystem {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Hotel hotel = new Hotel();  // Crear instancia de Hotel
    }

    static class Hotel {
        private String[] habitaciones = new String[10]; // "D" para disponible, "R" para reservada
        private int[] nochesReservadas = new int[10];
        private boolean[] conAlimentacion = new boolean[10];
        private boolean[] pagada = new boolean[10]; // Indica si la habitación fue pagada o no
        private static final String clave = "resetearTodo";
        private Scanner scanner = new Scanner(System.in);

        // Constructor para inicializar las habitaciones
        public Hotel() {
            for (int i = 0; i < habitaciones.length; i++) {
                habitaciones[i] = "D"; // La habitación está disponible
                nochesReservadas[i] = 0;
                conAlimentacion[i] = false;
                pagada[i] = false; // Inicializa como no pagada
            }
            System.out.println("El hotel ha sido inicializado.");
        }

        public void consultarEstadoHabitaciones() {
            for (int i = 0; i < habitaciones.length; i++) {
                String estado = habitaciones[i];
                System.out.println("Habitación " + i + ": " + estado);
            }
        }

        public void reservarHabitacion() {
            int posicion = solicitarPosicionHabitacion();

            if (habitaciones[posicion].equals("D")) {
                System.out.println("Ingrese la cantidad de noches: ");
                nochesReservadas[posicion] = scanner.nextInt();
                realizarAlimentacion(posicion);
            } else {
                System.out.println("La habitación " + posicion + " no está disponible.");
            }
        }

        public void confirmarReserva() {
            int posicion = solicitarPosicionHabitacion();

            if (habitaciones[posicion].equals("R")) {
                habitaciones[posicion] = conAlimentacion[posicion] ? "OA" : "OS"; // Ocupada con/sin alimentación
                System.out.println("La habitación " + posicion + " ha sido ocupada.");
            } else {
                System.out.println("La habitación " + posicion + " no está reservada.");
            }
        }

        private void realizarAlimentacion(int posicion) {
            System.out.println("Desea añadir alimentación? (S/N)");
            String respuesta = scanner.next().toUpperCase();

            if (respuesta.equals("S")) {
                habitaciones[posicion] = "R"; // Reservada con alimentación
                conAlimentacion[posicion] = true;
                System.out.println("La habitación se ha reservado con alimentación.");
            } else if (respuesta.equals("N")) {
                habitaciones[posicion] = "R"; // Reservada sin alimentación
                conAlimentacion[posicion] = false;
                System.out.println("La habitación se ha reservado sin alimentación.");
            } else {
                System.out.println("Opción inválida. Intente nuevamente.");
                realizarAlimentacion(posicion);
            }
        }

        public int solicitarPosicionHabitacion() {
            while (true) {
                try {
                    System.out.print("Ingrese el número de la habitación (0-9): ");
                    int posicion = scanner.nextInt();
                    if (posicion >= 0 && posicion < habitaciones.length) {
                        return posicion;
                    } else {
                        System.out.println("Posición fuera de rango. Ingrese un número entre 0 y 9.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    scanner.next();
                }
            }
        }
    }


}
