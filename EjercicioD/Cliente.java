import java.rmi.Naming;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            Estacion estacion = (Estacion) Naming.lookup("//localhost:" + Config.PORT + "/estacion");

            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Ingrese una fecha (dd/MM/yyyy): ");
                String fechaStr = scanner.nextLine();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate fecha = null;

                try {
                    fecha = LocalDate.parse(fechaStr, formatter);
                    String estacionCalculada = estacion.calculateSeason(fecha);
                    System.out.println(estacionCalculada);
                } catch (DateTimeParseException e) {
                    System.err.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
