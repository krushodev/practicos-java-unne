/**
 * Representa un cargo docente de dedicación semiexclusiva, extendiendo la clase Cargo.
 * Añade atributos para las horas dedicadas a investigación.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class SemiExclusivo extends Cargo {
    private int horasDeInvestigacion;

    /**
     * Constructor para instanciar un cargo de dedicación semiexclusiva.
     * @param p_nombreCargo          Denominación del cargo.
     * @param p_sueldoBasico         Remuneración básica del cargo.
     * @param p_anioIngreso          Año de toma de posesión del cargo.
     * @param p_horasDeDocencia      Carga horaria semanal dedicada a docencia.
     * @param p_horasDeInvestigacion Carga horaria semanal dedicada a investigación.
     */
    public SemiExclusivo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDeDocencia,
            int p_horasDeInvestigacion) {
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, p_horasDeDocencia);
        this.setHorasDeInvestigacion(p_horasDeInvestigacion);
    }

    /** Asigna las horas de investigación. @param p_horasDeInvestigacion El número de horas a asignar. */
    private void setHorasDeInvestigacion(int p_horasDeInvestigacion) {
        this.horasDeInvestigacion = p_horasDeInvestigacion;
    }

    /** @return Devuelve las horas de investigación asignadas. */
    public int getHorasDeInvestigacion() {
        return this.horasDeInvestigacion;
    }

    /**
     * Imprime en consola un resumen completo del cargo, incluyendo
     * la información del cargo base y las horas de investigación.
     */
    public void mostrarCargo() {
        super.mostrarCargo();
        System.out.println("\n---- Cargo de caracter SemiExclusivo ----");
        System.out.println("Horas de Investigacion: " + this.getHorasDeInvestigacion());
    }
}
