Integrantes:

- Alonso Lagos
- Nicolás Sandoval

Cada integrantes crea sus métodos y tests . se comenzará a hacer los métedos que crean la lógica del sistema hasta finalmente llegar al menu.

 Variables globales que se ocuparán

String[] habitaciones = new String[10]; // "D" = Disponible, "R" = Reservada, "OA" = Ocupada con alimentación, "OS" = Ocupada sin alimentación
int[] nochesReservadas = new int[10];
boolean[] conAlimentacion = new boolean[10];

inicializar las habitaciones como disponibles
for (int i = 0; i < 10; i++) {
habitaciones[i] = "D"; // Inicialmente todas las habitaciones están disponibles
}
