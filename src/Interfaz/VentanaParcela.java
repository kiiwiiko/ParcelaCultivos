package Interfaz;


import Estructura.ListaParcela;
import Negocio.Cultivo;
import Negocio.Parcela;
import com.sun.jdi.Value;

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


    //Lista Parcela
    private ListaParcela parcela = new ListaParcela();
    private Parcela parcelaEncontrada = null;

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



        //Opcion Salir
        regresarInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parcelaPane.setEnabledAt(2, false);
                parcelaPane.setEnabledAt(0, true);
                parcelaPane.setEnabledAt(1, true);
                abrirPanelCultivo(1);
                mostrarLista();
            }
        });

        //Parcela
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


        //Parcela
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
                parcelaPane.setEnabledAt(0, false);
                parcelaPane.setEnabledAt(1, false);
                abrirPanelCultivo(2);
            }
        });

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


    }

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

    private void abrirPanelCultivo(int i) {
        parcelaPane.setSelectedIndex(i);
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

    private void borrarDatosCultivo() {
        comboBox1.setSelectedIndex(0);
        spinner1.setValue(0);
        spinner2.setValue(0);
        spinner3.setValue(0);
    }
}
