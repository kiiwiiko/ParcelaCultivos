package Estructura;

import Negocio.Parcela;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaParcela {
    private List<Parcela> parcelas;

    public ListaParcela() {
        parcelas = new ArrayList<Parcela>();
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public Parcela adicionarParcela(String nombreParcela, String ubicacionParcela, double x, double y) {
        Parcela p = new Parcela(nombreParcela, ubicacionParcela, x, y);
        parcelas.add(p);
        Collections.sort(parcelas);
        return p;
    }

    public Parcela buscarParcela(int idParcela) {
        Parcela resultado = null;
        int left = 0;
        int right = parcelas.size() - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(parcelas.get(mid).getIdParcela() == idParcela) {
                resultado = parcelas.get(mid);
            }
            if(parcelas.get(mid).getIdParcela() < idParcela) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return resultado;
    }

    public void eliminarParcela(Parcela p) {
        parcelas.remove(p);

    }

    public void modificarParcela(Parcela p, String nombre, double x, double y) {
        p.setNombreParcela(nombre);
        p.setDimensionesParcelaX(x);
        p.setDimensionesParcelaY(y);
    }
}
