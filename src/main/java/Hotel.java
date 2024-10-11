import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hotel {



    Scanner scanner = new scanner(System.in);

    public int posicionHabitacion(ArrayList habitaciones, Scanner scanner) {
        System.out.println("Ingresa el número de la habitación entre 0 y 10"); // POSICIONES SUJETAS A CAMBIO
        try {
            int posicion = scanner.nextInt();
            if (posicion >= 0 && posicion < habitaciones.size()) { //SE MANEJA EL CASO EN QUE LA POSICION NO SEA VALIDA
                return posicion;
            } else {
                System.out.println("Número de habitación no válido, por favor ingresa un numero entre 1 y 10");
                return -1;
            }
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingresa un número válido.");
            scanner.next();
            return -1;
        }
    }


    public void estadoHabitacion() {

    }

}

