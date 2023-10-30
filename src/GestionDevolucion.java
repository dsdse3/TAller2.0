import java.util.List;
import java.util.Scanner;

/**
 * Esta clase proporciona métodos para gestionar la devolución de arriendos de vehículos.
 */
public class GestionDevolucion {

    /**
     * Este método permite gestionar la devolución de arriendos de vehículos.
     *
     * @param arriendosActivos La lista de arriendos activos que se deben gestionar.
     */
    public static void gestionarDevolucion(List<Arriendo> arriendosActivos) {
        Scanner scanner = new Scanner(System.in);

        // Verifica si no hay arriendos activos.
        if (arriendosActivos.isEmpty()) {
            System.out.println("No hay arriendos activos para devolver.");
        } else {
            System.out.println("Transacciones de arriendo activas:");
            // Itera a través de la lista de arriendos activos e imprime información sobre cada arriendo.
            for (int i = 0; i < arriendosActivos.size(); i++) {
                Arriendo arriendo = arriendosActivos.get(i);
                System.out.println("ID: " + i + ", Arriendo.Cliente: " + arriendo.getCliente().getNombre() + ", Patente: " + arriendo.getVehiculo().getPatente() + ", Duración: " + arriendo.getDiasArriendo() + " días");
            }

            System.out.print("Ingrese el RUT del cliente que desea devolver: ");
            String rutCliente = scanner.nextLine();

            // Realiza validación y proceso de devolución.
            boolean devolucionExitosa = false;
            for (int i = 0; i < arriendosActivos.size(); i++) {
                Arriendo arriendo = arriendosActivos.get(i);
                if (arriendo.getCliente().getRut().equals(rutCliente)) {
                    // Realiza las acciones necesarias para completar la devolución
                    // Puedes calcular el costo total, actualizar el estado del vehículo, etc.
                    // Elimina el arriendo de la lista de arriendos activos
                    arriendosActivos.remove(i);
                    devolucionExitosa = true;
                    System.out.println("Devolución exitosa.");
                    break;
                }
            }

            // Si la devolución no fue exitosa, muestra un mensaje apropiado.
            if (!devolucionExitosa) {
                System.out.println("No se encontraron arriendos activos para el cliente con RUT: " + rutCliente);
            }
        }
    }
}
