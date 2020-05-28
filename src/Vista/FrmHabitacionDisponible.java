/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtlHabitacion;
import Controlador.CtlReserva;
import Modelo.Habitacion;
import Modelo.Recepcionista;

/**
 *
 * @author mateo
 */
public class FrmHabitacionDisponible extends javax.swing.JFrame {

    private final CtlReserva controlador;
    private final CtlHabitacion controladorhabitacion;
    private Recepcionista recepcionista;
    private Habitacion habitacion;

    public FrmHabitacionDisponible() {
        initComponents();
        controlador = new CtlReserva();
        controladorhabitacion = new CtlHabitacion();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    public FrmHabitacionDisponible(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
        habitacion = null;
        controlador = new CtlReserva();
        controladorhabitacion = new CtlHabitacion();
        cargarInfo(recepcionista);
        initComponents();
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
        lblCedulahuesped1 = new javax.swing.JLabel();
        dateFechaLlegada = new com.toedter.calendar.JDateChooser();
        lblCedulahuesped2 = new javax.swing.JLabel();
        dateFechaLlegada1 = new com.toedter.calendar.JDateChooser();
        jSeparator2 = new javax.swing.JSeparator();
        btnConsultar = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        lblSeleccione = new javax.swing.JLabel();
        cbxHabitacion = new javax.swing.JComboBox<>();
        lblNombrehabitacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblDescripcion = new javax.swing.JTextArea();
        lblValornoche = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        lblCedulahuesped1.setBackground(new java.awt.Color(255, 255, 255));
        lblCedulahuesped1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblCedulahuesped1.setForeground(new java.awt.Color(0, 0, 0));
        lblCedulahuesped1.setText("Fecha llegada :");

        lblCedulahuesped2.setBackground(new java.awt.Color(255, 255, 255));
        lblCedulahuesped2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblCedulahuesped2.setForeground(new java.awt.Color(0, 0, 0));
        lblCedulahuesped2.setText("Fecha salida :");

        btnConsultar.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultar.setForeground(new java.awt.Color(102, 0, 0));
        btnConsultar.setText("CONSULTAR");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblImagen.setMaximumSize(new java.awt.Dimension(4, 4));
        lblImagen.setMinimumSize(new java.awt.Dimension(4, 4));

        lblSeleccione.setBackground(new java.awt.Color(255, 255, 255));
        lblSeleccione.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblSeleccione.setForeground(new java.awt.Color(0, 0, 0));
        lblSeleccione.setText("Seleccione habitacion:");

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

        lblValor.setBackground(new java.awt.Color(255, 255, 255));
        lblValor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblValor.setForeground(new java.awt.Color(0, 0, 0));
        lblValor.setText("VALOR");
        lblValor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("HABITACIONES DISPONIBLE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCedulahuesped1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCedulahuesped2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateFechaLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateFechaLlegada1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                        .addGap(74, 74, 74)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitulo)
                        .addGap(191, 191, 191))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lblSeleccione)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNombrehabitacion)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblValornoche, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCedulahuesped1)
                            .addComponent(dateFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateFechaLlegada1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedulahuesped2)))
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeleccione)
                    .addComponent(cbxHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombrehabitacion))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblValornoche)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblValor)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        FrmMenuRecepcionista menu = new FrmMenuRecepcionista(recepcionista);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

    }//GEN-LAST:event_btnConsultarActionPerformed

    private void cbxHabitacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxHabitacionMouseClicked

    }//GEN-LAST:event_cbxHabitacionMouseClicked

    private void cbxHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxHabitacionActionPerformed
    private void cargarInfo(Recepcionista x) {
        lblCedula.setText(x.getCedula());
        lblNombre.setText(x.getNombrecompleto());

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
            java.util.logging.Logger.getLogger(FrmHabitacionDisponible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHabitacionDisponible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHabitacionDisponible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHabitacionDisponible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmHabitacionDisponible().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxHabitacion;
    private com.toedter.calendar.JDateChooser dateFechaLlegada;
    private com.toedter.calendar.JDateChooser dateFechaLlegada1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCedulahuesped1;
    private javax.swing.JLabel lblCedulahuesped2;
    private javax.swing.JTextArea lblDescripcion;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombrehabitacion;
    private javax.swing.JLabel lblSeleccione;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValornoche;
    // End of variables declaration//GEN-END:variables
}