/**
 * Representa un cargo docente de dedicación exclusiva, extendiendo la clase Cargo.
 * Añade atributos para las horas dedicadas a investigación y extensión.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Exclusivo extends Cargo {
    private int horasDeInvestigacion;
    private int horasDeExtension;
    
    /**
     * Constructor para instanciar un cargo de dedicación exclusiva.
     * @param p_nombreCargo         Denominación del cargo.
     * @param p_sueldoBasico        Remuneración básica del cargo.
     * @param p_anioIngreso         Año de toma de posesión del cargo.
     * @param p_horasDeDocencia     Carga horaria semanal dedicada a docencia.
     * @param p_horasDeInvestigacion Carga horaria semanal dedicada a investigación.
     * @param p_horasDeExtension    Carga horaria semanal dedicada a extensión.
     */
    public Exclusivo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDeDocencia, int p_horasDeInvestigacion, int p_horasDeExtension) {
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, p_horasDeDocencia);
        this.setHorasDeInvestigacion(p_horasDeInvestigacion);
        this.setHorasDeExtension(p_horasDeExtension);
    }

    /** Asigna las horas de investigación. @param p_horasDeInvestigacion El número de horas a asignar. */
    private void setHorasDeInvestigacion(int p_horasDeInvestigacion) {
        this.horasDeInvestigacion = p_horasDeInvestigacion;
    }
    
    /** Asigna las horas de extensión. @param p_horasDeExtension El número de horas a asignar. */
    private void setHorasDeExtension(int p_horasDeExtension) {
        this.horasDeExtension = p_horasDeExtension;
    }

    /** @return Devuelve las horas de investigación asignadas. */
    public int getHorasDeInvestigacion() {
        return this.horasDeInvestigacion;
    }

    /** @return Devuelve las horas de extensión asignadas. */
    public int getHorasDeExtension() {
        return this.horasDeExtension;
    }

    /**
     * Imprime en consola un resumen completo del cargo, incluyendo
     * la información del cargo base y las horas de investigación y extensión.
     */
    public void mostrarCargo() {
        super.mostrarCargo();
        System.out.println("\n---- Cargo de caracter Exclusivo ----");
        System.out.println("Horas de Investigacion: " + this.getHorasDeInvestigacion());
        System.out.println("Horas de Extension: " + this.getHorasDeExtension());
    }
}
