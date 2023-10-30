import java.io.*;
import java.util.Scanner;

/**
 * Clase que representa un vehículo.
 */
class Vehiculo {
    private String patente;
    private int numRuedas;
    private String tipoVehiculo;
    private int numAsientos;
    private String estado;

    /**
     * Constructor para crear un objeto Vehiculo.
     *
     * @param patente      La patente del vehículo.
     * @param numRuedas    El número de ruedas del vehículo.
     * @param tipoVehiculo El tipo de vehículo (por ejemplo, automóvil, motocicleta, etc.).
     * @param numAsientos  El número de asientos en el vehículo.
     * @param estado       El estado del vehículo (por ejemplo, disponible, en reparación, etc.).
     */
    public Vehiculo(String patente, int numRuedas, String tipoVehiculo, int numAsientos, String estado) {
        this.patente = patente;
        this.numRuedas = numRuedas;
        this.tipoVehiculo = tipoVehiculo;
        this.numAsientos = numAsientos;
        this.estado = estado;
    }

    // Métodos para obtener y establecer atributos (getters y setters).

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

/**
 * Clase que gestiona el registro de vehículos en un archivo de texto.
 */
class RegistroVehiculos {
    private static final String ARCHIVO_VEHICULOS = "src/vehiculos.txt";

    /**
     * Comprueba si un vehículo con una patente específica ya existe en el registro.
     *
     * @param patente La patente del vehículo a verificar.
     * @return true si el vehículo ya existe, false si no existe.
     */
    public boolean vehiculoExiste(String patente) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_VEHICULOS))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].trim().equals(patente)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }

    /**
     * Registra un vehículo en el archivo de vehículos.
     *
     * @param vehiculo El objeto Vehiculo a registrar.
     */
    public void registrarVehiculo(Vehiculo vehiculo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_VEHICULOS, true))) {
            String vehiculoInfo = vehiculo.getPatente() + "," + vehiculo.getNumRuedas() + "," +
                    vehiculo.getTipoVehiculo() + "," + vehiculo.getNumAsientos() + "," + vehiculo.getEstado();
            writer.write(vehiculoInfo);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
