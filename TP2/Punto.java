/**
 * Representa un punto en un plano cartesiano 2D con coordenadas X e Y.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Punto
{
    private double x;
    private double y;

    /**
     * Constructor por defecto. Crea un punto en el origen (0.0, 0.0).
     */
    public Punto()
    {
        this.setX(0.0);
        this.setY(0.0);
    }
    
    /**
     * Constructor que crea un punto en las coordenadas especificadas.
     * @param p_x Coordenada en el eje X.
     * @param p_y Coordenada en el eje Y.
     */
    public Punto(double p_x, double p_y)
    {
        this.setX(p_x);
        this.setY(p_y);
    }
    
    /** Asigna la coordenada X. @param p_x Valor de X a asignar. */
    private void setX(double p_x) {
        this.x = p_x;
    }
    
    /** Asigna la coordenada Y. @param p_y Valor de Y a asignar. */
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
     * Desplaza el punto sumando los valores proporcionados a sus coordenadas actuales.
     * @param p_dx Cantidad a desplazar en el eje X.
     * @param p_dy Cantidad a desplazar en el eje Y.
     */
    public void desplazar(double p_dx, double p_dy) {
        this.setX(this.getX() + p_dx);
        this.setY(this.getY() + p_dy);
    }
    
    /**
     * Muestra por consola las coordenadas del punto de forma descriptiva.
     */
    public void mostrar() {
        System.out.println("Punto. X: " + this.getX() + " , Y: " + this.getY());
    }
    
    /**
     * Devuelve las coordenadas del punto en formato de texto "(x, y)".
     * @return Un String con las coordenadas formateadas.
     */
    public String coordenadas() {
        return "(" + this.getX() + ", " + this.getY() + ")";
    }
}
