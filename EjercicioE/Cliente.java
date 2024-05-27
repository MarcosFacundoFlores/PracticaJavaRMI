import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            MateriaService materiaService = (MateriaService) Naming.lookup("//localhost:" + Config.PORT + "/materiaService");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese un día de la semana (lunes a viernes): ");
            String dia = scanner.nextLine().toLowerCase();

            try {
                List<String> materias = materiaService.obtenerMateriasPorDia(dia);
                System.out.println("Materias para " + dia + ": " + String.join(", ", materias));
            } catch (DiaNoValidoException e) {
                System.err.println(e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
