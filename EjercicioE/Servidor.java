import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Servidor {

    public static void main(String[] args) {
        try {
            MateriaServiceImpl objRemoto = new MateriaServiceImpl();

            try {
                LocateRegistry.createRegistry(Config.PORT);
            } catch (RemoteException e) {
                // La registry ya existe
            }

            Naming.rebind("//localhost:" + Config.PORT + "/materiaService", objRemoto);
            System.out.println("Servidor iniciado en el puerto " + Config.PORT + "...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
