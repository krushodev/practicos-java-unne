/**
 * Representa a una Mujer con sus datos personales y estado civil.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Mujer
{
    private String nombre;
    private String apellido;
    private int edad;
    private String estadoCivil;
    private Hombre esposo;

    /**
     * Constructor para una mujer soltera.
     * @param p_nombre Nombre de la mujer.
     * @param p_apellido Apellido de la mujer.
     * @param p_edad Edad de la mujer.
     */
    public Mujer(String p_nombre, String p_apellido, int p_edad) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltera");
        this.setEsposo(null);
    }

    /**
     * Constructor para una mujer casada.
     * @param p_nombre Nombre de la mujer.
     * @param p_apellido Apellido de la mujer.
     * @param p_edad Edad de la mujer.
     * @param p_esposo El hombre con quien está casada.
     */
    public Mujer(String p_nombre, String p_apellido, int p_edad, Hombre p_esposo) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Casada");
        this.setEsposo(p_esposo);
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
    
    /** Asigna el esposo. @param p_esposo Esposo a asignar. */
    private void setEsposo(Hombre p_esposo) {
        this.esposo = p_esposo;
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

    /** @return Devuelve el esposo. */
    public Hombre getEsposo() {
        return this.esposo;
    }

    /**
     * Cambia el estado civil a "Casada" y asigna un esposo.
     * @param p_hombre El hombre con quien se casa.
     */
    public void casarseCon(Hombre p_hombre) {
        this.setEstadoCivil("Casada");
        this.setEsposo(p_hombre);
    }

    /**
     * Cambia el estado civil a "Divorciada" y elimina la referencia al esposo.
     */
    public void divorcio() {
        this.setEstadoCivil("Divorciada");
        this.setEsposo(null);
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
     * Muestra por consola si está casada y con quién, o su estado civil actual.
     */
    public void casadoCon() {
        if (this.getEstadoCivil().equals("Casada")) {
            System.out.println(this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años está " + this.getEstadoCivil() + " con " + this.getEsposo().datos());
        } else {
            System.out.println(this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años está " + this.getEstadoCivil());
        }
    }
    
}
