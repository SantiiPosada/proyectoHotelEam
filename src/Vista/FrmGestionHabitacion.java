/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtlHabitacion;
import Excepcion.BuscarHabitacionException;
import Excepcion.CargarImagenException;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHabitacionException;
import Excepcion.NombreHabitacionException;
import Modelo.Administrador;
import Modelo.Habitacion;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mateo
 */
public class FrmGestionHabitacion extends javax.swing.JFrame {

    private Administrador administrador;
    private final CtlHabitacion controlador;

    public FrmGestionHabitacion() {
        controlador =new CtlHabitacion();
        initComponents();

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        btnCancelar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnModificar.setEnabled(false);
        JtblHabitacion.setEnabled(true);
        txtRuta.setEditable(false);
//        listar();
    }

//    public FrmGestionHabitacion(Administrador administrador) {
//        initComponents();
//        this.administrador = administrador;
//        this.setLocationRelativeTo(null);
//        this.setResizable(false);
//        btnCancelar.setEnabled(true);
//        btnModificar.setEnabled(false);
//        btnCancelar.setEnabled(false);
//        btnModificar.setEnabled(false);
//        JtblHabitacion.setEnabled(true);
//        listar();
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblPiso = new javax.swing.JLabel();
        txtFiltrar = new javax.swing.JTextField();
        lblBano = new javax.swing.JLabel();
        lblSala = new javax.swing.JLabel();
        lblValorNoche = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtblHabitacion = new javax.swing.JTable();
        lblmagen = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblFiltrar = new javax.swing.JLabel();
        CbxFiltrar = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtValorNoche = new javax.swing.JTextField();
        btnSeleccionarImagen = new javax.swing.JButton();
        txtRuta = new javax.swing.JTextField();
        spnBano = new javax.swing.JSpinner();
        spnPiso = new javax.swing.JSpinner();
        spnSala = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setText("Nombre :");

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        lblPiso.setForeground(new java.awt.Color(0, 0, 0));
        lblPiso.setText("Pisos :");

