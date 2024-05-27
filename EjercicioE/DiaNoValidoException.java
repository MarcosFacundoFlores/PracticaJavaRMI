import java.rmi.RemoteException;

public class DiaNoValidoException extends RemoteException {
    public DiaNoValidoException(String mensaje) {
        super(mensaje);
    }
}
