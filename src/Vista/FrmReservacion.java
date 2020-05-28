/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtlHabitacion;
import Controlador.CtlReserva;
import Excepcion.BuscarHabitacionException;
import Excepcion.CargarImagenException;
import Excepcion.DatosIncompletosException;
import Excepcion.DayException;
import Excepcion.FechaException;
import Excepcion.GuardarReservaException;
import Excepcion.anoException;
import Excepcion.mesException;
import Modelo.Habitacion;
import Modelo.Huesped;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mateo
 */
public class FrmReservacion extends javax.swing.JFrame {

    private final CtlReserva controlador;
    private final CtlHabitacion controladorhabitacion;
    private Huesped huesped;
    private Habitacion habitacion;

    public FrmReservacion() {
        initComponents();
        controlador = new CtlReserva();
        controladorhabitacion = new CtlHabitacion();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }

    public FrmReservacion(Huesped huesped) {
        this.huesped = huesped;
        habitacion = null;
        controlador = new CtlReserva();
        controladorhabitacion = new CtlHabitacion();
        initComponents();
        asignarFechaHoy();
        llenarComboBox();
        dateFechaHoy.setVisible(false);
        cargarInfo(this.huesped);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        dateFechaHoy = new com.toedter.calendar.JDateChooser();
        lblTitulo = new javax.swing.JLabel();
        cbxHabitacion = new javax.swing.JComboBox<>();
        lblImagen = new javax.swing.JLabel();
        lblNombrehabitacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblDescripcion = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        lblCedulahuesped = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblNombrecompleto = new javax.swing.JLabel();
        txtNombrecompleto = new javax.swing.JTextField();
        lblFechallegada = new javax.swing.JLabel();
        dateFechaLlegada = new com.toedter.calendar.JDateChooser();
        lblFechasalida = new javax.swing.JLabel();
        dateFechaSalida = new com.toedter.calendar.JDateChooser();
        lblValornoche = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        btnReservar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblSeleccione = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        lblCedula.setBackground(new java.awt.Color(255, 255, 255));
        lblCedula.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula.setText("CEDULA");

        lblLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logousuarios.png"))); // NOI18N

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("NOMBRE COMPLETO");

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setForeground(new java.awt.Color(102, 0, 0));
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dateFechaHoy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lblCedula)
                .addGap(18, 18, 18)
                .addComponent(lblNombre)
                .addGap(45, 45, 45)
                .addComponent(dateFechaHoy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        lblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("RESERVACION");

        cbxHabitacion.setBackground(new java.awt.Color(255, 255, 255));
        cbxHabitacion.setForeground(new java.awt.Color(0, 0, 0));
        cbxHabitacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxHabitacionMouseClicked(evt);
            }
        });
        cbxHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxHabitacionActionPerformed(evt);
            }
        });

        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImagen.setMaximumSize(new java.awt.Dimension(4, 4));
        lblImagen.setMinimumSize(new java.awt.Dimension(4, 4));

        lblNombrehabitacion.setBackground(new java.awt.Color(255, 255, 255));
        lblNombrehabitacion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblNombrehabitacion.setForeground(new java.awt.Color(0, 0, 0));
        lblNombrehabitacion.setText("NOMBRE HABITACION");

        lblDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setColumns(20);
        lblDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        lblDescripcion.setRows(5);
        jScrollPane1.setViewportView(lblDescripcion);

        lblCedulahuesped.setBackground(new java.awt.Color(255, 255, 255));
        lblCedulahuesped.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblCedulahuesped.setForeground(new java.awt.Color(0, 0, 0));
        lblCedulahuesped.setText("Cedula Huesped :");

        txtCedula.setEnabled(false);

        lblNombrecompleto.setBackground(new java.awt.Color(255, 255, 255));
        lblNombrecompleto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblNombrecompleto.setForeground(new java.awt.Color(0, 0, 0));
        lblNombrecompleto.setText("Nombre completo:");

        txtNombrecompleto.setEnabled(false);

        lblFechallegada.setBackground(new java.awt.Color(255, 255, 255));
        lblFechallegada.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblFechallegada.setForeground(new java.awt.Color(0, 0, 0));
        lblFechallegada.setText("Fecha llegada :");

        lblFechasalida.setBackground(new java.awt.Color(255, 255, 255));
        lblFechasalida.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblFechasalida.setForeground(new java.awt.Color(0, 0, 0));
        lblFechasalida.setText("Fecha salida :");

        lblValornoche.setBackground(new java.awt.Color(255, 255, 255));
        lblValornoche.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblValornoche.setForeground(new java.awt.Color(0, 0, 0));
        lblValornoche.setText("VALOR POR NOCHE");

        lblValor.setBackground(new java.awt.Color(255, 255, 255));
        lblValor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblValor.setForeground(new java.awt.Color(0, 0, 0));
        lblValor.setText("VALOR");
        lblValor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnReservar.setBackground(new java.awt.Color(255, 255, 255));
        btnReservar.setForeground(new java.awt.Color(102, 0, 0));
        btnReservar.setText("RESERVAR");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setForeground(new java.awt.Color(102, 0, 0));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblSeleccione.setBackground(new java.awt.Color(255, 255, 255));
        lblSeleccione.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblSeleccione.setForeground(new java.awt.Color(0, 0, 0));
        lblSeleccione.setText("Seleccione habitacion:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombrehabitacion)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblValornoche)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblSeleccione)
                                                .addGap(2, 2, 2)
                                                .addComponent(cbxHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(lblFechallegada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lblCedulahuesped, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtCedula)
                                                    .addComponent(dateFechaLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblNombrecompleto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblFechasalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNombrecompleto)
                                        .addComponent(dateFechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSeleccione))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombrehabitacion)
                            .addComponent(lblValornoche))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValor)))
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedulahuesped)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombrecompleto)
                    .addComponent(txtNombrecompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechallegada)
                    .addComponent(dateFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechasalida)
                    .addComponent(dateFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReservar)
                    .addComponent(btnCancelar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        try {

            Date fechaReserva = dateFechaHoy.getDate();
            Date fechaLleaga = dateFechaLlegada.getDate();
            Date fechaSalida = dateFechaSalida.getDate();
            if (habitacion == null) {
                imprimir("Seleccione una habitacion a reservar");
            } else {

                controlador.guardarReserva(huesped.getId(), habitacion.getId(), fechaReserva, fechaLleaga, fechaSalida);
                imprimir("Se registrò la reserva correctamente");
                limpiar();
            }

        } catch (GuardarReservaException | DatosIncompletosException |anoException |mesException | FechaException | DayException ex) {
            imprimir(ex.getMessage());
        } 


    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        FrmMenuHuesped menuhuesped = new FrmMenuHuesped(huesped);
        menuhuesped.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxHabitacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxHabitacionMouseClicked
        String nombreimagen = cbxHabitacion.getSelectedItem().toString();
        try {
            Habitacion habita = controladorhabitacion.buscarHabitacion(nombreimagen);
            this.habitacion = habita;
            lblNombrehabitacion.setText(habitacion.getNombre());
            lblValor.setText(habitacion.getValorPorNoche());
            lblDescripcion.setText(habitacion.getDescripcion());
            txtNombrecompleto.setText(huesped.getNombrecompleto());
            txtCedula.setText(huesped.getCedula());
            lblImagen.setIcon(new ImageIcon(controlador.cargarImagenBufferedImage(habitacion.getImagen())));
        } catch (DatosIncompletosException | BuscarHabitacionException | CargarImagenException e) {
            imprimir(e.getMessage());
        }

    }//GEN-LAST:event_cbxHabitacionMouseClicked

    private void cbxHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxHabitacionActionPerformed
    private void cargarInfo(Huesped x) {
        lblCedula.setText(x.getCedula());
        lblNombre.setText(x.getNombrecompleto());

    }

    private void limpiar() {
        txtCedula.setText("");
        txtNombrecompleto.setText("");
        dateFechaLlegada.setDate(null);
        dateFechaSalida.setDate(null);
        lblNombrehabitacion.setText("NOMBRE HABITACION");
        lblValor.setText("VALOR");
        lblDescripcion.setText("");
        cbxHabitacion.setSelectedIndex(0);
    }

    private void imprimir(String v) {
        JOptionPane.showMessageDialog(null, v);
    }

    private void llenarComboBox() {
        cbxHabitacion.setModel(controlador.llenarComboBox());
    }

    private void asignarFechaHoy() {

        Calendar hoy = new GregorianCalendar();
        dateFechaHoy.setCalendar(hoy);
        fechaMinima();
    }

    private void fechaMinima() {
        Date date = new Date();
        dateFechaLlegada.setMinSelectableDate(date);
        dateFechaSalida.setMinSelectableDate(date);

    }

//    private void deshabilitarRango()  {
//        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
//        try {
//            Date d1 = formatter.parse("2020-05-25");
//            Date d2 = formatter.parse("2020-05-30");
//            jCalendarFrm.setSelectableDateRange(d1, d2);
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//            imprimir(ex.getMessage());
//        }
//    }
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
            java.util.logging.Logger.getLogger(FrmReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReservacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxHabitacion;
    private com.toedter.calendar.JDateChooser dateFechaHoy;
    private com.toedter.calendar.JDateChooser dateFechaLlegada;
    private com.toedter.calendar.JDateChooser dateFechaSalida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCedulahuesped;
    private javax.swing.JTextArea lblDescripcion;
    private javax.swing.JLabel lblFechallegada;
    private javax.swing.JLabel lblFechasalida;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombrecompleto;
    private javax.swing.JLabel lblNombrehabitacion;
    private javax.swing.JLabel lblSeleccione;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValornoche;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombrecompleto;
    // End of variables declaration//GEN-END:variables
}
