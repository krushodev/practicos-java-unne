/**
 * Representa una figura geométrica de tipo Triángulo.
 * Extiende a FiguraGeometrica, implementando el cálculo de su superficie
 * a partir de su base y altura.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    /**
     * Constructor para instanciar un Triangulo con un punto de origen,
     * base y altura.
     *
     * @param p_origen Punto de origen del triángulo.
     * @param p_base   Longitud de la base.
     * @param p_altura Altura del triángulo.
     */
    public Triangulo(Punto p_origen, double p_base, double p_altura) {
        super(p_origen);
        this.setBase(p_base);
        this.setAltura(p_altura);
    }

    /**
     * Asigna la longitud de la base del triángulo.
     * @param p_base Longitud de la base.
     */
    private void setBase(double p_base) {
        this.base = p_base;
    }

    /**
     * Asigna la altura del triángulo.
     * @param p_altura Altura del triángulo.
     */
    private void setAltura(double p_altura) {
        this.altura = p_altura;
    }

    /**
     * Devuelve la longitud de la base del triángulo.
     * @return La base del triángulo.
     */
    public double getBase() {
        return this.base;
    }

    /**
     * Devuelve la altura del triángulo.
     * @return La altura del triángulo.
     */
    public double getAltura() {
        return this.altura;
    }

    /**
     * Devuelve el nombre de la figura.
     * @return Una cadena con el nombre "****** Triángulo ******".
     */
    public String nombreFigura() {
        return "****** Triángulo ******";
    }

    /**
     * Calcula la superficie (área) del triángulo utilizando la fórmula
     * (base * altura) / 2.
     *
     * @return La superficie del triángulo.
     */
    public double superficie() {
        return (this.getBase() * this.getAltura()) / 2;
    }

    /**
     * Imprime en consola el nombre del triángulo y su superficie calculada.
     */
    public void mostrarSuperficie() {
        System.out.println(this.nombreFigura());
        System.out.println("Superficie: " + this.superficie());
    }
}
