package Negocio;

import Estructura.ListaTratamiento;

import java.time.LocalDate;

public class Diagnostico {
    private static int numeroDiagnostico;
    private int IdDiagnostico;
    private String EstadoParcela;
    private String EstadoCultivo;
    private LocalDate fechaDiagnostico;
    private String problema;
    private String gravedad;
    private String Descripcion;

    private ListaTratamiento tratamiento;

    public Diagnostico (String problema ,String gravedad,String Descripcion){
        this.IdDiagnostico = ++numeroDiagnostico;
        this.problema = problema;
        this.gravedad = gravedad;
        this.Descripcion = Descripcion;
        this.tratamiento = new ListaTratamiento();
    }

    public int getIdDiagnostico(){
        return IdDiagnostico;
    }

    public void setIdDiagnostico(int IdDiagnostico){
        this.IdDiagnostico = IdDiagnostico;
    }

    public String getEstadoParcela(){
        return EstadoParcela;
    }

    public void setEstadoParcela(String EstadoParcela){
        this.EstadoParcela = EstadoParcela;
    }

    public String getEstadoCultivo(){
        return EstadoCultivo;
    }

    public void setEstadoCultivo(String EstadoCultivo){
        this.EstadoCultivo = EstadoCultivo;
    }

    public LocalDate getFechaDiagnostico(){
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(LocalDate fechaDiagnostico){
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getproblema(){
        return problema;
    }

    public void setproblema(String problema){
        this.problema = problema;
    }

    public String getgravedad(){
        return gravedad;
    }

    public void setgravedad(String gravedad){
        this.gravedad = gravedad;
    }

    public String getDescripcion(){
        return Descripcion;
    }

    public void setDescripcion(String Descripcion){
        this.Descripcion = Descripcion;
    }

    public void ActualizarEstado(String EstadoParcela, String EstadoCultivo){
        this.EstadoParcela = EstadoParcela;
        this.EstadoCultivo = EstadoCultivo;
    }

    public String generarReporte(){               //Revisar cuando se pueda
        if (this.fechaDiagnostico == null) {
            this.fechaDiagnostico = LocalDate.now();
        }

        return "=== REPORTE DE DIAGNÓSTICO ===\n" +
                "ID: " + IdDiagnostico + "\n" +
                "Fecha: " + fechaDiagnostico + "\n" +
                "Estado Parcela: " + EstadoParcela + "\n" +
                "Estado Cultivo: " + EstadoCultivo + "\n" +
                "Problema: " + problema + "\n" +
                "Gravedad: " + gravedad + "\n" +
                "Descripción: " + Descripcion + "\n" +
                "==============================";
    }

    @Override
    public String toString() {
        return "ID" + IdDiagnostico +   " | " +
                "Producto" + EstadoParcela + " | " +
                "Dosis aplicada" +EstadoCultivo + " | " +
                "Fecha de aplicacion: " + fechaDiagnostico +
                " Observaciones " + problema +
                " Observaciones " + gravedad +
                " Observaciones " + Descripcion;
    }

}