        txtFiltrar.setBackground(new java.awt.Color(255, 255, 255));
        txtFiltrar.setForeground(new java.awt.Color(0, 0, 0));
        txtFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltrarKeyTyped(evt);
            }
        });

        lblBano.setForeground(new java.awt.Color(0, 0, 0));
        lblBano.setText("Baños :");

        lblSala.setForeground(new java.awt.Color(0, 0, 0));
        lblSala.setText("Salas :");

        lblValorNoche.setForeground(new java.awt.Color(0, 0, 0));
        lblValorNoche.setText("Valor por noche :");

        lblDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        lblDescripcion.setText("Descripcion :");

        JtblHabitacion.setBackground(new java.awt.Color(255, 255, 255));
        JtblHabitacion.setForeground(new java.awt.Color(0, 0, 0));
        JtblHabitacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Piso", "Baño", "Sala", "Estado", "Nombre Imagen", "Descripcion", "Valor por noche"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(JtblHabitacion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jScrollPane1.setViewportView(jPanel2);

        lblmagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo blanco.gif"))); // NOI18N
        lblmagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblmagen.setMaximumSize(new java.awt.Dimension(4, 4));
        lblmagen.setMinimumSize(new java.awt.Dimension(4, 4));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(255, 255, 255));
        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("GESTION HABITACIÓN");

        lblFiltrar.setForeground(new java.awt.Color(0, 0, 0));
        lblFiltrar.setText("Filtrar tabla por :");

        CbxFiltrar.setBackground(new java.awt.Color(255, 255, 255));
        CbxFiltrar.setForeground(new java.awt.Color(0, 0, 0));
        CbxFiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Id", "Nombre", "Piso", "Baño", "Sala", "Estado", "Nombre Imagen", "Descripcion", "Valor por noche" }));

        btnFiltrar.setBackground(new java.awt.Color(255, 255, 255));
        btnFiltrar.setForeground(new java.awt.Color(0, 0, 0));
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        btnActualizar.setBorder(null);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtValorNoche.setBackground(new java.awt.Color(255, 255, 255));
        txtValorNoche.setForeground(new java.awt.Color(0, 0, 0));
        txtValorNoche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorNocheKeyTyped(evt);
            }
        });

        btnSeleccionarImagen.setBackground(new java.awt.Color(255, 255, 255));
        btnSeleccionarImagen.setForeground(new java.awt.Color(0, 0, 0));
        btnSeleccionarImagen.setText("Seleccionar imagen");
        btnSeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarImagenActionPerformed(evt);
            }
        });

        txtRuta.setBackground(new java.awt.Color(255, 255, 255));
        txtRuta.setForeground(new java.awt.Color(0, 0, 0));
        txtRuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRutaKeyTyped(evt);
            }
        });

        spnBano.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spnPiso.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spnSala.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        txtDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setColumns(20);
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setRows(5);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtDescripcion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(305, 305, 305)
                                .addComponent(lblFiltrar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblPiso)
                                    .addComponent(lblBano)
                                    .addComponent(lblValorNoche)
                                    .addComponent(lblDescripcion)
                                    .addComponent(lblSala))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorNoche, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnBano, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnSala, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CbxFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnSeleccionarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblmagen, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28))))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnRegistrar)
                                        .addGap(14, 14, 14)
                                        .addComponent(btnBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnModificar)
                                        .addGap(14, 14, 14)
                                        .addComponent(btnEliminar)
                                        .addGap(15, 15, 15)
                                        .addComponent(btnCancelar))
                                    .addComponent(lblmagen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSalir)
                                    .addComponent(btnSeleccionarImagen))
                                .addGap(18, 18, 18)
                                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombre)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPiso)
                                    .addComponent(spnPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblBano)
                                    .addComponent(spnBano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSala)
                                    .addComponent(spnSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblValorNoche)
                                    .addComponent(txtValorNoche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescripcion)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFiltrar)
                        .addComponent(CbxFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFiltrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
//        try {
//            String nombre = controlador.obtenerDatoJtextFile(txtNombre);
//            String piso = controlador.obtenerDatoJtextFile(txtPiso);
//            String bano = controlador.obtenerDatoJtextFile(txtBano);
//            String sala = controlador.obtenerDatoJtextFile(txtSala);
//            String estado = "No Disponible";
//            String valornoche = controlador.obtenerDatoJtextFile(txtValorNoche) + "$";
//            String descripcion = controlador.obtenerDatoJtextFile(txtDescripcion);
//  File ruta = new File(txtRuta.getText());
////falta imagen
//            controlador.modificarHabitacion(nombre, piso, bano, sala, estado, ruta, descripcion, valornoche);
//            JOptionPane.showMessageDialog(null, "Se Elimino la habitacion " + nombre + " correctamente");
//        } catch (ModificarHabitacionException | NombreHabitacionException | BuscarHabitacionException | DatosIncompletosException | CargarImagenException ex) {
//            imprimir(ex.getMessage());
//        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        FrmAdministrador vista = new FrmAdministrador(administrador);
        vista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
       char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9') && c != '_' && c != '@' && c != '.' && c != '-' && c != ',') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtFiltrarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltrarKeyTyped

    }//GEN-LAST:event_txtFiltrarKeyTyped

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        try {
            String opcion = controlador.obtenerDatoJComboBox(CbxFiltrar);
            String accion = controlador.obtenerDatoJtextFile(txtFiltrar);
            JtblHabitacion.setModel(controlador.filtrar(opcion, accion));

        } catch (ComboBoxException | DatosIncompletosException e) {
            imprimir(e.getMessage());
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // listar();
        CbxFiltrar.setSelectedItem("Seleccione");
        txtFiltrar.setText(null);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            String nombre = controlador.obtenerDatoJtextFile(txtNombre);
            String piso = spnPiso.getValue().toString();
            String bano = spnBano.getValue().toString();
            String sala = spnSala.getValue().toString();
            String estado = "Disponible";
            String valornoche = controlador.obtenerDatoJtextFile(txtValorNoche) ;
            String descripcion = controlador.obtenerDatoJtextArea(txtDescripcion);
            File ruta = new File(txtRuta.getText());
//falta imagen 
            controlador.guardarHabitacion(nombre, piso, bano, sala, estado, ruta, descripcion, valornoche);
            imprimir("Se guardó la habitacion " + nombre + " correctamente");
            vaciarCampos();
           // listar();
        } catch (DatosIncompletosException | GuardarHabitacionException | NombreHabitacionException | CargarImagenException ex) {
            imprimir(ex.getMessage());
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnRegistrar.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);
        txtNombre.setEnabled(true);
        vaciarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            Habitacion habitacion = controlador.buscarHabitacion(controlador.obtenerDatoJtextFile(txtNombre));
            imprimir("Se encontro la habitacion " + habitacion.getNombre() + " correctamente");
            cargarInformacion(habitacion);
            btnRegistrar.setEnabled(false);
            btnEliminar.setEnabled(true);
            btnModificar.setEnabled(true);
            btnBuscar.setEnabled(false);
            txtNombre.setEnabled(false);
            btnCancelar.setEnabled(true);

        } catch (BuscarHabitacionException | DatosIncompletosException ex) {
            imprimir(ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        try {
//            String nombre = controlador.obtenerDatoJtextFile(txtNombre);
//            String piso = controlador.obtenerDatoJtextFile(txtPiso);
//            String bano = controlador.obtenerDatoJtextFile(txtBano);
//            String sala = controlador.obtenerDatoJtextFile(txtSala);
//            String estado = controlador.obtenerDatoJtextFile(txtEstado);
//            String valornoche = controlador.obtenerDatoJtextFile(txtValorNoche) + "$";
//            String descripcion = controlador.obtenerDatoJtextFile(txtDescripcion);
//            File ruta = new File(txtRuta.getText());
////falta imagen
//            controlador.modificarHabitacion(nombre, piso, bano, sala, estado, ruta, descripcion, valornoche);
//            JOptionPane.showMessageDialog(null, "Se Modifico la habitacion " + nombre + " correctamente");
//        } catch (DatosIncompletosException | ModificarHabitacionException | NombreHabitacionException | BuscarHabitacionException | CargarImagenException ex) {
//            Logger.getLogger(FrmGestionHabitacion.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtValorNocheKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorNocheKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorNocheKeyTyped

    private void btnSeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarImagenActionPerformed

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setDialogTitle("Seleccione la imagen de la habitación");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");//se le asigna un filtro
        fileChooser.setFileFilter(filtro);
        int condi = fileChooser.showOpenDialog(this);
        if (condi == JFileChooser.APPROVE_OPTION) {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            rsscalelabel.RSScaleLabel.setScaleLabel(lblmagen, fileChooser.getSelectedFile().toString());//carga la imagen
            txtRuta.setText(ruta);

        }
    }//GEN-LAST:event_btnSeleccionarImagenActionPerformed

    private void txtRutaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutaKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
       char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9') && c != '_' && c != '@' && c != '.' && c != '-' && c != ',') {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped
//    public final void listar() {
//        JtblHabitacion.setModel(controlador.listarElementos());
//    }

    private void vaciarCampos() {
       
        txtNombre.setText(null);
        spnBano.setValue(0);
        spnPiso.setValue(0);
        spnSala.setValue(0);
        txtRuta.setText(null);
        txtValorNoche.setText(null);
        txtDescripcion.setText(null);
        txtRuta.setText(null);
        lblmagen.setIcon(null);
        //falta imagen
    }

    private void cargarInformacion(Habitacion habitacion) {


        txtNombre.setText(habitacion.getNombre());
        spnPiso.setValue(habitacion.getPiso());
        spnBano.setValue(habitacion.getBano());
        spnSala.setValue(habitacion.getSala());

        txtValorNoche.setText(habitacion.getValorPorNoche() + "$");
        txtDescripcion.setText(habitacion.getDescripcion());

        //falta imagen
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmGestionHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGestionHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGestionHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGestionHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGestionHabitacion().setVisible(true);
            }
        });
    }

    private void imprimir(String v) {
        JOptionPane.showMessageDialog(null, v);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbxFiltrar;
    private javax.swing.JTable JtblHabitacion;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionarImagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBano;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPiso;
    private javax.swing.JLabel lblSala;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorNoche;
    private javax.swing.JLabel lblmagen;
    private javax.swing.JSpinner spnBano;
    private javax.swing.JSpinner spnPiso;
    private javax.swing.JSpinner spnSala;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFiltrar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtValorNoche;
    // End of variables declaration//GEN-END:variables
}
