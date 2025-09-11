/**
 * Representa a un Paciente de un hospital.
 * Contiene datos personales y de residencia.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Paciente
{
    private int historiaClinica;
    private String nombre;
    private String domicilio;
    private Localidad localidadNacido;
    private Localidad localidadVive;

    /**
     * Constructor para crear un objeto Paciente.
     * @param p_historiaClinica Número de historia clínica.
     * @param p_nombre Nombre del paciente.
     * @param p_domicilio Domicilio del paciente.
     * @param p_localidadNacido Localidad de nacimiento del paciente.
     * @param p_localidadVive Localidad de residencia actual del paciente.
     */
    public Paciente(int p_historiaClinica, String p_nombre, String p_domicilio, Localidad p_localidadNacido, Localidad p_localidadVive) {
        this.setHistoriaClinica(p_historiaClinica);
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setNacido(p_localidadNacido);
        this.setVive(p_localidadVive);
    }

    /** Asigna la historia clínica. @param p_historiaClinica Número a asignar. */
    private void setHistoriaClinica(int p_historiaClinica) {
        this.historiaClinica = p_historiaClinica;
    }

    /** Asigna el nombre. @param p_nombre Nombre a asignar. */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /** Asigna el domicilio. @param p_domicilio Domicilio a asignar. */
    private void setDomicilio(String p_domicilio) { 
        this.domicilio = p_domicilio;
    }

    /** Asigna la localidad de nacimiento. @param p_nacido Localidad a asignar. */
    private void setNacido(Localidad p_nacido) {
        this.localidadNacido = p_nacido;
    }
    /** Asigna la localidad de residencia. @param p_vive Localidad a asignar. */
    private void setVive(Localidad p_vive) {
        this.localidadVive = p_vive;
    }

    /** @return Devuelve el número de historia clínica. */
    public int getHistoriaClinica() {
        return this.historiaClinica;
    }

    /** @return Devuelve el nombre del paciente. */
    public String getNombre() { 
        return this.nombre;
    }

    /** @return Devuelve el domicilio del paciente. */
    public String getDomicilio() {
        return this.domicilio;
    }

    /** @return Devuelve la localidad de nacimiento. */
    public Localidad getNacido() {
        return this.localidadNacido;
    }

    /** @return Devuelve la localidad de residencia. */
    public Localidad getVive() {
        return this.localidadVive;
    }
    
    /**
     * Muestra por consola los datos principales del paciente.
     */
    public void mostrarDatosPantalla() {
        System.out.println("Paciente " + this.getNombre() + "\t Historia Clínica: " + this.getHistoriaClinica() + "\t Domicilio: " + this.getDomicilio());
        System.out.println(this.getVive().mostrar());
    }
    
    /**
     * Devuelve una cadena de texto con los datos del paciente concatenados.
     * @return Un String con los datos del paciente para listados o reportes.
     */
    public String cadenaDeDatos() {
        return this.getNombre() + "....." + this.getHistoriaClinica() + "....." + this.getDomicilio() + " - " + this.getVive().getNombre() + " - " + this.getVive().getProvincia();
    }

}
