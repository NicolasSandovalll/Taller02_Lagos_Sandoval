import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelSystem {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Hotel hotel = new Hotel();  // Crear instancia de Hotel
        iniciarPrograma(hotel);     // Pasamos el hotel como parámetro
    }

    public static void iniciarPrograma(Hotel hotel) {
        int opcion;
        do {
            menu();
            opcion = solicitarOpcion("Ingrese una opción: ", 1, 7);
            procesarOpcion(opcion, hotel);
        } while (opcion != 7);
    }

    public static void menu() {
        System.out.println("// Bienvenido //\n");
        System.out.println("1.- Consultar habitaciones");
        System.out.println("2.- Reservar habitación");
        System.out.println("3.- Confirmar Reserva");
        System.out.println("4.- Pagar habitación");
        System.out.println("5.- Liberar habitación (imprimir la boleta)");
        System.out.println("6.- Reiniciar Hotel");
        System.out.println("7.- Salir \n");
    }

    public static int solicitarOpcion(String solicitud, int minimaOpcion, int maximaOpcion) {
        while(true) {
            try {
                System.out.print(solicitud);
                int opcion = scanner.nextInt();

                if (opcion >= minimaOpcion && opcion <= maximaOpcion){
                    return opcion;
                }  else {
                    System.out.println("Por favor ingrese una opción entre " + minimaOpcion + " y " + maximaOpcion + ".");
                }
            } catch (InputMismatchException e ) {
                System.out.println("Carácteres inválidos, por favor ingrese una opción correcta.");
                scanner.next(); // limpiar la entrada inválida
            }
        }
    }

    public static void procesarOpcion(int opcion, Hotel hotel) {
        switch (opcion) {
            case 1:
                hotel.consultarEstadoHabitaciones();
                break;
            case 2:
                hotel.reservarHabitacion();
                break;
            case 3:
                hotel.confirmarReserva();
                break;
            case 4:
                hotel.pagarHabitacion();
                break;
            case 5:
                hotel.liberarHabitacion();
                break;
            case 6:
                System.out.println("Ingrese la clave para reiniciar el hotel");
                String claveIngresada = scanner.next();
                hotel.reiniciarHotel(claveIngresada);
                break;
            case 7:
                System.out.println("Saliendo del programa . . .");
                break;
        }
    }
}

class Hotel {
    private String[] habitaciones;
    private int[] nochesReservadas;
    private boolean[] conAlimentacion;
    private boolean[] pagada;
    private static final String clave = "resetearTodo";
    private Scanner scanner = new Scanner(System.in);

    // Constructor para inicializar el hotel
    public Hotel() {
        habitaciones = new String[10];
        nochesReservadas = new int[10];
        conAlimentacion = new boolean[10];
        pagada = new boolean[10];
        inicializarHotel();
    }

    // Inicializar el estado de todas las habitaciones
    public void inicializarHotel() {
        for (int i = 0; i < habitaciones.length; i++) {
            habitaciones[i] = "D"; // Disponible
            nochesReservadas[i] = 0;
            conAlimentacion[i] = false;
            pagada[i] = false;
        }
        System.out.println("El hotel ha sido inicializado.");
    }

    // Consultar el estado de las habitaciones
    public void consultarEstadoHabitaciones() {
        for (int i = 0; i < habitaciones.length; i++) {
            String estado = habitaciones[i];
            System.out.println("Habitación " + i + ": " + estado);
        }
    }

    // Reservar una habitación
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

    // Confirmar la reserva de una habitación
    public void confirmarReserva() {
        int posicion = solicitarPosicionHabitacion();

        if (habitaciones[posicion].equals("R")) {
            habitaciones[posicion] = conAlimentacion[posicion] ? "OA" : "OS"; // Ocupada con/sin alimentación
            System.out.println("La habitación " + posicion + " ha sido ocupada.");
        } else {
            System.out.println("La habitación " + posicion + " no está reservada.");
        }
    }

    // Realizar la alimentación durante la reserva
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

    // Solicitar posición de habitación
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
                scanner.next(); // limpiar entrada inválida
            }
        }
    }

    // Pagar habitación
    public void pagarHabitacion() {
        int posicion = solicitarPosicionHabitacion();

        if (habitaciones[posicion].startsWith("O") && !pagada[posicion]) {
            int precioPorNoche = conAlimentacion[posicion] ? 45000 : 30000;
            int total = nochesReservadas[posicion] * precioPorNoche;
            System.out.println("El total a pagar por la habitación " + posicion + " es de $" + total);
            pagada[posicion] = true;
            System.out.println("Habitación " + posicion + " ha sido pagada.");
        } else if (pagada[posicion]) {
            System.out.println("La habitación ya fue pagada.");
        } else {
            System.out.println("La habitación no está ocupada.");
        }
    }

    // Liberar una habitación ocupada e imprimir boleta
    public void liberarHabitacion() {
        int posicion = solicitarPosicionHabitacion();

        if (habitaciones[posicion].startsWith("O") && pagada[posicion]) {
            System.out.println("Habitación " + posicion + " ha sido liberada.");
            habitaciones[posicion] = "D"; // Disponible
            nochesReservadas[posicion] = 0;
            conAlimentacion[posicion] = false;
            pagada[posicion] = false;
        } else if (!pagada[posicion]) {
            System.out.println("La habitación aún no ha sido pagada.");
        } else {
            System.out.println("La habitación no está ocupada.");
        }
    }

    // Reiniciar el hotel
    public void reiniciarHotel(String claveIngresada) {
        if (claveIngresada.equals(clave)) {
            inicializarHotel();
            System.out.println("El hotel ha sido reiniciado.");
        } else {
            System.out.println("Clave incorrecta.");
        }
    }
}
