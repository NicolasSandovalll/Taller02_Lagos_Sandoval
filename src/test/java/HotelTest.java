import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelTest {
    private Hotel hotel;
    private Scanner scanner;


    @Test
    public void testPosicionHabitacion_Valida() {

        String simulatedInput = "5\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        int resultado = hotel.posicionHabitacion(hotel.habitaciones, scanner);
        assertEquals(5, resultado);

    }
}
