package Estructura;

import javax.swing.*;

public class ArbolDesicion {
    private static String tratamientoGeneral, tratamiento;

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
                tratamientoGeneral = "Uso de insecticidas y control de plagas.";
            } else {
                resultadoGeneral = "Problema de nutrientes o enfermedades.";
                tratamientoGeneral = "Uso de fertilizantes adecuados y revisión de nutrientes.";
            }
        } else {
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿El cultivo tiene crecimiento anormal?",
                    "Pregunta General",
                    JOptionPane.YES_NO_OPTION
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                resultadoGeneral = "Falta de agua o nutrientes.";
                tratamientoGeneral = "Riego adecuado y suplementación de nutrientes.";
            } else {
                resultadoGeneral = "Cultivo en condiciones normales.";
                tratamientoGeneral = "El cultivo está en condiciones normales, no requiere intervención.";
            }
        }

        respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿El cultivo está expuesto a demasiada luz solar?",
                "Pregunta General",
                JOptionPane.YES_NO_OPTION
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            resultadoGeneral = "Posible estrés térmico debido a exceso de sol.";
            tratamientoGeneral = "Sombra o protección solar para reducir el estrés térmico.";
        }

        respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿El suelo tiene buen drenaje?",
                "Pregunta General",
                JOptionPane.YES_NO_OPTION
        );
        if (respuesta == JOptionPane.NO_OPTION) {
            resultadoGeneral = "Problemas de drenaje del suelo.";
            tratamientoGeneral = "Mejorar el drenaje del suelo.";
        }

        respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Las raíces del cultivo están podridas?",
                "Pregunta General",
                JOptionPane.YES_NO_OPTION
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            resultadoGeneral = "Raíces podridas, probablemente por exceso de riego.";
            tratamientoGeneral = "Reducir el riego y mejorar el drenaje del suelo.";
        }

        respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Se están utilizando fertilizantes adecuados?",
                "Pregunta General",
                JOptionPane.YES_NO_OPTION
        );
        if (respuesta == JOptionPane.NO_OPTION) {
            resultadoGeneral = "Falta de fertilización adecuada.";
            tratamientoGeneral = "Uso de fertilizantes adecuados.";
        }

        return resultadoGeneral;
    }

    private static String diagnosticarCacao() {
        String resultado = "";

        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿El cultivo tiene manchas en las flores o vainas?",
                "Diagnóstico de Cacao",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            resultado = "Moniliasis.";
            tratamiento = "Aplicación de fungicidas específicos.";
        } else {
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Las vainas están deformadas?",
                    "Diagnóstico de Cacao",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                resultado = "Escoba de Bruja.";
                tratamiento = "Control de la enfermedad con fungicidas.";
            } else {
                respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "¿Las hojas están afectadas por algún hongo?",
                        "Diagnóstico de Cacao",
                        JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    resultado = "Problema fúngico: Tratar con fungicidas adecuados.";
                    tratamiento = "Aplicación de fungicidas específicos.";
                } else {
                    resultado = "Cultivo en buenas condiciones.";
                    tratamiento = "El cultivo está saludable, no se requiere tratamiento.";
                }
            }
        }
        return resultado;
    }

    private static String diagnosticarYuca() {
        String resultado = "";

        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿El follaje está amarillo o marchito?",
                "Diagnóstico de Yuca",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            resultado = "Deficiencia de nutrientes.";
            tratamiento = "Suplementación de nutrientes y fertilización adecuada.";
        } else {
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Las raíces están podridas?",
                    "Diagnóstico de Yuca",
                    JOptionPane.YES_NO_OPTION
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                resultado = "Pudrición por exceso de riego.";
                tratamiento = "Reducir el riego y mejorar el drenaje del suelo.";
            } else {
                respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "¿El cultivo tiene plagas como el picudo?",
                        "Diagnóstico de Yuca",
                        JOptionPane.YES_NO_OPTION
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    resultado = "Plagas en el cultivo. Tratamiento: Uso de insecticidas.";
                    tratamiento = "Uso de insecticidas específicos para controlar plagas.";
                } else {
                    resultado = "Cultivo saludable.";
                    tratamiento = "El cultivo está saludable, no se requiere tratamiento.";
                }
            }
        }
        return resultado;
    }

    private static String diagnosticarPlatano() {
        String resultado = "";

        int respuesta = JOptionPane.showConfirmDialog(
                null, "¿Las hojas tienen manchas amarillas?",
                "Diagnóstico de Plátano",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            resultado = "Mal de Panamá.";
            tratamiento = "Tratamiento: Uso de fungicidas específicos para Mal de Panamá.";
        } else {
            respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Las raíces están afectadas?",
                    "Diagnóstico de Plátano",
                    JOptionPane.YES_NO_OPTION
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                resultado = "Pudrición de raíces.";
                tratamiento = "Tratamiento: Mejorar el drenaje y reducir el riego.";
            } else {
                respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "¿El cultivo tiene signos de Sigatoka (enfermedad en las hojas)?",
                        "Diagnóstico de Plátano",
                        JOptionPane.YES_NO_OPTION
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    resultado = "Sigatoka. Tratamiento: Fungicidas y manejo adecuado de la humedad.";
                    tratamiento = "Tratamiento: Aplicación de fungicidas y control de humedad.";
                } else {
                    resultado = "Cultivo saludable.";
                    tratamiento = "El cultivo está saludable, no se requiere tratamiento.";
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

    public static String obtenerTratamiento() {
        return "El cultivo debe cumplir con el siguiente tratamiento: " +
                tratamientoGeneral +
                ",\n " +
                tratamiento;
    }
}
