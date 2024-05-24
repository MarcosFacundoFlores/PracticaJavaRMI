import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ParImparImpl extends UnicastRemoteObject implements ParImpar {

    protected ParImparImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean isEven(int number) throws RemoteException {
        return number % 2 == 0;
    }
}
