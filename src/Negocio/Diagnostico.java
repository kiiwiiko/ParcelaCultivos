package Negocio;

import Estructura.ArbolDesicion;

import java.time.LocalDate;

public class Diagnostico extends ArbolDesicion {
    private String preguntas;
    private static int numeroDiagnostico;
    private int idDiagnostico;

    public Diagnostico(String tipo) {
        this.preguntas = obtenerDiagnostico(tipo);
        this.idDiagnostico = ++numeroDiagnostico;
    }

    @Override
    public String toString() {
        return "================================================================================\n" +
                "                            DIAGNOSTICO " +
                idDiagnostico + "\n" +
                "================================================================================\n" +
                preguntas + "\n";
    }
}