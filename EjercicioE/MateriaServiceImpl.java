import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MateriaServiceImpl extends UnicastRemoteObject implements MateriaService {

    private Map<String, List<String>> materias;

    protected MateriaServiceImpl() throws RemoteException {
        super();
        materias = new HashMap<>();
        materias.put("lunes", List.of("Matemáticas", "Física"));
        materias.put("martes", List.of("Química"));
        materias.put("miércoles", List.of("Matemáticas", "Física"));
        materias.put("jueves", List.of("Química"));
        materias.put("viernes", List.of("Biología"));
    }

    @Override
    public List<String> obtenerMateriasPorDia(String dia) throws RemoteException, DiaNoValidoException {
        if (materias.containsKey(dia)) {
            return materias.get(dia);
        } else {
            throw new DiaNoValidoException("Día no válido: " + dia + ". Por favor, elija un día entre lunes y viernes.");
        }
    }
}
