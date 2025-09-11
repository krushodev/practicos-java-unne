/**
 * Representa un Hospital con su nombre y el nombre de su director.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Hospital
{
    private String nombreHospital;
    private String nombreDirector;

    /**
     * Constructor para crear un objeto Hospital.
     * @param p_nombreHospital Nombre del hospital.
     * @param p_nombreDirector Nombre del director del hospital.
     */
    public Hospital(String p_nombreHospital, String p_nombreDirector) {
        this.setNombreHospital(p_nombreHospital);
        this.setNombreDirector(p_nombreDirector);
    }

    /** Asigna el nombre del hospital. @param p_nombreHospital Nombre a asignar. */
    private void setNombreHospital(String p_nombreHospital) {
        this.nombreHospital = p_nombreHospital;
    }

    /** Asigna el nombre del director. @param p_nombreDirector Nombre a asignar. */
    private void setNombreDirector(String p_nombreDirector) {
        this.nombreDirector = p_nombreDirector;
    }
    
    /** @return Devuelve el nombre del hospital. */
    public String getNombreHospital() {
        return this.nombreHospital;
    }

    /** @return Devuelve el nombre del director. */
    public String getNombreDirector() {
        return this.nombreDirector;
    }
    
    /**
     * Muestra por consola los datos filiatorios de un paciente, precedidos por los datos del hospital.
     * @param p_paciente El paciente cuyos datos se van a consultar.
     */
    public void consultaDatosFiliatorios(Paciente p_paciente) {
        System.out.println("Hospital: " + this.getNombreHospital() + "\t Director: " + this.getNombreDirector());
        System.out.println("-----------------------------------------------------------------------------------------------");
        p_paciente.mostrarDatosPantalla();
    }
}
