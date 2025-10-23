import java.util.ArrayList;

/**
 * Representa un jardín que contiene un conjunto de figuras geométricas.
 * Permite calcular la superficie total a pintar y la cantidad de pintura
 * necesaria en litros y latas.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Jardin {
    private String nombre;
    private ArrayList<FiguraGeometrica> figuras;

    /**
     * Constructor para instanciar un Jardin con un nombre y una lista de figuras.
     *
     * @param p_nombre  Nombre del jardín.
     * @param p_figuras Lista de figuras geométricas contenidas en el jardín.
     */
    public Jardin(String p_nombre, ArrayList<FiguraGeometrica> p_figuras) {
        this.setNombre(p_nombre);
        this.setFiguras(p_figuras);
    }

    /**
     * Asigna el nombre del jardín.
     * @param p_nombre Nombre a asignar.
     */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /**
     * Asigna la lista de figuras geométricas.
     * @param p_figuras Lista de figuras a asignar.
     */
    private void setFiguras(ArrayList<FiguraGeometrica> p_figuras) {
        this.figuras = p_figuras;
    }

    /**
     * Devuelve el nombre del jardín.
     * @return El nombre del jardín.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve la lista de figuras geométricas del jardín.
     * @return Una lista de objetos FiguraGeometrica.
     */
    public ArrayList<FiguraGeometrica> getFiguras() {
        return this.figuras;
    }

    /**
     * Calcula la cantidad total de litros de pintura necesarios, asumiendo un
     * rendimiento de 5 litros por metro cuadrado.
     *
     * @return La cantidad total de litros de pintura.
     */
    private double cuantosLitros() {
        double litrosTotal = 0.00;
        for (FiguraGeometrica figura : figuras) {
            litrosTotal += figura.superficie() * 5;
        }
        return litrosTotal;
    }

    /**
     * Calcula la cantidad de latas de pintura necesarias, asumiendo que cada
     * lata contiene 4 litros.
     *
     * @return El número de latas de pintura.
     */
    public int cuantasLatas() {
        // Se utiliza Math.ceil para redondear hacia arriba y asegurar latas completas.
        return (int) Math.ceil(this.cuantosLitros() / 4);
    }

    /**
     * Calcula la superficie total a pintar, sumando la superficie de todas
     * las figuras del jardín.
     *
     * @return La superficie total en metros cuadrados.
     */
    public double cuantosMetros() {
        double metrosTotal = 0.00;
        for (FiguraGeometrica figura : figuras) {
            metrosTotal += figura.superficie();
        }
        return metrosTotal;
    }

    /**
     * Imprime en consola los detalles de cada figura geométrica del jardín,
     * invocando el método `mostrarSuperficie()` de cada una.
     */
    public void detallesFiguras() {
        System.out.println("***** Detalle de figuras del jardín " + this.getNombre() + " *****");
        for (FiguraGeometrica figura : figuras) {
            figura.mostrarSuperficie();
        }
    }
}
