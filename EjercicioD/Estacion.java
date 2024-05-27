import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

public interface Estacion extends Remote {

    String calculateSeason(LocalDate fecha) throws RemoteException;

}
