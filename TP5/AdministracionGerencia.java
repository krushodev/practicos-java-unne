/**
 * Clase ejecutable para la administración de una gerencia de alojamientos.
 * Simula la creación de un Hotel y una Cabaña, la asignación de servicios
 * y la posterior liquidación de los costos a través de una Gerencia.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class AdministracionGerencia {
    /**
     * Punto de entrada principal de la aplicación.
     * Crea instancias de Gerencia, Hotel y Cabaña, les asigna servicios
     * y finalmente invoca la liquidación para mostrar un reporte de costos.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Gerencia gerencia = new Gerencia("Los Arroyos");
        Hotel hotel = new Hotel("Hotel Guaraní", 90.0, 7, "Single");
        Cabaña cabania = new Cabaña("Cabañas La Alondra", 120.0, 5, 3);

        // Agregar alojamientos a la gerencia
        gerencia.agregarAlojamiento(hotel);
        gerencia.agregarAlojamiento(cabania);

        // Crear servicios
        Servicio s1 = new Servicio("Internet", 5.0);
        Servicio s2 = new Servicio("Alquiler auto", 100.0);
        Servicio s3 = new Servicio("Lavanderia", 20.0);

        // Asignar servicios al hotel
        hotel.agregarServicio(s1);
        hotel.agregarServicio(s2);

        // Asignar servicios a la cabaña
        cabania.agregarServicio(s3);
        cabania.agregarServicio(s2);

        // Mostrar liquidaciones
        gerencia.mostrarLiquidacion();
    }
}
