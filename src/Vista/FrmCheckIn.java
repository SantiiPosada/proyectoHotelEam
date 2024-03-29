/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtlCheckIn;
import Excepcion.BuscarHabitacionException;
import Excepcion.BuscarHuespedException;
import Excepcion.CargarImagenException;
import Excepcion.DatosIncompletosException;
import Excepcion.DiaException;
import Excepcion.GuardarCuentaPersonalException;
import Excepcion.MultaException;
import Excepcion.anoException;
import Excepcion.horaException;
import Excepcion.mesException;
import Excepcion.modificarReservaCheckIn;
import Modelo.Administrador;
import Modelo.Habitacion;
import Modelo.Huesped;
import Modelo.Recepcionista;
import Modelo.ReservaHabitacion;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mateo
 */
public class FrmCheckIn extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenuRecepcionista
     */
    private Recepcionista recepcionista = null;
    private Administrador administrador=null;
    private Huesped huesped = null;
    private ReservaHabitacion reserva = null;
    CtlCheckIn controlador;

    public FrmCheckIn() {
        initComponents();
        asignarFechaHoy();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public FrmCheckIn(Administrador administrador, Recepcionista recepcionista ) {
        this.recepcionista = recepcionista;
        this.administrador=administrador;
        controlador = new CtlCheckIn();
        initComponents();
        cargarInformacion();
        asignarFechaHoy();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        lblNombre2 = new javax.swing.JLabel();
        lblCedulahuesped = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblCedulahuesped1 = new javax.swing.JLabel();
        txtNombreCompleto = new javax.swing.JTextField();
        lblCedulahuesped2 = new javax.swing.JLabel();
        txtCedula2 = new javax.swing.JTextField();
        lblCedulahuesped3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblCedulahuesped4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCedulahuesped5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnConsultar1 = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        lblSeleccione = new javax.swing.JLabel();
        cbxReserva = new javax.swing.JComboBox<>();
        lblNombrehabitacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblDescripcion = new javax.swing.JTextArea();
        lblValornoche = new javax.swing.JLabel();
        lblFechallegada = new javax.swing.JLabel();
        dateFechaLlegada1 = new com.toedter.calendar.JDateChooser();
        lblFechasalida = new javax.swing.JLabel();
        dateFechaSalida = new com.toedter.calendar.JDateChooser();
        lblFechasalida1 = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        dateFechaHoy = new com.toedter.calendar.JDateChooser();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logousuarios.png"))); // NOI18N

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("NOMBRE COMPLETO");

        lblCedula.setBackground(new java.awt.Color(255, 255, 255));
        lblCedula.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula.setText("CEDULA");

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setForeground(new java.awt.Color(102, 0, 0));
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblNombre2.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblNombre2.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre2.setText("CHECK IN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(lblNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(366, 366, 366))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblCedula)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir)
                        .addGap(5, 5, 5))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombre2)
                .addGap(59, 59, 59))
        );

        lblCedulahuesped.setBackground(new java.awt.Color(255, 255, 255));
        lblCedulahuesped.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblCedulahuesped.setForeground(new java.awt.Color(0, 0, 0));
        lblCedulahuesped.setText("Cedula Huesped :");

        btnConsultar.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultar.setForeground(new java.awt.Color(102, 0, 0));
        btnConsultar.setText("CONSULTAR");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        lblCedulahuesped1.setBackground(new java.awt.Color(255, 255, 255));
        lblCedulahuesped1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblCedulahuesped1.setForeground(new java.awt.Color(0, 0, 0));
        lblCedulahuesped1.setText("Cedula Huesped :");

        txtNombreCompleto.setEnabled(false);

        lblCedulahuesped2.setBackground(new java.awt.Color(255, 255, 255));
        lblCedulahuesped2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblCedulahuesped2.setForeground(new java.awt.Color(0, 0, 0));
        lblCedulahuesped2.setText("Nombre completo :");

        txtCedula2.setEnabled(false);

        lblCedulahuesped3.setBackground(new java.awt.Color(255, 255, 255));
        lblCedulahuesped3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblCedulahuesped3.setForeground(new java.awt.Color(0, 0, 0));
        lblCedulahuesped3.setText("Telefono :");

        txtTelefono.setEnabled(false);

        lblCedulahuesped4.setBackground(new java.awt.Color(255, 255, 255));
        lblCedulahuesped4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblCedulahuesped4.setForeground(new java.awt.Color(0, 0, 0));
        lblCedulahuesped4.setText("Correo electronico :");

        txtCorreo.setEnabled(false);

        lblCedulahuesped5.setBackground(new java.awt.Color(255, 255, 255));
        lblCedulahuesped5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblCedulahuesped5.setForeground(new java.awt.Color(0, 0, 0));
        lblCedulahuesped5.setText("DATOS PERSONALES");

        btnConsultar1.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultar1.setForeground(new java.awt.Color(102, 0, 0));
        btnConsultar1.setText("GENERAR CHECK IN");
        btnConsultar1.setEnabled(false);
        btnConsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar1ActionPerformed(evt);
            }
        });

        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImagen.setMaximumSize(new java.awt.Dimension(4, 4));
        lblImagen.setMinimumSize(new java.awt.Dimension(4, 4));

        lblSeleccione.setBackground(new java.awt.Color(255, 255, 255));
        lblSeleccione.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblSeleccione.setForeground(new java.awt.Color(0, 0, 0));
        lblSeleccione.setText("Seleccione Reserva:");

        cbxReserva.setBackground(new java.awt.Color(255, 255, 255));
        cbxReserva.setForeground(new java.awt.Color(0, 0, 0));
        cbxReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxReservaMouseClicked(evt);
            }
        });
        cbxReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxReservaActionPerformed(evt);
            }
        });

        lblNombrehabitacion.setBackground(new java.awt.Color(255, 255, 255));
        lblNombrehabitacion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblNombrehabitacion.setForeground(new java.awt.Color(0, 0, 0));
        lblNombrehabitacion.setText("NOMBRE HABITACION");

        lblDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setColumns(20);
        lblDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        lblDescripcion.setRows(5);
        jScrollPane1.setViewportView(lblDescripcion);

        lblValornoche.setBackground(new java.awt.Color(255, 255, 255));
        lblValornoche.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblValornoche.setForeground(new java.awt.Color(0, 0, 0));
        lblValornoche.setText("VALOR POR NOCHE");

        lblFechallegada.setBackground(new java.awt.Color(255, 255, 255));
        lblFechallegada.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblFechallegada.setForeground(new java.awt.Color(0, 0, 0));
        lblFechallegada.setText("Fecha llegada :");

        dateFechaLlegada1.setEnabled(false);

        lblFechasalida.setBackground(new java.awt.Color(255, 255, 255));
        lblFechasalida.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblFechasalida.setForeground(new java.awt.Color(0, 0, 0));
        lblFechasalida.setText("Fecha salida :");

        dateFechaSalida.setEnabled(false);

        lblFechasalida1.setBackground(new java.awt.Color(255, 255, 255));
        lblFechasalida1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblFechasalida1.setForeground(new java.awt.Color(0, 0, 0));
        lblFechasalida1.setText("Fecha salida :");

        lblValor.setBackground(new java.awt.Color(255, 255, 255));
        lblValor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblValor.setForeground(new java.awt.Color(0, 0, 0));
        lblValor.setText("VALOR");
        lblValor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblFechasalida1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(159, 159, 159)
                                        .addComponent(lblFechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .addGap(392, 392, 392))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(80, 80, 80)
                                            .addComponent(lblFechallegada, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(67, 67, 67)
                                            .addComponent(dateFechaLlegada1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(dateFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dateFechaHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCedulahuesped)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCedulahuesped1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCedulahuesped3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCedula2, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(txtTelefono))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblCedulahuesped2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblCedulahuesped4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCorreo))))
                            .addComponent(lblCedulahuesped5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblSeleccione)
                                        .addGap(2, 2, 2)
                                        .addComponent(cbxReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(lblNombrehabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lblValornoche)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedulahuesped)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCedulahuesped5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedulahuesped1)
                    .addComponent(txtNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedulahuesped2)
                    .addComponent(txtCedula2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedulahuesped3)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedulahuesped4)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombrehabitacion)
                            .addComponent(lblValornoche)
                            .addComponent(lblValor)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSeleccione))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFechallegada)
                                .addGap(18, 18, 18)
                                .addComponent(dateFechaLlegada1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFechasalida1)
                                    .addComponent(lblFechasalida))
                                .addGap(30, 30, 30)
                                .addComponent(dateFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConsultar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateFechaHoy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(69, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
      if (this.administrador != null) {
            FrmAdministrador vista = new FrmAdministrador(administrador);
            vista.setVisible(true);
            this.dispose();
        } else if (this.recepcionista != null) {
            FrmMenuRecepcionista vista = new FrmMenuRecepcionista(recepcionista);
            vista.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        try {
            String cedula = controlador.obtenerDatoJtextFile(txtCedula);
            huesped = controlador.buscarHuesped(cedula);
            cargarInfo(huesped);
        } catch (BuscarHuespedException | DatosIncompletosException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar1ActionPerformed
        try {
            controlador.realizarCheckIn(dateFechaHoy.getDate(), reserva, huesped.getId());
            JOptionPane.showMessageDialog(null, "Se realizó el chek In correctamente");
            llenarComboBox(huesped.getId());
            limpiar();
        } catch (GuardarCuentaPersonalException | anoException | mesException | DiaException | horaException | DatosIncompletosException | modificarReservaCheckIn ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (MultaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            llenarComboBox(huesped.getId());
            limpiar();
        }

    }//GEN-LAST:event_btnConsultar1ActionPerformed

    private void cbxReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxReservaMouseClicked
        try {
            Habitacion habitacion = controlador.buscarHabitacion(Integer.parseInt(cbxReserva.getSelectedItem().toString()));

            lblNombrehabitacion.setText(habitacion.getNombre());
            lblValor.setText(habitacion.getValorPorNoche());
            lblDescripcion.setText(habitacion.getDescripcion());
            lblImagen.setIcon(new ImageIcon(controlador.cargarImagenBufferedImage(habitacion.getImagen())));

            reserva = controlador.buscarReserva(Integer.parseInt(cbxReserva.getSelectedItem().toString()));
            dateFechaLlegada1.setDate(reserva.getFechaHoraCheckIn());
            dateFechaSalida.setDate(reserva.getFechaHoraCheckOut());
            btnConsultar1.setEnabled(true);
        } catch (BuscarHabitacionException | CargarImagenException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NumberFormatException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Seleccione una reserva");
        }


    }//GEN-LAST:event_cbxReservaMouseClicked

    private void cbxReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxReservaActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private void cargarInformacion(){
        
        if (this.recepcionista != null) {

            lblCedula.setText(this.recepcionista.getCedula());
            lblNombre.setText(this.recepcionista.getNombrecompleto());

        } else if (this.administrador != null) {

            lblCedula.setText(this.administrador.getCedula());
            lblNombre.setText(this.administrador.getNombrecompleto());
        }
    }
    
    private void limpiar() {

        txtCedula2.setText("");
        txtNombreCompleto.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");

        dateFechaLlegada1.setDate(null);
        dateFechaSalida.setDate(null);
        lblNombrehabitacion.setText("NOMBRE HABITACION");
        lblValor.setText("VALOR");
        lblDescripcion.setText("");

        lblImagen.setIcon(null);
    }

    private void cargarInfo(Huesped x) {

        txtCedula2.setText(x.getCedula());
        txtNombreCompleto.setText(x.getNombrecompleto());
        txtCorreo.setText(x.getCorreo());
        txtTelefono.setText(x.getTelefono());
        llenarComboBox(x.getId());

    }

    private void llenarComboBox(int idHuesped) {
        cbxReserva.setModel(controlador.llenarComboBox(idHuesped));
    }

    private void asignarFechaHoy() {

        Calendar hoy = new GregorianCalendar();
        dateFechaHoy.setCalendar(hoy);

    }

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
            java.util.logging.Logger.getLogger(FrmCheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCheckIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnConsultar1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxReserva;
    private com.toedter.calendar.JDateChooser dateFechaHoy;
    private com.toedter.calendar.JDateChooser dateFechaLlegada1;
    private com.toedter.calendar.JDateChooser dateFechaSalida;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCedulahuesped;
    private javax.swing.JLabel lblCedulahuesped1;
    private javax.swing.JLabel lblCedulahuesped2;
    private javax.swing.JLabel lblCedulahuesped3;
    private javax.swing.JLabel lblCedulahuesped4;
    private javax.swing.JLabel lblCedulahuesped5;
    private javax.swing.JTextArea lblDescripcion;
    private javax.swing.JLabel lblFechallegada;
    private javax.swing.JLabel lblFechasalida;
    private javax.swing.JLabel lblFechasalida1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombrehabitacion;
    private javax.swing.JLabel lblSeleccione;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValornoche;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedula2;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombreCompleto;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
