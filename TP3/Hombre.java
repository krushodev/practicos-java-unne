/**
 * Representa a un Hombre con sus datos personales y estado civil.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Hombre
{
    private String nombre;
    private String apellido;
    private int edad;
    private String estadoCivil;
    private Mujer esposa;

    /**
     * Constructor para un hombre soltero.
     * @param p_nombre Nombre del hombre.
     * @param p_apellido Apellido del hombre.
     * @param p_edad Edad del hombre.
     */
    public Hombre(String p_nombre, String p_apellido, int p_edad) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltero");
        this.setEsposa(null);
    }

    /**
     * Constructor para un hombre casado.
     * @param p_nombre Nombre del hombre.
     * @param p_apellido Apellido del hombre.
     * @param p_edad Edad del hombre.
     * @param p_esposa La mujer con quien está casado.
     */
    public Hombre(String p_nombre, String p_apellido, int p_edad, Mujer p_esposa) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Casado");
        this.setEsposa(p_esposa);
    }

    /** Asigna el nombre. @param p_nombre Nombre a asignar. */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /** Asigna el apellido. @param p_apellido Apellido a asignar. */
    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }
    
    /** Asigna la edad. @param p_edad Edad a asignar. */
    private void setEdad(int p_edad) {
        this.edad = p_edad;
    }

    /** Asigna el estado civil. @param p_estadoCivil Estado civil a asignar. */
    private void setEstadoCivil(String p_estadoCivil) {
        this.estadoCivil = p_estadoCivil;
    }
    
    /** Asigna la esposa. @param p_esposa Esposa a asignar. */
    private void setEsposa(Mujer p_esposa) {
        this.esposa = p_esposa;
    }

    /** @return Devuelve el nombre. */
    public String getNombre() {
        return this.nombre;
    }
    
    /** @return Devuelve el apellido. */
    public String getApellido() {
        return this.apellido;
    }

    /** @return Devuelve la edad. */
    public int getEdad() {
        return this.edad;
    }
    
    /** @return Devuelve el estado civil. */
    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    /** @return Devuelve la esposa. */
    public Mujer getEsposa() {
        return this.esposa;
    }

    /**
     * Cambia el estado civil a "Casado" y asigna una esposa.
     * @param p_mujer La mujer con quien se casa.
     */
    public void casarseCon(Mujer p_mujer) {
        this.setEstadoCivil("Casado");
        this.setEsposa(p_mujer);
    }

    /**
     * Cambia el estado civil a "Divorciado" y elimina la referencia a la esposa.
     */
    public void divorcio() {
        this.setEstadoCivil("Divorciado");
        this.setEsposa(null);
    }

    /**
     * Devuelve un String con los datos básicos de la persona.
     * @return Un String con nombre, apellido y edad.
     */
    public String datos() {
        return this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años";
    }

    /**
     * Muestra por consola los datos y el estado civil.
     */
    public void mostrarEstadoCivil() {
        System.out.println(this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años - " + this.getEstadoCivil());
    }

    /**
     * Muestra por consola si está casado y con quién, o su estado civil actual.
     */
    public void casadoCon() {
        if (this.getEstadoCivil().equals("Casado")) {
            System.out.println(this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años está " + this.getEstadoCivil() + " con " + this.getEsposa().datos());
        } else {
            System.out.println(this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años está " + this.getEstadoCivil());
        }
    }
    
}
