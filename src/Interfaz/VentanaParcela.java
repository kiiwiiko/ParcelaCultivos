package Interfaz;


import Estructura.ColaPrioCultivo;
import Estructura.ESTADO;
import Estructura.ListaParcela;
import Negocio.Cultivo;
import Negocio.Parcela;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaParcela {
    private JPanel Ventana;
    private JTabbedPane parcelaPane;
    private JSpinner xParcelaSpin;
    private JSpinner yParcelaSpin;
    private JButton agregarParcelaButton;
    private JTextField nombreParcelaField;
    private JComboBox ubicacionParcelaCombo;
    private JPanel ingresarParcelaPanel;
    private JLabel areaParcelaLabel;
    private JLabel ubicacionParcelaLabel;
    private JLabel nombreParcelaLabel;
    private JButton buscarParcelaButton;
    private JTextField buscarParcelaField;
    private JLabel buscarParcelaLabel;
    private JButton eliminarParcelaButton;
    private JPanel buscarParcelaPanel;
    private JScrollPane parcelasScroll;
    private JButton ingresarCultivoButton;
    private JLabel xLabel2;
    private JLabel anchoLabel1;
    private JLabel largoLabel1;
    private JList listaParcelas;
    private JLabel idLabel;
    private JLabel idParcelaLabel;
    private JButton modificarButton;
    private JTextArea buscarParcelaArea;
    private JButton ingresarButton;
    private JList listaCultivo;
    private JPanel cultivoPanel;
    private JComboBox comboBox1;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JLabel idCultivoLabel;
    private JLabel idLabelCultivo;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label9;
    private JLabel idParcelaCultivo;
    private JPanel buscarCultivoPanel;
    private JPanel planificarPanel;
    private JPanel diagnosticoPanel;
    private JPanel tratamientoPanel;
    private JButton modificarButton1;
    private JTextField buscarCultivoField;
    private JButton buscarCultivoButton;
    private JLabel labelBuscarCultivoId;
    private JTextArea cultivoEncontradoArea;
    private JButton eliminarCultivoButton;
    private JButton planificacionCultivoButton;
    private JTextArea planificarArea;
    private JButton verEstadoButton;
    private JButton sembrarButton;
    private JButton cosecharButton;
    private JLabel parcelaIdPlanificarLabel;
    private JLabel parcelaIdPlanificar;
    private JLabel cultivoIdPlanificarLabel;
    private JLabel cultivoIdPlanificar;


    //Lista Parcela
    private ListaParcela parcela = new ListaParcela();
    private Parcela parcelaEncontrada = null;

    // Lista Cultivo
    private ColaPrioCultivo cultivo = new ColaPrioCultivo();
    private Cultivo cultivoSeleccionado = null;

    private int idUlt, idNext = 1;


    public VentanaParcela(){

        JFrame frame = new JFrame("Ventana");

        //Barra de Menus
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);

        //Menu Opciones
        JMenu opciones = new JMenu("Opciones");
        menu.add(opciones);

        //Opciones items
        JMenuItem regresarInicio = new JMenuItem("Regresar al Inicio");
        opciones.add(regresarInicio);

        //Como Se va a abrir la ventana
        frame.setContentPane(this.Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        parcelaPane.setEnabledAt(2, false);
        parcelaPane.setEnabledAt(3, false);
        parcelaPane.setEnabledAt(4, false);
        parcelaPane.setEnabledAt(5, false);
        parcelaPane.setEnabledAt(6, false);



        //Opción Salir
        regresarInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parcelaPane.setEnabledAt(2, false);
                parcelaPane.setEnabledAt(3, false);
                parcelaPane.setEnabledAt(4, false);
                parcelaPane.setEnabledAt(5, false);
                parcelaPane.setEnabledAt(6, false);


                parcelaPane.setEnabledAt(0, true);
                parcelaPane.setEnabledAt(1, true);
                parcelaPane.setSelectedIndex(0);
                mostrarLista();
            }
        });




        //Botones de Parcela

        // Agregar Parcelas
        agregarParcelaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getSource() == agregarParcelaButton) {
                        String nombre = nombreParcelaField.getText();
                        String ubicacion = ubicacionParcelaCombo.getSelectedItem().toString();
                        double x = Double.parseDouble(xParcelaSpin.getValue().toString());
                        double y = Double.parseDouble(yParcelaSpin.getValue().toString());
                        if(nombre.equalsIgnoreCase("") || ubicacion.equalsIgnoreCase("") || x <= 0 || y <= 0) {
                            JOptionPane.showMessageDialog(null, "Por favor ingresar todos los parametros");
                        } else {
                            parcela.adicionarParcela(nombre, ubicacion, x, y);
                            mostrarLista();
                            borrarDatos();
                            genId();
                        }
                    }
                } catch(Exception r) {

                }
            }
        });

        // Buscar Parcelas
        buscarParcelaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getSource() == buscarParcelaButton) {

                        int id = Integer.parseInt(buscarParcelaField.getText());

                        if (buscarParcelaField.getText().equalsIgnoreCase("")) {
                            JOptionPane.showMessageDialog(null, "Debe ingresar un Id para buscar");
                        } else {
                            parcelaEncontrada = parcela.buscarParcela(id);

                            if (parcelaEncontrada != null) {
                                buscarParcelaArea.setText(parcelaEncontrada.toString());
                                eliminarParcelaButton.setEnabled(true);
                                ingresarCultivoButton.setEnabled(true);
                                buscarParcelaField.setText("");
                            } else {
                                buscarParcelaArea.setText("La parcela " + id + " no exite en la lista");
                                eliminarParcelaButton.setEnabled(false);
                                ingresarCultivoButton.setEnabled(false);
                                borrarDatos();
                            }
                        }
                    }
                } catch (Exception t) {
                    JOptionPane.showMessageDialog(null, "Ingrese el id correctamente", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Eliminar Parcelas
        eliminarParcelaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == eliminarParcelaButton) {
                    parcela.eliminarParcela(parcelaEncontrada);
                    mostrarLista();
                    buscarParcelaArea.setText("===La Parcela fue eliminada con exito===");
                    borrarDatos();
                }
            }
        });

        // Setear Datos de Lista
        listaParcelas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(listaParcelas.getSelectedIndex() != -1) {
                    agregarParcelaButton.setEnabled(false);
                    ubicacionParcelaCombo.setEnabled(false);
                    modificarButton.setEnabled(true);

                    int idx = listaParcelas.getSelectedIndex();
                    Parcela p = parcela.getParcelas().get(idx);

                    idParcelaLabel.setText(String.valueOf(p.getIdParcela()));
                    nombreParcelaField.setText(p.getNombreParcela());
                    ubicacionParcelaCombo.setSelectedItem(p.getUbicacionParcela());
                    xParcelaSpin.setValue(p.getDimensionesParcelaX());
                    yParcelaSpin.setValue(p.getDimensionesParcelaY());

                    parcelaEncontrada = parcela.buscarParcela(p.getIdParcela());
                }
            }
        });

        // Modificar la Lista
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getSource() == modificarButton) {
                        String nombre = nombreParcelaField.getText();
                        double x = Double.parseDouble(xParcelaSpin.getValue().toString());
                        double y = Double.parseDouble(yParcelaSpin.getValue().toString());
                        if (nombre.equalsIgnoreCase("") || x <= 0 || y <= 0) {
                            JOptionPane.showMessageDialog(null, "Por favor ingresar todos los parametros");
                        } else {
                            parcela.modificarParcela(parcelaEncontrada, nombre, x, y);
                            mostrarLista();
                            borrarDatos();
                            idParcelaLabel.setText(String.valueOf(idUlt));

                            agregarParcelaButton.setEnabled(true);
                            ubicacionParcelaCombo.setEnabled(true);
                            agregarParcelaButton.setEnabled(true);
                            modificarButton.setEnabled(false);
                        }
                    }
                } catch (Exception ex) {
                }

            }
        });

        // Dirige a Cutivos
        ingresarCultivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parcelaEncontrada == null) {
                    JOptionPane.showMessageDialog(null, "Primero busca o selecciona una parcela");
                    return;
                }
                refrescarListaCultivos();
                idParcelaCultivo.setText(String.valueOf(parcelaEncontrada.getIdParcela()));
                parcelaPane.setEnabledAt(2, true);
                parcelaPane.setEnabledAt(3, true);

                parcelaPane.setEnabledAt(0, false);
                parcelaPane.setEnabledAt(1, false);
                parcelaPane.setSelectedIndex(2);
            }
        });



        // Botones de Cultivo

        // Ingresar Cultivos
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (parcelaEncontrada == null) {
                        JOptionPane.showMessageDialog(null, "No hay parcela seleccionada para registrar cultivos");
                        return;
                    }

                    String tipo = comboBox1.getSelectedItem().toString();
                    int cantidad = Integer.parseInt(spinner1.getValue().toString());
                    double x = Double.parseDouble(spinner2.getValue().toString());
                    double y = Double.parseDouble(spinner3.getValue().toString());
                    idLabelCultivo.setText(String.valueOf(idNext));

                    if (tipo.equalsIgnoreCase("") || cantidad <= 0 || x <= 0 || y <= 0) {
                        JOptionPane.showMessageDialog(null, "Ingrese todos los datos correctamente");
                        return;
                    }

                    if (!parcelaEncontrada.tieneEspacioPara(x, y)) {
                        JOptionPane.showMessageDialog(
                                null,
                                "No hay espacio suficiente en la parcela\n" +
                                        "Área requerida: " + (x * y) + " m²\n" +
                                        "Área disponible: " + parcelaEncontrada.getAreaDisponible() + " m²"
                        );
                        return;
                    }

                    parcelaEncontrada.getCultivos().encolar(tipo, cantidad, x, y);
                    idNext++;

                    refrescarListaCultivos();
                    borrarDatosCultivo();
                    buscarParcelaArea.setText(parcelaEncontrada.toString());
                    JOptionPane.showMessageDialog(null, "Cultivo registrado en la parcela " + parcelaEncontrada.getIdParcela());

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al ingresar cultivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Lista de Cultivos
        listaCultivo.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Evita que se dispare dos veces mientras “arrastras”
                if (e.getValueIsAdjusting()) return;

                int idx = listaCultivo.getSelectedIndex();
                if (idx == -1 || parcelaEncontrada == null) return;

                List<Cultivo> cultivos = parcelaEncontrada.getCultivos().listarOrdenado();
                if (idx >= cultivos.size()) return;

                cultivoSeleccionado = cultivos.get(idx);

                modificarButton1.setEnabled(true);
                ingresarButton.setEnabled(false);
                comboBox1.setEnabled(false);

                // Setear datos en el panel de cultivo
                idCultivoLabel.setText(String.valueOf(cultivoSeleccionado.getIDcultivo())); // ajusta getter
                idParcelaCultivo.setText(String.valueOf(parcelaEncontrada.getIdParcela()));
                comboBox1.setSelectedItem(cultivoSeleccionado.getTipoCultivo());
                spinner1.setValue(cultivoSeleccionado.getCantidadSiembra());
                spinner2.setValue(cultivoSeleccionado.getAreaSiembraX());
                spinner3.setValue(cultivoSeleccionado.getAreaSiembraY());
            }
        });

        // Modificar Cultivo
        modificarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (parcelaEncontrada == null) {
                        JOptionPane.showMessageDialog(null, "No hay parcela seleccionada");
                        return;
                    }

                    int idCultivo = Integer.parseInt(idCultivoLabel.getText());
                    String nuevoTipo = comboBox1.getSelectedItem().toString();
                    int nuevaCantidad = Integer.parseInt(spinner1.getValue().toString());
                    int x = Integer.parseInt(spinner2.getValue().toString());
                    int y = Integer.parseInt(spinner3.getValue().toString());


                    boolean modificado = parcelaEncontrada.getCultivos().modificar(idCultivo, nuevaCantidad, x, y);

                    if (modificado) {
                        JOptionPane.showMessageDialog(null, "Cultivo modificado correctamente");
                        refrescarListaCultivos();
                        borrarDatosCultivo();
                        modificarButton1.setEnabled(false);
                        ingresarButton.setEnabled(true);
                        comboBox1.setEnabled(true);

                        refrescarListaCultivos();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo modificar el cultivo");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al modificar cultivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Buscar Cultivo
        buscarCultivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eliminarCultivoButton.setEnabled(true);
                    planificacionCultivoButton.setEnabled(true);


                    if (parcelaEncontrada == null) {
                        JOptionPane.showMessageDialog(null, "No hay parcela seleccionada");
                        return;
                    }

                    String texto = buscarCultivoField.getText().trim();
                    if (texto.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ingrese un ID de cultivo");
                        return;
                    }

                    int idCultivo = Integer.parseInt(texto);
                    Cultivo c = parcelaEncontrada.getCultivos().buscar(idCultivo);

                    if (c != null) {
                        idCultivoLabel.setText(String.valueOf(c.getIDcultivo()));
                        cultivoEncontradoArea.setText(c.toString());

                        cultivoSeleccionado = c;
                    } else {
                        idCultivoLabel.setText("");
                        cultivoEncontradoArea.setText("No se encontró cultivo con ese ID");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Eliminar Cultivo
        eliminarCultivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (parcelaEncontrada == null) {
                        JOptionPane.showMessageDialog(null, "No hay parcela seleccionada");
                        return;
                    }

                    String texto = idCultivoLabel.getText().trim();
                    if (texto.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Primero busca o selecciona un cultivo");
                        return;
                    }

                    int idCultivo = Integer.parseInt(texto);
                    boolean eliminado = parcelaEncontrada.getCultivos().eliminar(idCultivo);

                    if (eliminado) {
                        cultivoEncontradoArea.setText("Cultivo eliminado correctamente");
                        idCultivoLabel.setText("");
                        refrescarListaCultivos();
                        borrarDatosCultivo();
                    } else {
                        cultivoEncontradoArea.setText("No se pudo eliminar el cultivo");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar cultivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Direccion a Planificar
        planificacionCultivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parcelaEncontrada == null) {
                    JOptionPane.showMessageDialog(null, "Primero busca o selecciona una parcela");
                    return;
                }
                refrescarListaCultivos();
                idParcelaCultivo.setText(String.valueOf(parcelaEncontrada.getIdParcela()));
                parcelaPane.setEnabledAt(6, true);
                parcelaPane.setEnabledAt(5, true);
                parcelaPane.setEnabledAt(4, true);

                parcelaPane.setEnabledAt(3, false);
                parcelaPane.setEnabledAt(2, false);
                parcelaPane.setSelectedIndex(4);

                cultivoIdPlanificar.setText(String.valueOf(cultivoSeleccionado.getIDcultivo()));
                parcelaIdPlanificar.setText(String.valueOf(parcelaEncontrada.getIdParcela()));
            }

        });


        verEstadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int idCultivo = Integer.parseInt(cultivoIdPlanificar.getText());
                Cultivo c = parcelaEncontrada.getCultivos().buscar(idCultivo);

                if (c == null) {
                    JOptionPane.showMessageDialog(null, "Cultivo no encontrado");
                    return;
                }

                ESTADO estado = c.getEstado();
                String mensaje;

                if (estado == ESTADO.PLANIFICACION) {
                    sembrarButton.setEnabled(true);
                    cosecharButton.setEnabled(false);
                    mensaje = "Estado: " + estado;

                } else if (estado == ESTADO.SIEMBRA) {
                    sembrarButton.setEnabled(false);
                    cosecharButton.setEnabled(true);

                    String fechaSiembra = (c.getFechaSiembra() != null)
                            ? c.getFechaSiembra().toString()
                            : "No registrada";

                    mensaje = "Estado: " + estado +
                            "\nFecha de siembra: " + fechaSiembra;

                } else if (estado == ESTADO.COSECHA) {
                    sembrarButton.setEnabled(false);
                    cosecharButton.setEnabled(false);

                    String fechaSiembra = (c.getFechaSiembra() != null)
                            ? c.getFechaSiembra().toString()
                            : "No registrada";

                    String fechaCosecha = (c.getFechaCultivo() != null)
                            ? c.getFechaCultivo().toString()
                            : "No registrada";

                    mensaje = "Estado: " + estado +
                            "\nFecha de siembra: " + fechaSiembra +
                            "\nFecha de cosecha: " + fechaCosecha;

                } else {

                    mensaje = "Estado: " + estado;
                }
                planificarArea.setText("ESTADO\n" + mensaje);
            }

        });

        sembrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (parcelaEncontrada == null) {
                    JOptionPane.showMessageDialog(null, "No hay parcela seleccionada");
                    return;
                }

                String txtId = cultivoIdPlanificar.getText().trim();
                if (txtId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay cultivo seleccionado");
                    return;
                }

                int idCultivo;
                try {
                    idCultivo = Integer.parseInt(txtId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID de cultivo inválido");
                    return;
                }

                boolean ok = parcelaEncontrada.getCultivos().cambiarEstado(idCultivo, ESTADO.SIEMBRA);

                if (!ok) {
                    JOptionPane.showMessageDialog(null, "No se puede SEMBRAR en el estado actual");
                    return;
                }

                // Mostrar el estado actualizado reutilizando tu botón Ver Estado
                verEstadoButton.doClick();
            }
        });


        cosecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (parcelaEncontrada == null) {
                    JOptionPane.showMessageDialog(null, "No hay parcela seleccionada");
                    return;
                }

                String txtId = cultivoIdPlanificar.getText().trim();
                if (txtId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay cultivo seleccionado");
                    return;
                }

                int idCultivo;
                try {
                    idCultivo = Integer.parseInt(txtId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID de cultivo inválido");
                    return;
                }

                boolean ok = parcelaEncontrada.getCultivos().cambiarEstado(idCultivo, ESTADO.COSECHA);

                if (!ok) {
                    JOptionPane.showMessageDialog(null, "No se puede COSECHAR en el estado actual");
                    return;
                }

                // Mostrar el estado actualizado reutilizando tu botón Ver Estado
                verEstadoButton.doClick();
            }
        });

    }

    // Funciones de Parcela
    public void borrarDatos() {
        nombreParcelaField.setText("");
        ubicacionParcelaCombo.setSelectedIndex(0);
        xParcelaSpin.setValue(0);
        yParcelaSpin.setValue(0);
    }

    public void mostrarLista() {
        DefaultListModel dlm = new DefaultListModel();
        List<Parcela> parcelas = parcela.getParcelas();

        for(Parcela p : parcelas) {
            dlm.addElement(p.toString());
        }
        listaParcelas.setModel(dlm);
    }

    public void genId() {
        Parcela p = parcela.getParcelas().get(idUlt);
        idUlt = p.getIdParcela() + 1;
        idParcelaLabel.setText(String.valueOf(idUlt));
    }


    // Funciones de Cultivo
    private void borrarDatosCultivo() {
        comboBox1.setSelectedIndex(0);
        spinner1.setValue(0);
        spinner2.setValue(0);
        spinner3.setValue(0);
    }

    private void refrescarListaCultivos() {
        DefaultListModel<String> dlm = new DefaultListModel<>();

        if (parcelaEncontrada != null) {
            List<Cultivo> cultivos = parcelaEncontrada.getCultivos().listarOrdenado();
            for (Cultivo c : cultivos) {
                dlm.addElement(c.toString()); // asegúrate que Cultivo tenga toString bonito
            }
        }

        listaCultivo.setModel(dlm);
    }


}
