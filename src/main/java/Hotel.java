import java.util.InputMismatchException;
import java.util.Scanner;

public class Hotel {

    public static Scanner scanner = new Scanner(System.in);
    public static String[] habitaciones = new String[10];
    public static int[] nochesReservadas = new int[10];
    public static boolean[] conAlimentacion = new boolean[10];
    public static final String clave = "resetearTodo";
    public static boolean[] pagada = new boolean[10]; // Indica si la habitación fue pagada o no


    public static void inicializarHotel() {
        for (int i = 0; i < 10; i++) {
            habitaciones[i] = "D"; // La D quiere decir que la habitacion esta disponible
            nochesReservadas[i] = 0;
            conAlimentacion[i] = false;
        }
        System.out.println("El hotel ha sido inicializado.");
    }

    public static void main(String[] args) {
        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        inicializarHotel();
        int opcion;
        do {
            menu();
            opcion = solicitarOpcion("Ingrese una opción: ", 1, 7);
            procesarOpcion(opcion);
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
                System.out.println("Carácteres inválidps, por favor ingrese una opción correcta.");
                scanner.next(); // limpiar la entrada inválida
            }
        }
    }

    public static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.out.println("Ingrese la clave para reiniciar el hotel");
                String claveIngresada = scanner.next();
                reiniciarHotel(claveIngresada);
                break;
            case 7:
                System.out.println("Saluieno del programa . . .");
                break;
        }
    }




    // Se reinician las habitaciones a estado de disponible
    public static void reiniciarHotel(String claveIngresada) {
        if (claveIngresada.equals(clave)) {
            for (int i = 0; i < 10; i++) {
                habitaciones[i] = "D";
                nochesReservadas[i] = 0;
                conAlimentacion[i] = false;
                pagada[i] = false;
            }
            System.out.println("El hotel ha sido reiniciado.");
        } else {
            System.out.println("Clave incorrecta.");
        }
    }

    // Pagar habitación
    public static void pagarHabitacion(int numeroHabitacion) {
        if (habitaciones[numeroHabitacion].startsWith("O") && !pagada[numeroHabitacion]) {
            int precioPorNoche = conAlimentacion[numeroHabitacion] ? 45000 : 30000;
            int total = nochesReservadas[numeroHabitacion] * precioPorNoche;
            System.out.println("El total a pagar por la habitación " + (numeroHabitacion + 1) + " es de $" + total);
            pagada[numeroHabitacion] = true;
            System.out.println("Habitación " + (numeroHabitacion + 1) + " ha sido pagada.");
        } else if (pagada[numeroHabitacion]) {
            System.out.println("La habitación ya fue pagada.");
        } else {
            System.out.println("La habitación no está ocupada.");
        }
    }

    // Liberar una habitación ocupada e imprimir boleta
    public static void liberarHabitacion(int numeroHabitacion) {
        if (habitaciones[numeroHabitacion].startsWith("O") && pagada[numeroHabitacion]) {
            System.out.println("Habitación " + (numeroHabitacion + 1) + " ahora está disponible.");
            habitaciones[numeroHabitacion] = "D";
            nochesReservadas[numeroHabitacion] = 0;
            conAlimentacion[numeroHabitacion] = false;
            pagada[numeroHabitacion] = false;
        } else if (!pagada[numeroHabitacion]) {
            System.out.println("La habitación aún no ha sido pagada.");
        } else {
            System.out.println("La habitación no está ocupada.");
        }
    }





}
