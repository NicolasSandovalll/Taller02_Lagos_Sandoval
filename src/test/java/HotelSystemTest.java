import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelTest {
    public Hotel hotel;
    public Scanner scanner;

    @BeforeEach
    void setup() {
        hotel = new Hotel();
        hotel.iniciarHabitaciones();
    }


    @Test
    void testPosicion_valida() {
        Scanner scanner = new Scanner("5");
        int posicion = hotel.posicionHabitacion(hotel.habitaciones, scanner);
        assertEquals(5, posicion);
    }







}
