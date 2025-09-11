/**
 * Modela un Alumno con sus datos académicos básicos.
 * Almacena LU, nombre, apellido y dos notas. Calcula promedio y condición.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Alumno
{
    private int lu;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;

    /**
     * Constructor para crear un Alumno con sus datos personales.
     * Las notas se inicializan en 0.0.
     * @param p_lu Libreta Universitaria del alumno.
     * @param p_nombre Nombre del alumno.
     * @param p_apellido Apellido del alumno.
     */
    public Alumno(int p_lu, String p_nombre, String p_apellido)
    {
        this.setLu(p_lu);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setNota1(0.0);
        this.setNota2(0.0);
    }
    
    /** Asigna la LU. @param p_lu LU a asignar. */
    private void setLu(int p_lu) {
        this.lu = p_lu;
    }
    
    /** Asigna el nombre. @param p_nombre Nombre a asignar. */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    
    /** Asigna el apellido. @param p_apellido Apellido a asignar. */
    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }

    /** Asigna la primera nota. @param p_nota Nota a asignar. */
    public void setNota1(double p_nota) {
        this.nota1 = p_nota;
    }
    
    /** Asigna la segunda nota. @param p_nota Nota a asignar. */
    public void setNota2(double p_nota) {
        this.nota2 = p_nota;
    }

    /** @return Devuelve la LU del alumno. */
    public int getLu() {
        return this.lu;
    }
    
    /** @return Devuelve el nombre del alumno. */
    public String getNombre() {
        return this.nombre;
    }
    
    /** @return Devuelve el apellido del alumno. */
    public String getApellido() {
        return this.apellido;
    }
    
    /** @return Devuelve la primera nota. */
    public double getNota1() {
        return this.nota1;
    }
    
    /** @return Devuelve la segunda nota. */
    public double getNota2() {
        return this.nota2;
    }
    
    /**
     * Calcula el promedio entre las dos notas del alumno.
     * @return El promedio de las notas.
     */
    public double promedio() {
        return ((this.getNota1() + this.getNota2()) / 2);
    }
    
    /**
     * Determina si el alumno aprueba, según un criterio de promedio.
     * @return `true` si el promedio es mayor a 8, `false` en caso contrario.
     */
    private boolean aprueba() {
      if (this.promedio() >= 8) {
          return true;
      } 
      
      return false;
    }
    
    /**
     * Devuelve un texto indicando la condición del alumno.
     * @return "APROBADO" o "DESAPROBADO" según el resultado del método aprueba().
     */
    public String leyendaAprueba() {
       if (this.aprueba()) {
           return "APROBADO";
       }
       
       return "DESAPROBADO";
    }
    
    /**
     * Concatena el apellido y el nombre del alumno.
     * @return Un String con el formato "Apellido Nombre".
     */
    public String apeYNom() {
       return this.getApellido() + " " + this.getNombre();
    }
    
    /**
     * Concatena el nombre y el apellido del alumno.
     * @return Un String con el formato "Nombre Apellido".
     */
    public String nomYApe() {
       return this.getNombre() + " " + this.getApellido();
    }
    
    /**
     * Muestra por consola un resumen completo del alumno: datos, notas, promedio y condición.
     */
    public void mostrar() {
        System.out.println("Nombre y Apellido: " + this.nomYApe());
        System.out.println("LU: " + this.getLu() + "\t" + "Notas: " + this.getNota1() + " - " + this.getNota2());
        System.out.println("Promedio: " + this.promedio() + " - " + this.leyendaAprueba());
    }
}
