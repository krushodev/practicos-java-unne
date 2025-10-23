/**
 * Representa una figura de Cuadrado, que es un caso especial de Rectángulo.
 * Hereda de la clase Rectangulo, restringiendo que el ancho y el alto sean iguales.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Cuadrado extends Rectangulo {

    /**
     * Constructor para instanciar un objeto Cuadrado a partir de su origen y la longitud de un lado.
     * Invoca al constructor de la clase padre (Rectangulo) con el mismo valor para ancho y alto.
     *
     * @param p_origen Punto de origen del cuadrado (esquina superior izquierda).
     * @param p_lado   Longitud del lado del cuadrado.
     */
    public Cuadrado(Punto p_origen, double p_lado) {
        super(p_origen, p_lado, p_lado);
    }

    /**
     * Imprime en consola las características del cuadrado, incluyendo su origen,
     * la longitud de su lado, superficie y perímetro.
     */
    public void caracteristicas() {
        System.out.println(this.nombreFigura());
        System.out
                .println("Origen: " + this.getOrigen().coordenadas() + " - Lado: " + this.getAncho());
        System.out.println("Superficie: " + this.superficie() + "  - Perímetro: " + this.perimetro());
    }

    /**
     * Devuelve el nombre de la figura.
     * @return Una cadena de texto que identifica a la figura como "Cuadrado".
     */
    public String nombreFigura() {
        return "****** Cuadrado ******";
    }

    /**
     * Imprime en consola la superficie del cuadrado.
     */
    public void mostrarSuperficie() {
        System.out.println(this.nombreFigura());
        System.out.println("Superficie: " + this.superficie());
    }
}
