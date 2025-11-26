/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package cr.ac.ucr.proyectoparchis.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Allan
 */
public class PanelButtons extends javax.swing.JPanel 
{

    /** Creates new form PanelButtons */
    public PanelButtons() 
    {
        initComponents();
    }// constructor
    
    //Lo primero, que el ActionListener escuche los botones
    
    public void setListenerMenu(ActionListener controller)
    {
        this.btnColor.addActionListener(controller);
        this.btnCredits.addActionListener(controller);
        this.btnHistory.addActionListener(controller);
        this.btnInstructions.addActionListener(controller);
        this.btnPlay.addActionListener(controller);
        this.btnSonido.addActionListener(controller);
    }//fin metodo setListener
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnColor = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        btnInstructions = new javax.swing.JButton();
        btnCredits = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnSonido = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnColor.setBackground(new java.awt.Color(255, 255, 255));
        btnColor.setFont(new java.awt.Font("Ravie", 0, 12)); // NOI18N
        btnColor.setForeground(new java.awt.Color(255, 0, 0));
        btnColor.setText("Selecionar color");
        btnColor.setActionCommand("color");
        btnColor.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnColorActionPerformed(evt);
            }
        });
        add(btnColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 30));

        btnHistory.setBackground(new java.awt.Color(255, 255, 255));
        btnHistory.setFont(new java.awt.Font("Ravie", 0, 12)); // NOI18N
        btnHistory.setForeground(new java.awt.Color(204, 204, 0));
        btnHistory.setText("Historia");
        btnHistory.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnHistoryActionPerformed(evt);
            }
        });
        add(btnHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 160, 30));

        btnInstructions.setBackground(new java.awt.Color(255, 255, 255));
        btnInstructions.setFont(new java.awt.Font("Ravie", 0, 12)); // NOI18N
        btnInstructions.setForeground(new java.awt.Color(0, 0, 255));
        btnInstructions.setText("Instrucciones");
        add(btnInstructions, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 160, 30));

        btnCredits.setBackground(new java.awt.Color(255, 255, 255));
        btnCredits.setFont(new java.awt.Font("Ravie", 0, 12)); // NOI18N
        btnCredits.setForeground(new java.awt.Color(0, 153, 0));
        btnCredits.setText("Créditos");
        btnCredits.setActionCommand("Creditos");
        add(btnCredits, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 160, 30));

        btnPlay.setBackground(new java.awt.Color(0, 102, 0));
        btnPlay.setFont(new java.awt.Font("Ravie", 0, 12)); // NOI18N
        btnPlay.setForeground(new java.awt.Color(255, 255, 255));
        btnPlay.setText("Jugar");
        btnPlay.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPlayActionPerformed(evt);
            }
        });
        add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 100, 50));

        btnSonido.setBackground(new java.awt.Color(153, 255, 255));
        btnSonido.setForeground(new java.awt.Color(0, 0, 0));
        btnSonido.setText("Sonido");
        btnSonido.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSonidoActionPerformed(evt);
            }
        });
        add(btnSonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 233, 90, 40));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 280));
    }// </editor-fold>//GEN-END:initComponents

    private void btnColorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnColorActionPerformed
    {//GEN-HEADEREND:event_btnColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnColorActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHistoryActionPerformed
    {//GEN-HEADEREND:event_btnHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPlayActionPerformed
    {//GEN-HEADEREND:event_btnPlayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnSonidoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSonidoActionPerformed
    {//GEN-HEADEREND:event_btnSonidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSonidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColor;
    private javax.swing.JButton btnCredits;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnInstructions;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnSonido;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    

}
