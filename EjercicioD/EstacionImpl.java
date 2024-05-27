import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.Month;

public class EstacionImpl extends UnicastRemoteObject implements Estacion {

    protected EstacionImpl() throws RemoteException {
        super();
    }

    @Override
    public String calculateSeason(LocalDate fecha) throws RemoteException {
        
        Month mes=fecha.getMonth();

        switch (mes) {
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
                return "Verano";
            case MARCH:
            case APRIL:
            case MAY:
                return "Otoño";
            case JUNE:
            case JULY:
            case AUGUST:
                return "Invierno";
            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
                return "Primavera";
            default:
                return "Fecha no válida";
        }

    }


}
