/**
 * Representa un punto en un plano cartesiano 2D.
 * Encapsula las coordenadas X e Y y provee métodos para operaciones
 * geométricas básicas.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Punto {
    private double x;
    private double y;

    /**
     * Constructor por defecto. Instancia un punto en el origen de coordenadas (0.0, 0.0).
     */
    public Punto() {
        this.setX(0.0);
        this.setY(0.0);
    }

    /**
     * Constructor para instanciar un punto en una ubicación específica.
     *
     * @param p_x Coordenada en el eje X.
     * @param p_y Coordenada en el eje Y.
     */
    public Punto(double p_x, double p_y) {
        this.setX(p_x);
        this.setY(p_y);
    }

    /** Asigna la coordenada en el eje X. @param p_x Valor de X a asignar. */
    private void setX(double p_x) {
        this.x = p_x;
    }

    /** Asigna la coordenada en el eje Y. @param p_y Valor de Y a asignar. */
    private void setY(double p_y) {
        this.y = p_y;
    }

    /** @return Devuelve la coordenada X del punto. */
    public double getX() {
        return this.x;
    }

    /** @return Devuelve la coordenada Y del punto. */
    public double getY() {
        return this.y;
    }

    /**
     * Desplaza el punto en el plano, sumando los valores proporcionados a sus
     * coordenadas actuales.
     *
     * @param p_dx Cantidad a desplazar en el eje X.
     * @param p_dy Cantidad a desplazar en el eje Y.
     */
    public void desplazar(double p_dx, double p_dy) {
        this.setX(this.getX() + p_dx);
        this.setY(this.getY() + p_dy);
    }

    /**
     * Calcula la distancia euclidiana desde este punto hasta otro.
     *
     * @param p_ptoDistante El otro punto para medir la distancia.
     * @return La distancia entre los dos puntos.
     */
    public double distanciaA(Punto p_ptoDistante) {
        return (Math.sqrt(
                (Math.pow(p_ptoDistante.getX() - this.getX(), 2) + (Math.pow(p_ptoDistante.getY() - this.getY(), 2)))));
    }

    /**
     * Imprime en consola las coordenadas del punto de forma descriptiva.
     */
    public void mostrar() {
        System.out.println("Punto. X: " + this.getX() + " , Y: " + this.getY());
    }

    /**
     * Devuelve una representación en formato de texto de las coordenadas del punto.
     *
     * @return Una cadena de texto con el formato "(x, y)".
     */
    public String coordenadas() {
        return "(" + this.getX() + ", " + this.getY() + ")";
    }
}
