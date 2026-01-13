package Estructura;

import Negocio.Tratamiento;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class ListaTratamiento {
    private final List<Tratamiento> listatratamiento;

    public ListaTratamiento(){
        listatratamiento = new ArrayList<Tratamiento>();
    }

    public Tratamiento agregarTratamiento(String Producto, Double DosisAplicada, LocalDate FechaAplicacion, Double Costo, String Observaciones){
        Tratamiento t = new Tratamiento(Producto, DosisAplicada, FechaAplicacion, Costo, Observaciones);
        listatratamiento.add(t);
        return t;
    }

    public void eliminarTratamiento(Tratamiento t){
        listatratamiento.remove(t);
    }

    public Tratamiento buscarTratamiento(int idTratamiento){
        Tratamiento resultado = null;
        int izq = 0;
        int der = listatratamiento.size() -1;

        while(izq <= der) {
            int mid = (izq + der) / 2;
            if(listatratamiento.get(mid).getIdTratamiento() == idTratamiento) {
                resultado = listatratamiento.get(mid);
            }
            if(listatratamiento.get(mid).getIdTratamiento() < idTratamiento) {
                izq = mid + 1;
            } else {
                der = mid - 1;
            }
        }
        return resultado;
    }

    public void modificarTratamiento(Tratamiento t, String Producto, Double DosisAplicada, LocalDate FechaAplicada, String Observaciones){
        t.setProducto(Producto);
        t.ActualizarDosis(DosisAplicada);
        t.setFechaAplicacion(FechaAplicada);
        t.setObservaciones(Observaciones);
    }
}
