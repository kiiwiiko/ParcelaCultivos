package Estructura;

import javax.swing.*;

public class ArbolDesicion {

    private static String hacerPreguntasGenerales() {
        String resultadoGeneral = "";

        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿El cultivo tiene manchas en las hojas?",
                "Pregunta General",
                JOptionPane.YES_NO_OPTION
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Es debido a plagas?",
                    "Pregunta General",
                    JOptionPane.YES_NO_OPTION
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                resultadoGeneral = "Plagas en el cultivo.";
            } else {
                resultadoGeneral = "Problema de nutrientes o enfermedades.";
            }
        } else {
            // Si no tiene manchas, preguntar si tiene crecimiento anormal
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿El cultivo tiene crecimiento anormal?",
                    "Pregunta General",
                    JOptionPane.YES_NO_OPTION
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                resultadoGeneral = "Falta de agua o nutrientes.";
            } else {
                resultadoGeneral = "Cultivo en condiciones normales.";
            }
        }

        // Preguntar sobre la exposición al sol
        respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿El cultivo está expuesto a demasiada luz solar?",
                "Pregunta General",
                JOptionPane.YES_NO_OPTION
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            resultadoGeneral = "Posible estrés térmico debido a exceso de sol.";
        }

        // Preguntar sobre el drenaje del suelo
        respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿El suelo tiene buen drenaje?",
                "Pregunta General",
                JOptionPane.YES_NO_OPTION
        );
        if (respuesta == JOptionPane.NO_OPTION) {
            resultadoGeneral = "Problemas de drenaje del suelo.";
        }

        // Preguntar sobre la presencia de raíces podridas
        respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Las raíces del cultivo están podridas?",
                "Pregunta General",
                JOptionPane.YES_NO_OPTION
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            resultadoGeneral = "Raíces podridas, probablemente por exceso de riego.";
        }

        // Preguntar sobre la fertilización
        respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Se están utilizando fertilizantes adecuados?",
                "Pregunta General",
                JOptionPane.YES_NO_OPTION
        );
        if (respuesta == JOptionPane.NO_OPTION) {
            resultadoGeneral = "Falta de fertilización adecuada.";
        }

        return resultadoGeneral;
    }

    // Diagnóstico de Cacao (más preguntas)
    private static String diagnosticarCacao() {
        String resultado = "";

        // Preguntar sobre las manchas en las flores o vainas
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿El cultivo tiene manchas en las flores o vainas?",
                "Diagnóstico de Cacao",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            resultado = "Moniliasis.";
        } else {
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Las vainas están deformadas?",
                    "Diagnóstico de Cacao",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                resultado = "Escoba de Bruja.";
            } else {
                respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "¿Las hojas están afectadas por algún hongo?",
                        "Diagnóstico de Cacao",
                        JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    resultado = "Problema fúngico: Tratar con fungicidas adecuados.";
                } else {
                    resultado = "Cultivo en buenas condiciones.";
                }
            }
        }
        return resultado;
    }

    // Diagnóstico de Yuca (más preguntas)
    private static String diagnosticarYuca() {
        String resultado = "";

        // Preguntar sobre el follaje de la yuca
        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿El follaje está amarillo o marchito?",
                "Diagnóstico de Yuca",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            resultado = "Deficiencia de nutrientes.";
        } else {
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Las raíces están podridas?",
                    "Diagnóstico de Yuca",
                    JOptionPane.YES_NO_OPTION
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                resultado = "Pudrición por exceso de riego.";
            } else {
                respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "¿El cultivo tiene plagas como el picudo?",
                        "Diagnóstico de Yuca",
                        JOptionPane.YES_NO_OPTION
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    resultado = "Plagas en el cultivo. Tratamiento: Uso de insecticidas.";
                } else {
                    resultado = "Cultivo saludable.";
                }
            }
        }
        return resultado;
    }

    // Diagnóstico de Plátano (más preguntas)
    private static String diagnosticarPlatano() {
        String resultado = "";

        // Preguntar sobre las manchas en las hojas del plátano
        int respuesta = JOptionPane.showConfirmDialog(
                null, "¿Las hojas tienen manchas amarillas?",
                "Diagnóstico de Plátano",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            resultado = "Mal de Panamá.";
        } else {
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Las raíces están afectadas?",
                    "Diagnóstico de Plátano",
                    JOptionPane.YES_NO_OPTION
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                resultado = "Pudrición de raíces.";
            } else {
                respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "¿El cultivo tiene signos de Sigatoka (enfermedad en las hojas)?",
                        "Diagnóstico de Plátano",
                        JOptionPane.YES_NO_OPTION
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    resultado = "Sigatoka. Tratamiento: Fungicidas y manejo adecuado de la humedad.";
                } else {
                    resultado = "Cultivo saludable.";
                }
            }

        }
        return resultado;
    }


    public static String obtenerDiagnostico(String tipo) {
        String resultadoDiagnostico = "";

        String diagnosticoGeneral = hacerPreguntasGenerales();  // Obtiene el diagnóstico general

        if(tipo.equalsIgnoreCase("cacao")) {
            return diagnosticoGeneral + ", " + diagnosticarCacao();  // Combina diagnóstico general y específico
        }

        if(tipo.equalsIgnoreCase("yuca")) {
            return diagnosticoGeneral + ", " + diagnosticarYuca();  // Combina diagnóstico general y específico
        }

        if(tipo.equalsIgnoreCase("platano")) {
            return diagnosticoGeneral + ", " + diagnosticarPlatano();  // Combina diagnóstico general y específico
        }

        return diagnosticoGeneral;  // En caso de que no sea ningún cultivo conocido
    }
}
