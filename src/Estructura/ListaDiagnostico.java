package Estructura;

import Negocio.Diagnostico;

import java.util.LinkedList;
import java.util.List;

public class ListaDiagnostico {
    private final List<Diagnostico> lista;

    public ListaDiagnostico(){
        lista    = new LinkedList<Diagnostico>();
    }

    public Diagnostico agregarDiagnostico(String problema, String gravedad, String Descripcion){
        Diagnostico d = new Diagnostico(problema, gravedad, Descripcion);
        lista.add(d);
        return d;
    }

    public void eliminarDiagnostico(Diagnostico d){
        lista.remove(d);
    }

    public Diagnostico buscarDiagnostico(int idDiagnostico){
        Diagnostico resultado = null;
        int izq = 0;
        int der = lista.size() -1;

        while(izq <= der) {
            int mid = (izq + der) / 2;
            if(lista.get(mid).getIdDiagnostico() == idDiagnostico) {
                resultado = lista.get(mid);
            }
            if(lista.get(mid).getIdDiagnostico() < idDiagnostico) {
                izq = mid + 1;
            } else {
                der = mid - 1;
            }
        }
        return resultado;
    }

    public void  modificarDiagnostico(Diagnostico d, String problema, String gravedad, String Descripcion){
        d.setproblema(problema);
        d.setgravedad(gravedad);
        d.setDescripcion(Descripcion);
    }
}