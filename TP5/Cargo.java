import java.util.*;

/**
 * Representa un cargo docente dentro de una institución académica.
 * Encapsula la información del cargo, como nombre, sueldo básico,
 * antigüedad y horas de docencia, y calcula el sueldo final.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Cargo {
    private String nombreCargo;
    private double sueldoBasico;
    private int anioIngreso;
    private int horasDeDocencia;

    /**
     * Constructor para instanciar un objeto Cargo con sus atributos principales.
     * @param p_nombreCargo     Denominación del cargo.
     * @param p_sueldoBasico    Remuneración básica del cargo.
     * @param p_anioIngreso     Año de toma de posesión del cargo.
     * @param p_horasDeDocencia Carga horaria semanal dedicada a docencia.
     */
    public Cargo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDeDocencia) {
        this.setNombreCargo(p_nombreCargo);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAnioIngreso(p_anioIngreso);
        this.setHorasDeDocencia(p_horasDeDocencia);
    }

    /** Asigna el nombre del cargo. @param p_nombreCargo El nombre a asignar. */
    private void setNombreCargo(String p_nombreCargo) {
        this.nombreCargo = p_nombreCargo;
    }

    /** Asigna el sueldo básico. @param p_sueldoBasico El monto del sueldo a asignar. */
    private void setSueldoBasico(double p_sueldoBasico) {
        this.sueldoBasico = p_sueldoBasico;
    }

    /** Asigna el año de ingreso. @param p_anioIngreso El año a asignar. */
    private void setAnioIngreso(int p_anioIngreso) {
        this.anioIngreso = p_anioIngreso;
    }

    /** Asigna las horas de docencia. @param p_horasDeDocencia El número de horas a asignar. */
    private void setHorasDeDocencia(int p_horasDeDocencia) {
        this.horasDeDocencia = p_horasDeDocencia;
    }

    /** @return Devuelve el nombre del cargo. */
    public String getNombreCargo() {
        return this.nombreCargo;
    }

    /** @return Devuelve el sueldo básico del cargo. */
    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    /** @return Devuelve el año de ingreso al cargo. */
    public int getAnioIngreso() {
        return this.anioIngreso;
    }

    /** @return Devuelve las horas de docencia asignadas. */
    public int getHorasDeDocencia() {
        return this.horasDeDocencia;
    }

    /**
     * Calcula los años de antigüedad en el cargo.
     * @return El número de años de servicio en el cargo.
     */
    public int antiguedad() {
        return Calendar.getInstance().get(Calendar.YEAR) - this.getAnioIngreso();
    }

    /**
     * Calcula el monto adicional al sueldo en función de la antigüedad.
     * Corresponde al 1% del sueldo básico por cada año de antigüedad.
     * @return El monto del adicional por antigüedad.
     */
    public double adicionalXAntiguedad() {
        return this.getSueldoBasico() * 0.01 * this.antiguedad();
    }

    /**
     * Calcula el sueldo final del cargo.
     * Se obtiene de la suma del sueldo básico y el adicional por antigüedad.
     * @return El sueldo final del cargo.
     */
    public double sueldoDelCargo() {
        return this.getSueldoBasico() + this.adicionalXAntiguedad();
    }

    /**
     * Imprime en consola un resumen con la información del cargo,
     * incluyendo sueldos, antigüedad y horas de docencia.
     */
    public void mostrarCargo() {
        System.out.println(this.getNombreCargo() + "\t Sueldo Basico: " + this.getSueldoBasico() + "\t " +
                "Sueldo Cargo: " + this.sueldoDelCargo() + "\t- Antiguedad: " + this.antiguedad() + " años"
                + "\t - Horas de Docencia: " + this.getHorasDeDocencia());
    }

}
