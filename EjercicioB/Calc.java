import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calc extends Remote {

    int calculate( int operation,int operando1, int operando2) throws RemoteException;

}
