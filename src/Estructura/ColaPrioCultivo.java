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

    public List<Cultivo> buscarPorTipo(String tipo) {
        List<Cultivo> resultados = new ArrayList<>();

        for (Cultivo c : colaPrio) {
            if (c.getTipoCultivo().equalsIgnoreCase(tipo)) {
                resultados.add(c);
            }
        }

        return resultados;
    }


    public boolean eliminar(int idCultivo) {
        Cultivo encontrado = buscar(idCultivo);
        if (encontrado == null) return false;
        return colaPrio.remove(encontrado);
    }

    public boolean modificar(int iDCultivo, String nuevoTipoCultivo, Integer nuevaCantidadSiembra, LocalDate nuevaFecha, ESTADO nuevoEstado) {
        Cultivo c = buscar(iDCultivo);
        if (c == null) return false;

        colaPrio.remove(c);

        if (nuevoTipoCultivo != null) c.setTipoCultivo(nuevoTipoCultivo);
        if (nuevaCantidadSiembra != null) c.setCantidadSiembra(nuevaCantidadSiembra);
        if (nuevaFecha != null) c.setFechaCultivo(nuevaFecha);
        if (nuevoEstado != null) c.setEstado(nuevoEstado);

        colaPrio.offer(c);
        return true;
    }
}