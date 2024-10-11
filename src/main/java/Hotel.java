import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hotel {


    String[] habitaciones = new String[10]; // "D" = Disponible, "R" = Reservada, "OA" = Ocupada con alimentación, "OS" = Ocupada sin alimentación
    int[] nochesReservadas = new int[10];
    boolean[] conAlimentacion = new boolean[10];

    public static void main(String[] args){
        Hotel hotel = new Hotel();
        hotel.run();
    }



    Scanner scanner = new Scanner(System.in);

    public void run() {
        iniciarHabitaciones(); // Inicializa las habitaciones

        // Repetir hasta obtener una posición válida
        int posicion;
        do {
            posicion = posicionHabitacion(habitaciones, scanner);
        } while (posicion == -1);

        // Mostrar el estado de la habitación ingresada
        estadoHabitacion(habitaciones, posicion);
    }












    public void iniciarHabitaciones() {
        for (int i = 0; i < habitaciones.length; i++) {
            habitaciones[i] = "D";
        }
    }

    public int posicionHabitacion(String[] habitaciones, Scanner scanner) {
        System.out.println("Ingresa el número de la habitación entre 0 y 10"); // POSICIONES SUJETAS A CAMBIO
        try {
            int posicion = scanner.nextInt();
            if (posicion >= 0 && posicion < habitaciones.length) { //SE MANEJA EL CASO EN QUE LA POSICION NO SEA VALIDA
                return posicion;
            } else {
                System.out.println("Número de habitación no válido, por favor ingresa un numero entre 0 y 10");
                return -1;
            }
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingresa un número válido.");
            scanner.next();
            return -1;
        }
    }


    public void estadoHabitacion(String[] habitaciones, int posicion) {
        String estado = habitaciones[posicion];
        if (estado.equals("D")){
            System.out.println("La habitacion " + posicion + "Se encuentra disponible");
        } else {
            System.out.println("La habitacion " + posicion + "Se encuentra ocupada");
        }

    }
    private void estadoAlimentacion(int posicion){
        System.out.println("Desea añadir alimentacion S/N");
        String respuesta = scanner.next().toUpperCase(); // UTIL EN CASO DE QUE RESPONDAN EN MINUSCULAS :D

        if (respuesta.equals("S")) {
            habitaciones[posicion] = "RA";
        } else {
            habitaciones[posicion] = "OS";
        }
    }



}

