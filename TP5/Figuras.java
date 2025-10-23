import java.util.Scanner;
import java.util.*;

/**
 * Clase ejecutable que simula una interfaz de consola para la gestión de
 * figuras geométricas. Provee un menú para la creación y visualización de
 * rectángulos, cuadrados, círculos y elipses.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Figuras {
    /**
     * Punto de entrada principal para la aplicación de gestión de figuras.
     * Gestiona la interacción con el usuario para crear y mostrar las
     * características de diversas figuras geométricas.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");

        ArrayList<Rectangulo> rectangulos = new ArrayList<>();
        ArrayList<Cuadrado> cuadrados = new ArrayList<>();
        ArrayList<Circulo> circulos = new ArrayList<>();
        ArrayList<Elipse> elipses = new ArrayList<>();

        int opcion = 0;

        do {
            System.out.println("\n--- Menú de Gestión de Figuras ---");
            System.out.println("1. Crear rectángulo");
            System.out.println("2. Crear cuadrado");
            System.out.println("3. Crear circulo");
            System.out.println("4. Crear elipse");
            System.out.println("5. Mostrar rectángulos");
            System.out.println("6. Mostrar cuadrados");
            System.out.println("7. Mostrar circulos");
            System.out.println("8. Mostrar elipses");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\n--- Crear Rectángulo ---");
                    System.out.println("Ingrese el origen del rectángulo: ");
                    System.out.println("\t X: ");
                    double xRec = teclado.nextDouble();
                    System.out.println("\t Y: ");
                    double yRec = teclado.nextDouble();
                    Punto origenRec = new Punto(xRec, yRec);
                    System.out.println("Ingrese el ancho del rectángulo: ");
                    double anchoRec = teclado.nextDouble();
                    System.out.println("Ingrese el alto del rectángulo: ");
                    double altoRec = teclado.nextDouble();
                    Rectangulo rectangulo = new Rectangulo(origenRec, anchoRec, altoRec);
                    rectangulos.add(rectangulo);
                    System.out.println("Rectángulo creado correctamente: " + rectangulo.nombreFigura());
                    break;

                case 2:
                    System.out.println("\n--- Crear Cuadrado ---");
                    System.out.println("Ingrese el origen del cuadrado: ");
                    System.out.println("\t X: ");
                    double xCua = teclado.nextDouble();
                    System.out.println("\t Y: ");
                    double yCua = teclado.nextDouble();
                    Punto origenCua = new Punto(xCua, yCua);
                    System.out.println("Ingrese el lado del cuadrado: ");
                    double ladoCua = teclado.nextDouble();
                    Cuadrado cuadrado = new Cuadrado(origenCua, ladoCua);
                    cuadrados.add(cuadrado);
                    System.out.println("Cuadrado creado correctamente: " + cuadrado.nombreFigura());
                    break;

                case 3:
                    System.out.println("\n--- Crear Circulo ---");
                    System.out.println("Ingrese el radio del circulo: ");
                    double radioCirc = teclado.nextDouble();
                    System.out.println("Ingrese el centro del circulo: ");
                    System.out.println("\t X: ");
                    double xCirc = teclado.nextDouble();
                    System.out.println("\t Y: ");
                    double yCirc = teclado.nextDouble();
                    Punto centroCirc = new Punto(xCirc, yCirc);
                    Circulo circulo = new Circulo(radioCirc, centroCirc);
                    circulos.add(circulo);
                    System.out.println("Circulo creado correctamente: " + circulo.nombreFigura());
                    break;

                case 4:
                    System.out.println("\n--- Crear Elipse ---");
                    System.out.println("Ingrese el semieje mayor de la elipse: ");
                    double sEjeMayorElip = teclado.nextDouble();
                    System.out.println("Ingrese el semieje menor de la elipse: ");
                    double sEjeMenorElip = teclado.nextDouble();
                    System.out.println("Ingrese el centro de la elipse: ");
                    System.out.println("\t X: ");
                    double xElip = teclado.nextDouble();
                    System.out.println("\t Y: ");
                    double yElip = teclado.nextDouble();
                    Punto centroElip = new Punto(xElip, yElip);
                    Elipse elipse = new Elipse(sEjeMayorElip, sEjeMenorElip, centroElip);
                    elipses.add(elipse);
                    System.out.println("Elipse creado correctamente: " + elipse.nombreFigura());
                    break;

                case 5:
                    System.out.println("\n--- Mostrar Rectángulos ---");
                    if (rectangulos.size() == 0) {
                        System.out.println("No hay rectángulos registrados.");
                        break;
                    }
                    for (int i = 0; i < rectangulos.size(); i++) {
                        System.out.println(i + 1 + ": ");
                        rectangulos.get(i).caracteristicas();
                    }
                    break;

                case 6:
                    System.out.println("\n--- Mostrar Cuadrados ---");
                    if (cuadrados.size() == 0) {
                        System.out.println("No hay cuadrados registrados.");
                        break;
                    }
                    for (int i = 0; i < cuadrados.size(); i++) {
                        System.out.println(i + 1 + ": ");
                        cuadrados.get(i).caracteristicas();
                    }
                    break;

                case 7:
                    System.out.println("\n--- Mostrar Circulos ---");
                    if (circulos.size() == 0) {
                        System.out.println("No hay circulos registrados.");
                        break;
                    }
                    for (int i = 0; i < circulos.size(); i++) {
                        System.out.println(i + 1 + ": ");
                        circulos.get(i).caracteristicas();
                    }
                    break;

                case 8:
                    System.out.println("\n--- Mostrar Elipses ---");
                    if (elipses.size() == 0) {
                        System.out.println("No hay elipses registradas.");
                        break;
                    }
                    for (int i = 0; i < elipses.size(); i++) {
                        System.out.println(i + 1 + ": ");
                        elipses.get(i).caracteristicas();
                    }
                    break;

                case 9:
                    System.out.println("Has salido del sistema de gestión de figuras.");
                    break;
            }
        } while (opcion != 9);
        teclado.close();
    }
}
