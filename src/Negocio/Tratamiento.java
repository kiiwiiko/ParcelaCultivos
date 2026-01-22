package Negocio;

import Estructura.ArbolDesicion;

import java.time.LocalDate;

public class Tratamiento {
    private String tratamiento;

    public Tratamiento() {
        this.tratamiento = ArbolDesicion.obtenerTratamiento();
    }

    public String mostrarTratamiento() {
        return tratamiento;
    }
}