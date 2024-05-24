import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ParImpar extends Remote {
    boolean isEven(int number) throws RemoteException;
}
