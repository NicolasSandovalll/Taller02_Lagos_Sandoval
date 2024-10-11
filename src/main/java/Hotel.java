import java.util.Scanner;

public class Hotel {

    public static Scanner scanner = new Scanner(System.in);
    public static String[] habitaciones = new String[10];
    public static int[] nochesReservadas = new int[10];
    public static boolean[] conAlimentacion = new boolean[10];
    public static final String clave = "resetearTodo";
    public static boolean[] pagada = new boolean[10]; // Indica si la habitación fue pagada o no

    public static void main(String[] args) {
        inicializarHotel();
    }

    public static void inicializarHotel() {
        for (int i = 0; i < 10; i++) {
            habitaciones[i] = "D"; // La D quiere decir que la habitacion esta disponible
            nochesReservadas[i] = 0;
            conAlimentacion[i] = false;
        }
        System.out.println("El hotel ha sido inicializado.");
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



}
