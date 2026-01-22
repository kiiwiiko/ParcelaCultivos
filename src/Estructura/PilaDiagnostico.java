package Estructura;

import Negocio.Diagnostico;

import javax.swing.*;
import java.util.Stack;

public class PilaDiagnostico {

    private Stack<Diagnostico> diagnosticos;

    // Constructor que inicializa la pila de diagnósticos
    public PilaDiagnostico() {
        diagnosticos = new Stack<Diagnostico>();
    }


    public Stack<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }


    public Diagnostico adicionarDiagnostico(String tipo, ESTADO estado) {
        if(estado.equals(ESTADO.SIEMBRA)) {
            Diagnostico d = new Diagnostico(tipo);
            diagnosticos.push(d);
            JOptionPane.showMessageDialog(
                    null,
                    "El diagnostico se registro correctamente"
            );
            return d;

        }
        if(estado.equals(ESTADO.PLANIFICACION)) {
            JOptionPane.showMessageDialog(
                    null,
                    "No se puede registrar el diagnostico\nporque el cultivo esta en planificacion"
            );
        }
        if(estado.equals(ESTADO.COSECHA)) {
            JOptionPane.showMessageDialog(
                    null,
                    "No se puede registrar el diagnostico\nporque el cultivo ya se cosecho"
            );

        }
        return null;
    }


    public String mostrarDiagnosticos() {
        StringBuilder resultado = new StringBuilder();

        for (Diagnostico d : diagnosticos) {
            resultado.append(d).append("\n");
        }
        return resultado.toString();
    }


    public String imprimirUltimoDiagnostico() {
        if (!diagnosticos.isEmpty()) {
            return "================================================================================\n" +
                    "                          Ultimo Diagnostico\n" +
                    "================================================================================\n" +
                    diagnosticos.peek().toString();
        }
        return null;
    }
}
