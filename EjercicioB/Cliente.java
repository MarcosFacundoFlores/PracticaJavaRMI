import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            // Lookup the remote object from the registry
            Calc calc = (Calc) Naming.lookup("//localhost/calc");

            try (
                    Scanner scanner = new Scanner(System.in)) {

                System.out.println("Ingrese operación:");
                System.out.println("1: suma");
                System.out.println("2: resta");
                System.out.println("3: multiplicacion");
                System.out.println("4: división");
                int operation = scanner.nextInt();
                System.out.print("Ingrese primer operando: ");
                int operando1 = scanner.nextInt();
                System.out.print("Ingrese segundo operando: ");
                int operando2 = scanner.nextInt();

                int result = calc.calculate(operation, operando1, operando2);
                if (result == Integer.MIN_VALUE) {
                    System.err.println("Error! no se puede dividir entre 0");
                } else {
                    System.out.println("Resultado: " + result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
