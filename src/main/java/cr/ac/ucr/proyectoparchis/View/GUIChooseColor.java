/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cr.ac.ucr.proyectoparchis.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Allan
 */
public class GUIChooseColor extends javax.swing.JFrame 
{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIChooseColor.class.getName());

    /**
     * Creates new form GUIChooseColor
     */
    public GUIChooseColor()
    {
        initComponents();
    }// fin metodo constructor

    
    
    //este metodo permitirá que el ActionListener escuche a los botones de color
    public void setListenerColor(ActionListener controller)
    {
        this.btnBlue.addActionListener(controller);
        this.btnGreen.addActionListener(controller);
        this.btnRed.addActionListener(controller);
        this.btnYellow.addActionListener(controller);
        this.btnBack.addActionListener(controller);
    }//fin metodo setListenerColor

    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel2 = new javax.swing.JLabel();
        btnRed = new javax.swing.JButton();
        btnBlue = new javax.swing.JButton();
        btnGreen = new javax.swing.JButton();
        btnYellow = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        jLabel2.setText("Escoja color");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        btnRed.setBackground(new java.awt.Color(255, 51, 51));
        btnRed.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnRed.setText("Rojo");
        btnRed.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRedActionPerformed(evt);
            }
        });
        getContentPane().add(btnRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 80, -1));

        btnBlue.setBackground(new java.awt.Color(0, 0, 255));
        btnBlue.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnBlue.setText("Azul");
        getContentPane().add(btnBlue, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 80, -1));

        btnGreen.setBackground(new java.awt.Color(0, 255, 0));
        btnGreen.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnGreen.setForeground(new java.awt.Color(102, 102, 102));
        btnGreen.setText("Verde");
        getContentPane().add(btnGreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 80, -1));

        btnYellow.setBackground(new java.awt.Color(255, 255, 0));
        btnYellow.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnYellow.setForeground(new java.awt.Color(102, 102, 102));
        btnYellow.setText("Amarillo");
        getContentPane().add(btnYellow, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Back.jpg"))); // NOI18N
        btnBack.setActionCommand("Back");
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 50, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondo progra 4.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRedActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRedActionPerformed
    {//GEN-HEADEREND:event_btnRedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRedActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GUIChooseColor().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBlue;
    private javax.swing.JButton btnGreen;
    private javax.swing.JButton btnRed;
    private javax.swing.JButton btnYellow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}//fin clase GUIChooseColor
