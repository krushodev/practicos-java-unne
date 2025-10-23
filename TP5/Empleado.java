import java.util.*;

/**
 * Representa un empleado, extendiendo la clase Persona para incluir
 * datos laborales como CUIL, sueldo, fecha de ingreso y jerarquía (jefe).
 * Provee funcionalidades para calcular antigüedad, liquidación de sueldo y
 * mostrar información laboral.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Empleado extends Persona {
    private long cuil;
    private double sueldoBasico;
    private Calendar fechaIngreso;
    private Empleado jefe;

    /**
     * Constructor completo para instanciar un Empleado con un jefe directo asignado.
     * @param p_cuil            CUIL del empleado.
     * @param p_apellido        Apellido del empleado.
     * @param p_nombre          Nombre de pila del empleado.
     * @param p_importe         Sueldo básico del empleado.
     * @param p_fecha           Fecha de ingreso a la empresa.
     * @param p_jefe            Objeto Empleado que es jefe directo.
     * @param p_dni             DNI del empleado.
     * @param p_fechaNacimiento Fecha de nacimiento del empleado.
     */
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha,
            Empleado p_jefe, int p_dni, Calendar p_fechaNacimiento) {
        super(p_dni, p_nombre, p_apellido, p_fechaNacimiento);
        this.setCuil(p_cuil);
        this.setSueldoBasico(p_importe);
        this.setFechaIngreso(p_fecha);
        this.setJefe(p_jefe);
    }

    /**
     * Constructor para instanciar un Empleado sin jefe directo, a partir del año de ingreso.
     * @param p_cuil            CUIL del empleado.
     * @param p_apellido        Apellido del empleado.
     * @param p_nombre          Nombre de pila del empleado.
     * @param p_importe         Sueldo básico del empleado.
     * @param p_anio            Año de ingreso a la empresa.
     * @param p_dni             DNI del empleado.
     * @param p_fechaNacimiento Fecha de nacimiento del empleado.
     */
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, int p_anio, int p_dni,
            Calendar p_fechaNacimiento) {
        super(p_dni, p_nombre, p_apellido, p_fechaNacimiento);
        this.setCuil(p_cuil);
        this.setSueldoBasico(p_importe);
        this.setAnioIngreso(p_anio);
        this.setJefe(null);
    }

    /**
     * Constructor para instanciar un Empleado sin jefe directo, con fecha de ingreso completa.
     * @param p_cuil            CUIL del empleado.
     * @param p_apellido        Apellido del empleado.
     * @param p_nombre          Nombre de pila del empleado.
     * @param p_importe         Sueldo básico del empleado.
     * @param p_fecha           Fecha de ingreso a la empresa.
     * @param p_dni             DNI del empleado.
     * @param p_fechaNacimiento Fecha de nacimiento del empleado.
     */
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha, int p_dni,
            Calendar p_fechaNacimiento) {
        super(p_dni, p_nombre, p_apellido, p_fechaNacimiento);
        this.setCuil(p_cuil);
        this.setSueldoBasico(p_importe);
        this.setFechaIngreso(p_fecha);
        this.setJefe(null);
    }

    /** Asigna el CUIL. @param p_cuil Valor de CUIL a asignar. */
    private void setCuil(long p_cuil) {
        this.cuil = p_cuil;
    }

    /** Asigna el sueldo básico. @param p_sueldoBasico Valor de sueldo a asignar. */
    private void setSueldoBasico(double p_sueldoBasico) {
        this.sueldoBasico = p_sueldoBasico;
    }

    /**
     * Asigna el año de ingreso, instanciando una fecha con día 1 y mes de enero.
     * @param p_anioIngreso Año a asignar en el objeto Calendar de ingreso.
     */
    private void setAnioIngreso(int p_anioIngreso) {
        Calendar fecha = new GregorianCalendar(p_anioIngreso, 0, 1);
        this.setFechaIngreso(fecha);
    }

    /** Asigna la fecha de ingreso. @param p_fechaIngreso Objeto Calendar a asignar. */
    private void setFechaIngreso(Calendar p_fechaIngreso) {
        this.fechaIngreso = p_fechaIngreso;
    }

    /** Asigna el jefe directo. @param p_jefe Objeto Empleado a asignar como jefe. */
    private void setJefe(Empleado p_jefe) {
        this.jefe = p_jefe;
    }

    /** @return Devuelve el CUIL del empleado. */
    public long getCuil() {
        return this.cuil;
    }

    /** @return Devuelve el sueldo básico del empleado. */
    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    /** @return Devuelve el año de ingreso. */
    public int getAnioIngreso() {
        return this.fechaIngreso.get(Calendar.YEAR);
    }

    /** @return Devuelve la fecha de ingreso como objeto Calendar. */
    public Calendar getFechaIngreso() {
        return this.fechaIngreso;
    }

    /** @return Devuelve el objeto Empleado que es jefe directo. */
    public Empleado getJefe() {
        return this.jefe;
    }

    /**
     * Calcula los años de antigüedad del empleado en la empresa.
     * @return El número de años de servicio.
     */
    public int antiguedad() {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);

        return anioHoy - this.getAnioIngreso();
    }

    /**
     * Calcula el monto del descuento a aplicar sobre el sueldo básico.
     * Corresponde a un 2% del básico más un valor fijo de 1500.
     * @return El monto total del descuento.
     */
    private double descuento() {
        return ((this.getSueldoBasico() * 0.02) + 1500);
    }

    /**
     * Calcula el monto adicional al sueldo según la antigüedad.
     * El porcentaje varía en tramos: 2% (< 2 años), 4% (2 a 9 años), 6% (>= 10 años).
     * @return El monto del adicional por antigüedad.
     */
    private double adicional() {
        if (this.antiguedad() < 2) {
            return ((this.getSueldoBasico() * 0.02));
        } else if (this.antiguedad() >= 2 && this.antiguedad() < 10) {
            return ((this.getSueldoBasico() * 0.04));
        }

        return ((this.getSueldoBasico() * 0.06));
    }

    /**
     * Calcula el sueldo neto del empleado.
     * Se obtiene de la fórmula: sueldo básico + adicional - descuento.
     * @return El sueldo neto final.
     */
    public double sueldoNeto() {
        return ((this.getSueldoBasico() + this.adicional()) - this.descuento());
    }

    /**
     * Imprime en consola un resumen detallado del empleado, incluyendo
     * datos personales, laborales, salariales y de jerarquía.
     */
    public void mostrarPantalla() {
        System.out.println("Nombre y Apellido " + super.nomYApe());
        System.out.println("CUIL: " + this.getCuil() + "\t" + "Antigüedad: " + this.antiguedad() + " años de servicio");
        System.out.println("Sueldo Neto: $" + this.sueldoNeto());
        if (this.getJefe() != null) {
            System.out.println("Responde a: " + this.getJefe().getApellido() + ", " + this.getJefe().getNombre());
        } else {
            System.out.println("Responde a: GERENTE GENERAL");
        }
    }

    /**
     * Genera una cadena de texto formateada para ser usada en listados o nóminas.
     * @return Un String con CUIL, Apellido, Nombre y Sueldo Neto.
     */
    public String mostrarLinea() {
        return this.getCuil() + "\t" + this.getApellido() + ", " + this.getNombre() + ".............. \t$"
                + this.sueldoNeto();
    }

    /**
     * Verifica si la fecha actual coincide con el aniversario de ingreso del empleado.
     * @return `true` si es el aniversario, `false` en caso contrario.
     */
    public boolean esAniversario() {
        Calendar fechaHoy = new GregorianCalendar();
        Calendar fechaIngreso = this.getFechaIngreso();
        return fechaHoy.get(Calendar.MONTH) == fechaIngreso.get(Calendar.MONTH)
                && fechaHoy.get(Calendar.DAY_OF_MONTH) == fechaIngreso.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Imprime en consola un resumen con los datos del empleado.
     * Muestra información personal (heredada de Persona) y laboral
     * (CUIL, antigüedad y sueldo neto).
     */
    public void mostrar() {
        super.mostrar();
        System.out.println("CUIL: " + this.getCuil() + "\t" + "Antigüedad: " + this.antiguedad() + " años de servicio");
        System.out.println("Sueldo Neto: $" + this.sueldoNeto());
    }
}
