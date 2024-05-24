import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            // Lookup the remote object from the registry
            ParImpar objRemoto = (ParImpar) Naming.lookup("//localhost/parImpar");

            try (// Ask the user for a number
            Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter a number: ");
                int number = scanner.nextInt();

                // Check if the number is even or odd using the remote method
                boolean isEven = objRemoto.isEven(number);
                System.out.println(number + " is " + (isEven ? "even" : "odd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
