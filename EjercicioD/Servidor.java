import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Servidor {

    public static void main(String[] args) {
        try {
            // Create and export a remote object
            EstacionImpl objRemoto = new EstacionImpl();
            int port = Config.PORT;
            // Create the registry if it does not already exist
            try {
                
                LocateRegistry.createRegistry(port);
                
            } catch (RemoteException e) {
                // Registry already exists
                LocateRegistry.getRegistry(port);
            }

            // Bind the remote object's stub in the registry
            Naming.rebind("//localhost:" + port + "/estacion", objRemoto);
            System.out.println("Servidor iniciado en el puerto " + port + "...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
