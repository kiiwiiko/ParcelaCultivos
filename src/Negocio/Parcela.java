package Negocio;

import Estructura.ColaPrioCultivo;

import java.util.List;

public class Parcela implements Comparable<Parcela> {
    private static int numeroDeParcela;
    private int idParcela;
    private String nombreParcela;
    private String ubicacionParcela;
    private double[] dimensionesParcela = new double[2];
    private double areaTotal;
    private ColaPrioCultivo cultivos;

    public Parcela(String nombreParcela, String ubicacionParcela, double x, double y) {
        this.idParcela = ++numeroDeParcela;
        this.nombreParcela = nombreParcela;
        this.ubicacionParcela = ubicacionParcela;
        this.dimensionesParcela[0] = x;
        this.dimensionesParcela[1] = y;
        this.areaTotal = x * y;
        this.cultivos = new ColaPrioCultivo();
    }

    public static int getNumeroDeParcela() {
        return numeroDeParcela;
    }

    public static void setNumeroDeParcela(int numeroDeParcela) {
        Parcela.numeroDeParcela = numeroDeParcela;
    }

    public void setIdParcela(int idParcela) {
        this.idParcela = idParcela;
    }

    public double[] getDimensionesParcela() {
        return dimensionesParcela;
    }

    public void setDimensionesParcela(double[] dimensionesParcela) {
        this.dimensionesParcela = dimensionesParcela;
    }

    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }

    public void setCultivos(ColaPrioCultivo cultivos) {
        this.cultivos = cultivos;
    }

    public ColaPrioCultivo getCultivos() {
        return cultivos;
    }

    public int getIdParcela() {
        return idParcela;
    }

    public String getNombreParcela() {
        return nombreParcela;
    }

    public void setNombreParcela(String nombreParcela) {
        this.nombreParcela = nombreParcela;
    }

    public double getDimensionesParcelaX() {
        return dimensionesParcela[0];
    }

    public double getDimensionesParcelaY() {
        return dimensionesParcela[1];
    }

    public void setDimensionesParcelaX(double x) {
        this.dimensionesParcela[0] = x;
        recalcularAreaTotal();
    }

    public void setDimensionesParcelaY(double y) {
        this.dimensionesParcela[1] = y;
        recalcularAreaTotal();
    }

    public String getUbicacionParcela() {
        return ubicacionParcela;
    }

    public void setUbicacionParcela(String ubicacionParcela) {
        this.ubicacionParcela = ubicacionParcela;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public double getAreaOcupada() {
        double suma = 0;
        List<Cultivo> lista = cultivos.listarOrdenado();
        for (Cultivo c : lista) {
            suma += c.getAreaCultivo();
        }
        return suma;
    }

    public double getAreaDisponible() {
        return areaTotal - getAreaOcupada();
    }

    public boolean tieneEspacioPara(double anchoCultivo, double largoCultivo) {
        double areaNueva = anchoCultivo * largoCultivo;
        return areaNueva > 0 && areaNueva <= getAreaDisponible();
    }

    private void recalcularAreaTotal() {
        this.areaTotal = this.dimensionesParcela[0] * this.dimensionesParcela[1];
    }

    @Override
    public String toString() {
        return "ID " + idParcela + " | " +
                nombreParcela + " | " +
                ubicacionParcela + " | " +
                "Dim: " + dimensionesParcela[0] + " x " + dimensionesParcela[1] + " | " +
                "Área total: " + areaTotal + " m² | " +
                "Ocupada: " + getAreaOcupada() + " m² | " +
                "Disponible: " + getAreaDisponible() + " m²";
    }

    @Override
    public int compareTo(Parcela p) {
        return Integer.compare(this.idParcela, p.idParcela);
    }
}
