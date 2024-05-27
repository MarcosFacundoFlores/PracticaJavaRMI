import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MateriaService extends Remote {
    List<String> obtenerMateriasPorDia(String dia) throws RemoteException, DiaNoValidoException;
}
