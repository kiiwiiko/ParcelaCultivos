package Negocio;

import Estructura.ESTADO;
import java.time.LocalDate;

public class Cultivo implements Comparable<Cultivo> {
    private static int numeroCultivo;
    private int IDcultivo;
    private String tipoCultivo;
    private int cantidadSiembra;
    private double[] areaSiembra = new double[2];
    private LocalDate fechaSiembra;
    private LocalDate fechaCultivo;
    private ESTADO estado;
    private double areaCultivo;

    public Cultivo(String tipoCultivo, int cantidadSiembra, double x, double y, ESTADO estado) {
        this.IDcultivo = ++numeroCultivo;
        this.tipoCultivo = tipoCultivo;
        this.cantidadSiembra = cantidadSiembra;
        this.areaSiembra[0] = x;
        this.areaSiembra[1] = y;
        this.areaCultivo = x * y;
        this.estado = estado;

        if (estado == ESTADO.SIEMBRA) {
            this.fechaSiembra = LocalDate.now();
        }
    }


    public void setAreaSiembra(double[] areaSiembra) {
        this.areaSiembra = areaSiembra;
    }

    public void setAreaCultivo(double areaCultivo) {
        this.areaCultivo = areaCultivo;
    }

    public void setIDcultivo(int IDcultivo) {
        this.IDcultivo = IDcultivo;
    }

    public ESTADO getEstado() {
        return estado;
    }

    public void setEstado(ESTADO estado) {
        this.estado = estado;
    }

    public double getAreaCultivo() {
        return areaCultivo;
    }

    public int getIDcultivo() {
        return IDcultivo;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public int getCantidadSiembra() {
        return cantidadSiembra;
    }

    public void setCantidadSiembra(int cantidadSiembra) {
        this.cantidadSiembra = cantidadSiembra;
    }

    public double getAreaSiembraX() {
        return areaSiembra[0];
    }

    public double getAreaSiembraY() {
        return areaSiembra[1];
    }

    public void setAreaSiembraX(double x) {
        this.areaSiembra[0] = x;
        this.areaCultivo = this.areaSiembra[0] * this.areaSiembra[1];
    }

    public void setAreaSiembraY(double y) {
        this.areaSiembra[1] = y;
        this.areaCultivo = this.areaSiembra[0] * this.areaSiembra[1];
    }

    public void aplicarEstado(ESTADO nuevoEstado) {
        this.estado = nuevoEstado;

        if (nuevoEstado == ESTADO.SIEMBRA && this.fechaSiembra == null) {
            this.fechaSiembra = LocalDate.now();
        }

        if (nuevoEstado == ESTADO.COSECHA && this.fechaCultivo == null) {
            this.fechaCultivo = LocalDate.now();
        }
    }

    public LocalDate getFechaSiembra() {
        return fechaSiembra;
    }

    public void setFechaSiembra(LocalDate fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public LocalDate getFechaCultivo() {
        return fechaCultivo;
    }

    public void setFechaCultivo(LocalDate fechaCultivo) {
        this.fechaCultivo = fechaCultivo;
    }

    @Override
    public String toString() {
        return "ID " + IDcultivo + " | " +
                "Tipo: " + tipoCultivo + " | " +
                "Cant: " + cantidadSiembra + " | " +
                "Dim: " + areaSiembra[0] + " x " + areaSiembra[1] + " | " +
                "Área: " + areaCultivo + " m² | " +
                "Estado: " + estado;
    }

    @Override
    public int compareTo(Cultivo c) {
        return Integer.compare(this.IDcultivo, c.IDcultivo);
    }
}
