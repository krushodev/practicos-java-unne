import java.util.*;

/**
 * Representa una sucursal bancaria que gestiona colecciones de empleados y cuentas bancarias.
 * Provee funcionalidades para administrar personal, cuentas, y generar reportes financieros
 * y de estado de cuentas.
 *
 * @author Kruchowski, Juan Ignacio
 * @version 1.0
 */
public class Banco {
    private String nombre;
    private int nroSucursal;
    private Localidad localidad;
    private ArrayList<Empleado> empleados;
    private ArrayList<CuentaBancaria> cuentasBancarias;

    /**
     * Constructor para instanciar un objeto Banco con un empleado inicial.
     * @param p_nombre Nombre comercial del banco.
     * @param p_localidad Objeto Localidad donde se ubica la sucursal.
     * @param p_nroSucursal Número identificatorio de la sucursal.
     * @param p_empleado Objeto Empleado a ser agregado inicialmente a la nómina.
     */
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, Empleado p_empleado) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(new ArrayList<Empleado>());
        this.getEmpleados().add(p_empleado);
        this.setCuentasBancarias(new ArrayList<CuentaBancaria>());
    }

    /**
     * Constructor para instanciar un objeto Banco con una nómina de empleados preexistente.
     * @param p_nombre Nombre comercial del banco.
     * @param p_localidad Objeto Localidad donde se ubica la sucursal.
     * @param p_nroSucursal Número identificatorio de la sucursal.
     * @param p_empleados Colección ArrayList de objetos Empleado.
     */
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList<Empleado> p_empleados) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        this.setCuentasBancarias(new ArrayList<CuentaBancaria>());
    }

    /**
     * Constructor completo para instanciar un objeto Banco con nómina de empleados y cartera de cuentas.
     * @param p_nombre Nombre comercial del banco.
     * @param p_localidad Objeto Localidad donde se ubica la sucursal.
     * @param p_nroSucursal Número identificatorio de la sucursal.
     * @param p_empleados Colección ArrayList de objetos Empleado.
     * @param p_cuentas Colección ArrayList de objetos CuentaBancaria.
     */
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList<Empleado> p_empleados,
            ArrayList<CuentaBancaria> p_cuentas) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        this.setCuentasBancarias(p_cuentas);
    }

    /** Asigna el nombre del banco. @param p_nombre El nombre a asignar. */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /** Asigna la localidad de la sucursal. @param p_localidad El objeto Localidad a asignar. */
    private void setLocalidad(Localidad p_localidad) {
        this.localidad = p_localidad;
    }

    /** Asigna el número de la sucursal. @param p_nroSucursal El número a asignar. */
    private void setNroSucursal(int p_nroSucursal) {
        this.nroSucursal = p_nroSucursal;
    }

    /** Asigna la colección de empleados. @param p_empleados La colección ArrayList a asignar. */
    private void setEmpleados(ArrayList<Empleado> p_empleados) {
        this.empleados = p_empleados;
    }

    /** Asigna la colección de cuentas bancarias. @param p_cuentasBancarias La colección ArrayList a asignar. */
    private void setCuentasBancarias(ArrayList<CuentaBancaria> p_cuentasBancarias) {
        this.cuentasBancarias = p_cuentasBancarias;
    }

    /** @return Devuelve el nombre del banco. */
    public String getNombre() {
        return this.nombre;
    }

    /** @return Devuelve el objeto Localidad de la sucursal. */
    public Localidad getLocalidad() {
        return this.localidad;
    }

    /** @return Devuelve el número de la sucursal. */
    public int getNroSucursal() {
        return this.nroSucursal;
    }

    /** @return Devuelve la colección ArrayList de empleados. */
    public ArrayList<Empleado> getEmpleados() {
        return this.empleados;
    }

    /** @return Devuelve la colección ArrayList de cuentas bancarias. */
    public ArrayList<CuentaBancaria> getCuentasBancarias() {
        return this.cuentasBancarias;
    }

    /**
     * Agrega un nuevo empleado a la nómina del banco.
     * @param p_empleado El objeto Empleado a agregar.
     * @return `true` si la operación de agregado fue exitosa.
     */
    public boolean agregarEmpleado(Empleado p_empleado) {
        return this.getEmpleados().add(p_empleado);
    }

    /**
     * Remueve un empleado existente de la nómina del banco.
     * @param p_empleado El objeto Empleado a remover.
     * @return `true` si la operación de remoción fue exitosa.
     */
    public boolean quitarEmpleado(Empleado p_empleado) {
        return this.getEmpleados().remove(p_empleado);
    }

    /**
     * Imprime en consola un listado formateado con el sueldo básico de cada empleado.
     */
    public void listarSueldos() {
        for (Empleado empleado : this.getEmpleados()) {
            System.out.println(empleado.getCuil() + "  " + empleado.getApellido() + ", " + empleado.getNombre()
                    + ", --------------------------------------------  $" + empleado.getSueldoBasico());
        }
    }

    /**
     * Calcula la suma total de los sueldos básicos de todos los empleados.
     * @return El monto total a pagar en concepto de sueldos básicos.
     */
    public double sueldosAPagar() {
        double total = 0;
        for (Empleado empleado : this.getEmpleados()) {
            total += empleado.getSueldoBasico();
        }
        return total;
    }

    /**
     * Imprime en consola un reporte general del banco, incluyendo datos de la sucursal y la nómina de sueldos.
     */
    public void mostrar() {
        System.out.println("Nombre: " + this.getNombre() + "    Sucursal: " + this.getNroSucursal());
        System.out.println("Localidad: " + this.getLocalidad().getNombre() + "    Provincia: "
                + this.getLocalidad().getProvincia());
        System.out.println("\n");
        this.listarSueldos();
        System.out.println("\n");
        System.out.println("Total a Pagar ---------------------------------------------------------------- $"
                + this.sueldosAPagar());
    }

    /**
     * Agrega una nueva cuenta bancaria a la cartera del banco.
     * @param p_cuenta El objeto CuentaBancaria a agregar.
     * @return `true` si la operación de agregado fue exitosa.
     */
    public boolean agregarCuentaBancaria(CuentaBancaria p_cuenta) {
        return this.getCuentasBancarias().add(p_cuenta);
    }

    /**
     * Remueve una cuenta bancaria existente de la cartera del banco.
     * @param p_cuenta El objeto CuentaBancaria a remover.
     * @return `true` si la operación de remoción fue exitosa.
     */
    public boolean quitarCuentaBancaria(CuentaBancaria p_cuenta) {
        return this.getCuentasBancarias().remove(p_cuenta);
    }

    /**
     * Imprime en consola un reporte de las cuentas bancarias cuyo saldo es menor o igual a cero.
     * Incluye también un listado de todos los titulares de cuentas del banco.
     */
    public void listarCuentasConSaldoCero() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Cuentas sin saldo");
        System.out.println("--- Cuenta --- \t --- Apellido y Nombre ----------");
        for (CuentaBancaria cuenta : this.getCuentasBancarias()) {
            if (cuenta.getSaldo() <= 0) {
                System.out.println(cuenta.getNroCuenta() + "\t " + cuenta.getTitular().apeYNom());
            }
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.print("Listado de clientes: ");
        for (Persona persona : this.listaDeTitulares()) {
            System.out.print(persona.apeYNom() + "; ");
        }
        System.out.println("-------------------------------------------------------------------------");

    }

    /**
     * Construye y devuelve una colección de titulares de cuentas bancarias sin duplicados.
     * @return Un objeto HashSet que contiene los objetos Persona únicos de los titulares.
     */
    public HashSet<Persona> listaDeTitulares() {
        HashSet<Persona> titulares = new HashSet<Persona>();
        for (CuentaBancaria cuenta : this.getCuentasBancarias()) {
            titulares.add(cuenta.getTitular());
        }
        return titulares;
    }

    /**
     * Cuantifica el número de cuentas bancarias con saldo positivo.
     * @return El total de cuentas con saldo mayor a cero.
     */
    public int cuentasSaldoActivo() {
        int total = 0;
        for (CuentaBancaria cuenta : this.getCuentasBancarias()) {
            if (cuenta.getSaldo() > 0) {
                total++;
            }
        }
        return total;
    }

    /**
     * Cuantifica el número de cuentas bancarias con saldo menor o igual a cero.
     * @return El total de cuentas con saldo cero o negativo.
     */
    public int cuentasSaldoCero() {
        int total = 0;
        for (CuentaBancaria cuenta : this.getCuentasBancarias()) {
            if (cuenta.getSaldo() <= 0) {
                total++;
            }
        }
        return total;
    }

    /**
     * Imprime en consola un resumen estadístico del estado de las cuentas del banco.
     * Incluye totales de cuentas, activas, y con saldo cero, además de un listado detallado de estas últimas.
     */
    public void mostrarResumen() {
        System.out.println("Nombre: " + this.getNombre() + "    Sucursal: " + this.getNroSucursal());
        System.out.println(this.getLocalidad().mostrar());
        System.out.println("***********************************************************************");
        System.out.println("RESUMEN DE CUENTAS BANCARIAS");
        System.out.println("***********************************************************************");
        System.out.println("Número total de Cuentas Bancarias: " + this.getCuentasBancarias().size());
        System.out.println("Cuentas Activas: " + this.cuentasSaldoActivo());
        System.out.println("Cuentas Saldo Cero: " + this.cuentasSaldoCero());
        this.listarCuentasConSaldoCero();
    }
}

