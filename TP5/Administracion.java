import java.util.ArrayList;

/**
 * Clase ejecutable para la administración de figuras geométricas en un jardín.
 * Este programa crea diversas figuras, las agrupa en un objeto Jardin y calcula
 * la cantidad de pintura necesaria para cubrirlas.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Administracion {

    /**
     * Punto de entrada principal de la aplicación.
     * Crea instancias de Cuadrado, Triangulo, Circulo y Elipse, las agrega a un
     * Jardín y finalmente imprime un reporte con los detalles de las figuras y
     * los cálculos de pintura.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        // Crear figuras
        FiguraGeometrica cuadrado = new Cuadrado(new Punto(0, 0), 5);
        FiguraGeometrica triangulo = new Triangulo(new Punto(0, 0), 1.6, 1.6);
        FiguraGeometrica circulo = new Circulo(2, new Punto(0, 0));
        FiguraGeometrica elipse = new Elipse(6, 2.5, new Punto(0, 0));

        ArrayList<FiguraGeometrica> figuras = new ArrayList<>();
        figuras.add(cuadrado);
        figuras.add(triangulo);
        figuras.add(circulo);
        figuras.add(elipse);

        // Crear jardín y agregar figuras
        Jardin jardin = new Jardin("Bichito de Luz", figuras);

        // Mostrar detalle del presupuesto y cálculos generales
        jardin.detallesFiguras();
        System.out.println("--------------------------------------------------");
        System.out.println("La cantidad de latas de pintura necesarias son: " + jardin.cuantasLatas());
        System.out.println("La cantidad de metros que se pueden pintar son: " + String.format("%.2f", jardin.cuantosMetros()));
    }
}
