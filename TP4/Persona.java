import java.util.*;

/**
 * Representa a una persona con sus datos personales básicos.
 * Almacena DNI, nombre, apellido y fecha de nacimiento.
 * Permite calcular la edad y mostrar la información de forma formateada.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Persona
{
    private int nroDni; 
    private String nombre;
    private String apellido;
    private Calendar fechaNacimiento;

    /**
     * Constructor para inicializar un objeto Persona. La fecha de nacimiento se establece al 1 de enero del año proporcionado.
     * @param p_dni Número de DNI de la persona.
     * @param p_nombre Nombre de la persona.
     * @param p_apellido Apellido de la persona.
     * @param p_anio Año de nacimiento de la persona.
     */
    public Persona(int p_dni, String p_nombre, String p_apellido, int p_anio)
    {
        this.setDNI(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setAnioNacimiento(p_anio);
        
    }
    
    /**
     * Constructor para inicializar un objeto Persona con una fecha de nacimiento completa.
     * @param p_dni Número de DNI de la persona.
     * @param p_nombre Nombre de la persona.
     * @param p_apellido Apellido de la persona.
     * @param p_fecha Fecha de nacimiento de la persona como objeto Calendar.
     */
    public Persona(int p_dni, String p_nombre, String p_apellido, Calendar p_fecha)
    {
        this.setDNI(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setFechaNacimiento(p_fecha);
        
    }

    /** Asigna el número de DNI. @param p_dni DNI a asignar. */
    private void setDNI(int p_dni) {
        this.nroDni = p_dni;
    }
    
    /** Asigna el nombre. @param p_nombre Nombre a asignar. */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    
    /** Asigna el apellido. @param p_apellido Apellido a asignar. */
    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }

    /** Asigna el año de nacimiento, creando una fecha con día 1 y mes 1. @param p_anio Año a asignar. */
    private void setAnioNacimiento(int p_anio) {
        Calendar fecha = new GregorianCalendar(p_anio, 1, 1);
        this.setFechaNacimiento(fecha);
    }
    
    /** Asigna la fecha de nacimiento. @param p_fecha Fecha a asignar. */
    private void setFechaNacimiento(Calendar p_fecha) {
        this.fechaNacimiento = p_fecha;
    }
    
    /** @return Devuelve el número de DNI. */
    public int getDNI() {
        return this.nroDni;
    }
    
    /** @return Devuelve el nombre. */
    public String getNombre() {
        return this.nombre;
    }
    
    /** @return Devuelve el apellido. */
    public String getApellido() {
        return this.apellido;
    }
    
    /** @return Devuelve el año de nacimiento. */
    public int getAnioNacimiento() {
        return this.fechaNacimiento.get(Calendar.YEAR);
    }

    /** @return Devuelve la fecha de nacimiento como objeto Calendar. */
    public Calendar getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    /**
     * Calcula la edad de la persona basándose en el año actual.
     * @return La edad calculada como un número entero.
     */
    public int edad() {
        Calendar fechaHoy = new GregorianCalendar(); 
        int anioHoy  = fechaHoy.get(Calendar.YEAR); 
        
        return anioHoy - this.getAnioNacimiento();
    }
    
    /**
     * Concatena el nombre y el apellido.
     * @return Un String con el formato "Nombre Apellido".
     */
    public String nomYApe() {
       return this.getNombre() + " " + this.getApellido();
    }
    
    /**
     * Concatena el apellido y el nombre.
     * @return Un String con el formato "Apellido Nombre".
     */
    public String apeYNom() {
       return this.getApellido() + " " + this.getNombre(); 
    }
    
    /**
     * Muestra por consola los datos principales de la persona.
     * Incluye nombre completo, DNI y edad.
     */
    public void mostrar() {
        System.out.println("Nombre y Apellido: " + this.nomYApe());
        System.out.println("DNI: " + this.getDNI() + "\t" + "Edad: " + this.edad() + " años");
    }

    /**
     * Verifica si la fecha actual coincide con el cumpleaños de la persona.
     * @return `true` si es el cumpleaños, `false` en caso contrario.
     */
    public boolean esCumpleanios() {
        Calendar fechaHoy = new GregorianCalendar();
        
        return this.getFechaNacimiento().get(Calendar.DAY_OF_MONTH) == fechaHoy.get(Calendar.DAY_OF_MONTH) &&
               this.getFechaNacimiento().get(Calendar.MONTH) == fechaHoy.get(Calendar.MONTH);
    }
}
