package Estructura;

import Negocio.Cultivo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ColaPrioCultivo {

    private final PriorityQueue<Cultivo> colaPrio;

    public ColaPrioCultivo() {
        this.colaPrio = new PriorityQueue<>();
    }

    public PriorityQueue<Cultivo> getColaPrio() {
        return colaPrio;
    }


    public void encolar(String tipoCultivo, int cantidadSiembra, double x, double y) {
        colaPrio.offer(new Cultivo(tipoCultivo, cantidadSiembra, x, y, ESTADO.PLANIFICACION)); //llaman al enum
    }

    public Cultivo desencolar() throws Exception {
        if (colaPrio.isEmpty()) throw new Exception("No hay elementos en la cola");
        return colaPrio.poll();
    }

    public List<Cultivo> listarOrdenado() {
        PriorityQueue<Cultivo> copia = new PriorityQueue<>(colaPrio);
        List<Cultivo> salida = new ArrayList<>();
        while (!copia.isEmpty()) salida.add(copia.poll());
        return salida;
    }

    public Cultivo buscar(int idCultivo) {
        for (Cultivo c : colaPrio) {
            if (c.getIDcultivo() == idCultivo) return c;
        }
        return null;
    }


    public boolean eliminar(int idCultivo) {
        Cultivo encontrado = buscar(idCultivo);
        if (encontrado == null) return false;
        return colaPrio.remove(encontrado);
    }

    public boolean modificar(int iDCultivo, int nuevaCantidadSiembra, int x, int y) {
        Cultivo c = buscar(iDCultivo);
        if (c == null) return false;

        colaPrio.remove(c);

        c.setCantidadSiembra(nuevaCantidadSiembra);
        c.setAreaSiembraX(x);
        c.setAreaSiembraY(y);

        colaPrio.offer(c);
        return true;
    }

    private boolean esTransicionValida(ESTADO actual, ESTADO nuevo) {
        if (actual == ESTADO.PLANIFICACION) {
            return nuevo == ESTADO.SIEMBRA;   // desde planificacion SOLO se puede sembrar
        }
        if (actual == ESTADO.SIEMBRA) {
            return nuevo == ESTADO.COSECHA;  // desde siembra SOLO se puede cosechar
        }
        if (actual == ESTADO.COSECHA) {
            return false;                    // desde cosecha ya no se mueve (según lo que pides)
        }
        return false;
    }


    public boolean cambiarEstado(int idCultivo, ESTADO nuevoEstado) {
        Cultivo c = buscar(idCultivo);
        if (c == null) return false;

        ESTADO actual = c.getEstado();

        if (!esTransicionValida(actual, nuevoEstado)) {
            return false;
        }

        colaPrio.remove(c);

        c.setEstado(nuevoEstado);

        // Guardar fecha SOLO cuando entra a SIEMBRA (y si no estaba ya)
        if (nuevoEstado == ESTADO.SIEMBRA && c.getFechaSiembra() == null) {
            c.setFechaSiembra(LocalDate.now());
        }

        colaPrio.offer(c);
        return true;
    }

}