import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcImpl extends UnicastRemoteObject implements Calc {

    protected CalcImpl() throws RemoteException {
        super();
    }

    @Override
    public int calculate(int operation, int operando1, int operando2) throws RemoteException {
        switch (operation) {
            case 1:
                return (operando1 + operando2);

            case 2:
                return (operando1 - operando2);

            case 3:
                return (operando1 * operando2);

            case 4:
                if (operando2 == 0) {
                    return Integer.MIN_VALUE;
                } else {
                    return (operando1 / operando2);
                }
            default:
                throw new IllegalArgumentException("Argumentos Inválidos");

        }
    }
}
