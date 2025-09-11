import java.util.*;

/**
 * Representa un Empleado que puede tener un Jefe (otro Empleado).
 * Contiene datos personales, laborales y la relación de jerarquía.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class EmpleadoConJefe
{
    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private Calendar fechaIngreso;
    private EmpleadoConJefe jefe;

    /**
     * Constructor completo para crear un Empleado con un Jefe asignado.
     * @param p_cuil CUIL del empleado.
     * @param p_apellido Apellido del empleado.
     * @param p_nombre Nombre del empleado.
     * @param p_importe Sueldo básico del empleado.
     * @param p_fecha Fecha de ingreso a la empresa.
     * @param p_jefe Jefe directo del empleado.
     */
    public EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha, EmpleadoConJefe p_jefe)
    {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setFechaIngreso(p_fecha);
        this.setJefe(p_jefe);
    }

    /**
     * Constructor para crear un Empleado sin Jefe, a partir del año de ingreso.
     * @param p_cuil CUIL del empleado.
     * @param p_apellido Apellido del empleado.
     * @param p_nombre Nombre del empleado.
     * @param p_importe Sueldo básico del empleado.
     * @param p_anio Año de ingreso a la empresa.
     */
    public EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_importe, int p_anio)
    {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setAnioIngreso(p_anio);
        this.setJefe(null);
    }

    /**
     * Constructor para crear un Empleado sin Jefe, a partir de una fecha de ingreso completa.
     * @param p_cuil CUIL del empleado.
     * @param p_apellido Apellido del empleado.
     * @param p_nombre Nombre del empleado.
     * @param p_importe Sueldo básico del empleado.
     * @param p_fecha Fecha de ingreso a la empresa.
     */
     public EmpleadoConJefe(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha)
    {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setFechaIngreso(p_fecha);
        this.setJefe(null);
    }
    
    /** Asigna el CUIL. @param p_cuil CUIL a asignar. */
    private void setCuil(long p_cuil) {
        this.cuil = p_cuil;
    }
    
    /** Asigna el apellido. @param p_apellido Apellido a asignar. */
    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }

    
    /** Asigna el nombre. @param p_nombre Nombre a asignar. */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    
    
    /** Asigna el sueldo básico. @param p_sueldoBasico Sueldo a asignar. */
    private void setSueldoBasico(double p_sueldoBasico) {
        this.sueldoBasico = p_sueldoBasico;
    }
    
    /** Asigna el año de ingreso, creando una fecha con día 1 y mes 1. @param p_anioIngreso Año a asignar. */
    private void setAnioIngreso(int p_anioIngreso) {
        Calendar fecha = new GregorianCalendar(p_anioIngreso, 0, 1);
        this.setFechaIngreso(fecha);
    }

    /** Asigna la fecha de ingreso. @param p_fechaIngreso Fecha a asignar. */
    private void setFechaIngreso(Calendar p_fechaIngreso) {
        this.fechaIngreso = p_fechaIngreso;
    }

    /** Asigna el jefe. @param p_jefe Jefe a asignar. */
    private void setJefe(EmpleadoConJefe p_jefe) {
        this.jefe = p_jefe;
    }

    /** @return Devuelve el CUIL del empleado. */
    public long getCuil() {
        return this.cuil;
    }
    
    /** @return Devuelve el apellido del empleado. */
    public String getApellido() {
        return this.apellido;
    }
    
    /** @return Devuelve el nombre del empleado. */
    public String getNombre() {
        return this.nombre;
    }
    
    /** @return Devuelve el sueldo básico del empleado. */
    public double getSueldoBasico() {
        return this.sueldoBasico;
    }
    
    /** @return Devuelve el año de ingreso del empleado. */
    public int getAnioIngreso() {
        return this.fechaIngreso.get(Calendar.YEAR);
    }

    /** @return Devuelve la fecha de ingreso del empleado. */
    public Calendar getFechaIngreso() {
        return this.fechaIngreso;
    }

    /** @return Devuelve el jefe del empleado. */
    public EmpleadoConJefe getJefe() {
        return this.jefe;
    }
    
    /**
     * Calcula los años de antigüedad del empleado en la empresa.
     * @return El número de años de antigüedad.
     */
    public int antiguedad() {
        Calendar fechaHoy = new GregorianCalendar(); 
        int anioHoy  = fechaHoy.get(Calendar.YEAR); 
        
        return anioHoy - this.getAnioIngreso();
    }
    
    /**
     * Calcula el descuento a aplicar sobre el sueldo.
     * @return El monto total del descuento.
     */
    private double descuento() {
      return ((this.getSueldoBasico() * 0.02) + 1500);
    }
    
    /**
     * Calcula el monto adicional por antigüedad.
     * @return El monto del adicional a sumar al sueldo.
     */
    private double adicional() {
      if (this.antiguedad() < 2){
          return ((this.getSueldoBasico() * 0.02));
      } else if (this.antiguedad() >= 2 && this.antiguedad() < 10) {  
          return ((this.getSueldoBasico() * 0.04));
      } 
      
      return ((this.getSueldoBasico() * 0.06));
    }
    
    /**
     * Calcula el sueldo neto del empleado (básico + adicional - descuento).
     * @return El sueldo neto final.
     */
    public double sueldoNeto() {
        return ((this.getSueldoBasico() + this.adicional()) - this.descuento());
    }
    
    /**
     * Concatena el apellido y el nombre del empleado.
     * @return Un String con el formato "Apellido Nombre".
     */
    public String apeYNom() {
       return this.getApellido() + " " + this.getNombre();
    }
    
    /**
     * Concatena el nombre y el apellido del empleado.
     * @return Un String con el formato "Nombre Apellido".
     */
    public String nomYApe() {
       return this.getNombre() + " " + this.getApellido();
    }
    
    /**
     * Muestra por consola un resumen detallado del empleado y su jefe (si lo tiene).
     */
    public void mostrarPantalla() {
        System.out.println("Nombre y Apellido " + this.nomYApe());
        System.out.println("CUIL: " + this.getCuil() + "\t" + "Antigüedad: " + this.antiguedad() + " años de servicio");
        System.out.println("Sueldo Neto: $" + this.sueldoNeto());
        if (this.getJefe() != null) {
            System.out.println("Responde a: " + this.getJefe().getApellido() + ", " + this.getJefe().getNombre());
        } else {
            System.out.println("Responde a: GERENTE GENERAL");
        }
    }
    
    /**
     * Genera una línea de texto con los datos principales para un listado.
     * @return Un String formateado con CUIL, nombre completo y sueldo neto.
     */
    public String mostrarLinea() {
        return this.getCuil() + "\t" + this.getApellido() + ", " + this.getNombre() + ".............. \t$" + this.sueldoNeto();
    }

    /**
     * Verifica si la fecha actual coincide con el aniversario de ingreso del empleado.
     * @return `true` si es el aniversario, `false` en caso contrario.
     */
    public boolean esAniversario() {
        Calendar fechaHoy = new GregorianCalendar();
        Calendar fechaIngreso = this.getFechaIngreso();
        return fechaHoy.get(Calendar.MONTH) == fechaIngreso.get(Calendar.MONTH) && fechaHoy.get(Calendar.DAY_OF_MONTH) == fechaIngreso.get(Calendar.DAY_OF_MONTH);
    }
}
