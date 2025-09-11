/**
 * Representa una Caja de Ahorro, un tipo de cuenta bancaria con un límite de extracciones.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class CajaDeAhorro
{
    private int nroCuenta;
    private double saldo;
    private int extraccionesPosibles;
    private Persona titular;

    /**
     * Constructor para crear una Caja de Ahorro con saldo inicial cero y límite de extracciones por defecto.
     * @param p_nroCuenta Número de la cuenta.
     * @param p_titular Objeto Persona que es titular de la cuenta.
     */
    public CajaDeAhorro(int p_nroCuenta, Persona p_titular) {
        this.setNroCuenta(p_nroCuenta);
        this.setSaldo(0.0);
        this.setExtraccionesPosibles(10);
        this.setTitular(p_titular);
    }

    /**
     * Constructor para crear una Caja de Ahorro con un saldo inicial específico.
     * @param p_nroCuenta Número de la cuenta.
     * @param p_titular Objeto Persona que es titular de la cuenta.
     * @param p_saldo Saldo inicial de la cuenta.
     */
     public CajaDeAhorro(int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.setNroCuenta(p_nroCuenta);
        this.setSaldo(p_saldo);
        this.setExtraccionesPosibles(10);
        this.setTitular(p_titular);
    }


    /** Asigna el número de cuenta. @param p_nroCuenta Número a asignar. */
    private void setNroCuenta(int p_nroCuenta) {
        this.nroCuenta = p_nroCuenta;
    }

    /** Asigna el saldo. @param p_saldo Saldo a asignar. */
    private void setSaldo(double p_saldo) {
        this.saldo = p_saldo;
    }

    /** Asigna la cantidad de extracciones posibles. @param p_extraccionesPosibles Cantidad a asignar. */
    private void setExtraccionesPosibles(int p_extraccionesPosibles) {
        this.extraccionesPosibles = p_extraccionesPosibles;
    }

    /** Asigna el titular. @param p_titular Titular a asignar. */
    private void setTitular(Persona p_titular) {
        this.titular = p_titular;
    }
    
    /** @return Devuelve el número de cuenta. */
    public int getNroCuenta() {
        return this.nroCuenta;
    }

    /** @return Devuelve el saldo de la cuenta. */
    public double getSaldo() {
        return this.saldo;
    }
    
    /** @return Devuelve la cantidad de extracciones posibles. */
    public int getExtraccionesPosibles() {
        return this.extraccionesPosibles;
    }

    /** @return Devuelve el titular de la cuenta. */
    public Persona getTitular() {
        return this.titular;
    }
    
    /**
     * Verifica si se puede realizar una extracción considerando el saldo y las extracciones restantes.
     * @param p_importe El monto que se desea extraer.
     * @return `true` si la extracción es posible, `false` en caso contrario.
     */
    private boolean puedeExtraer(double p_importe) {
        if ((p_importe <= this.getSaldo()) && (this.getExtraccionesPosibles() > 0)) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Realiza la operación de extracción, disminuyendo el saldo y el contador de extracciones.
     * @param p_importe El monto a extraer.
     */
    private void extraccion(double p_importe) {
        this.setSaldo(this.getSaldo() - p_importe);
        this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
    }
    
    /**
     * Intenta extraer un importe de la cuenta. Si no es posible, muestra un mensaje de error.
     * @param p_importe El monto a extraer.
     */
    public void extraer(double p_importe) {
        if (this.puedeExtraer(p_importe)) {
            this.extraccion(p_importe);
        } else if ((p_importe > this.getSaldo())) {
            System.out.println("No puede extraer mas que el saldo!");
        } else {
            System.out.println("No tiene habilitadas mas extracciones!");
        }
    }
    
    /**
     * Deposita un importe en la cuenta, incrementando el saldo.
     * @param p_importe El monto a depositar.
     */
    public void depositar(double p_importe) {
        this.setSaldo(this.getSaldo() + p_importe);
    }
    
    /**
     * Muestra por consola los datos de la caja de ahorro.
     */
    public void mostrar() {
        System.out.println("- Caja de Ahorro - ");
        System.out.println("Nro. Cuenta: " + this.getNroCuenta() + " - Saldo: " + this.getSaldo());
        System.out.println("Titular: " + this.getTitular().nomYApe());
        System.out.println("Extracciones posibles: " + this.getExtraccionesPosibles());
    }
}
