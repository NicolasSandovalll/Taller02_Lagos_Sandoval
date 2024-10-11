import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {

    @BeforeEach
    public void setup() {
        Hotel.inicializarHotel();
    }

    @Test
    public void testReiniciarHotel() {
        // configurar el estado inicial de algunas habitaciones
        Hotel.habitaciones[0] = "OA"; // ocupada con alimentaciom
        Hotel.nochesReservadas[0] = 3;
        Hotel.conAlimentacion[0] = true;
        Hotel.pagada[0] = true;

        Hotel.habitaciones[1] = "R"; // Reservada
        Hotel.nochesReservadas[1] = 2;
        Hotel.conAlimentacion[1] = false;
        Hotel.pagada[1] = false;

        // llamar al metodo reiniciarHotel con la clave correcta
        Hotel.reiniciarHotel("resetearTodo");

        // Comprobar que todas las habitaciones están en estado inicial
        for (int i = 0; i < 10; i++) {
            assertEquals("D", Hotel.habitaciones[i], "Habitación no está disponible");
            assertEquals(0, Hotel.nochesReservadas[i], "Noches reservadas no es 0");
            assertFalse(Hotel.conAlimentacion[i], "La alimentación no debería estar activa");
            assertFalse(Hotel.pagada[i], "La habitación no debería estar pagada");
        }
    }
}
