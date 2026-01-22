package Negocio;

import java.time.LocalDate;

public class Tratamiento implements Comparable<Tratamiento>{
    private static int numeroTratamiento;
    private int IdTratamiento;
    private String Producto;
    private Double DosisAplicada;
    private LocalDate FechaAplicacion;
    private Double Costo;
    private String Observaciones;

    public Tratamiento(String Producto, Double DosisAplicada, LocalDate FechaAplicacion, Double Costo, String Observaciones){
        this.IdTratamiento = ++numeroTratamiento;
        this.Producto = Producto;
        this.DosisAplicada = DosisAplicada;
        this.FechaAplicacion = FechaAplicacion;
        this.Costo = Costo;
        this.Observaciones = Observaciones;
    }

    public int getIdTratamiento() {
        return IdTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        IdTratamiento = idTratamiento;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String producto) {
        Producto = producto;
    }

    public Double getDosisAplicada() {
        return DosisAplicada;
    }

    public void setDosisAplicada(Double dosisAplicada) {
        DosisAplicada = dosisAplicada;
    }

    public LocalDate getFechaAplicacion(){
        return FechaAplicacion;
    }

    public void setFechaAplicacion(LocalDate FechaAplicacion) {
        this.FechaAplicacion = FechaAplicacion;
    }

    public Double getCosto() {
        return Costo;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    public void setCosto(Double costo) {
        Costo = costo;
    }

    public Double CalcularCosto(){                           //Corregir
        return ++Costo;
    }

    public void ActualizarDosis(Double DosisAplicada){      //Revisar
        this.DosisAplicada = DosisAplicada;
    }

    @Override
    public String toString() {
        return "ID" + IdTratamiento +   " | " +
                "Producto" + Producto + " | " +
                "Dosis aplicada" +DosisAplicada + " | " +
                "Fecha de aplicacion: " + FechaAplicacion +
                " Observaciones " + Observaciones ;
    }


    public int compareTo(Tratamiento t){
        return Integer.compare(this.IdTratamiento , t.IdTratamiento);
    }
}