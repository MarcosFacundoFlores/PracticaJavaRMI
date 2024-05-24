import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Servidor {

    public static void main(String[] args) {
        try {
            // Create and export a remote object
            ParImparImpl objRemoto = new ParImparImpl();

            // Create the registry if it does not already exist
            try {
                LocateRegistry.createRegistry(1099);
            } catch (RemoteException e) {
                // Registry already exists
            }

            // Bind the remote object's stub in the registry
            Naming.rebind("//localhost/parImpar", objRemoto);
            System.out.println("Servidor iniciado...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
