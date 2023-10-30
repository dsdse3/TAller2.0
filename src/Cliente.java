import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un cliente.
 */
class Cliente {
    private String rut;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String tipoLicencia;
    private List<Arriendo> arriendos = new ArrayList<>();

    /**
     * Constructor para crear un objeto Cliente.
     *
     * @param rut            El RUT del cliente.
     * @param nombre         El nombre del cliente.
     * @param apellido       El apellido del cliente.
     * @param fechaNacimiento La fecha de nacimiento del cliente.
     * @param tipoLicencia   El tipo de licencia del cliente.
     */
    public Cliente(String rut, String nombre, String apellido, String fechaNacimiento, String tipoLicencia) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoLicencia = tipoLicencia;
    }

    // Métodos para obtener y establecer atributos (getters y setters).

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    /**
     * Agrega un arriendo a la lista de arriendos del cliente.
     *
     * @param arriendo El arriendo a agregar.
     */
    public void agregarArriendo(Arriendo arriendo) {
        arriendos.add(arriendo);
    }

    /**
     * Obtiene la lista de arriendos del cliente.
     *
     * @return Un arreglo de objetos Arriendo que representa los arriendos del cliente.
     */
    public Arriendo[] getArriendos() {
        return arriendos.toArray(new Arriendo[0]);
    }
}

/**
 * Clase que gestiona el registro de clientes en un archivo de texto.
 */
class RegistroClientes {
    private static final String ARCHIVO_CLIENTES = "src/clientes.txt";

    /**
     * Comprueba si un cliente con un RUT específico ya existe en el registro.
     *
     * @param rut El RUT del cliente a verificar.
     * @return true si el cliente ya existe, false si no existe.
     */
    public boolean clienteExiste(String rut) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CLIENTES))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(rut + ",")) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }

    /**
     * Agrega un cliente al registro en el archivo de clientes.
     *
     * @param cliente El objeto Cliente a agregar.
     */
    public void agregarCliente(Cliente cliente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES, true))) {
            String clienteInfo = cliente.getRut() + ", " + cliente.getNombre() + ", " + cliente.getApellido() + ", " + cliente.getFechaNacimiento() + ", " + cliente.getTipoLicencia();
            writer.write(clienteInfo);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
