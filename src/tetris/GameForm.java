/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Dimension;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John
 */
public class GameForm extends javax.swing.JFrame{
    
    private ThreadGame game;
//    Figuras num1= new FiguraO(5);
    
    public GameForm() {
        initComponents();
        this.setSize(new Dimension(670, 640));
        this.game = new ThreadGame(pnlBoard);
        this.game.start();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlBoard = new javax.swing.JPanel();
        lblNext = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblLines = new javax.swing.JLabel();
        lblLines1 = new javax.swing.JLabel();
        pnlNext1 = new javax.swing.JPanel();
        pnlNext2 = new javax.swing.JPanel();
        lblTimer = new javax.swing.JLabel();
        btnBajar = new javax.swing.JButton();
        btnDerecha = new javax.swing.JButton();
        btnIzquierda = new javax.swing.JButton();
        btnGirar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(672, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(672, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBoard.setBackground(new java.awt.Color(255, 255, 255));
        pnlBoard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout pnlBoardLayout = new javax.swing.GroupLayout(pnlBoard);
        pnlBoard.setLayout(pnlBoardLayout);
        pnlBoardLayout.setHorizontalGroup(
            pnlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        pnlBoardLayout.setVerticalGroup(
            pnlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(pnlBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 0, -1, 600));

        lblNext.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNext.setForeground(new java.awt.Color(255, 255, 255));
        lblNext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNext.setText("Siguientes piezas");
        lblNext.setToolTipText("");
        jPanel1.add(lblNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 12, 161, 34));

        lblScore.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblScore.setForeground(new java.awt.Color(255, 255, 255));
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblScore.setText("Score: 12");
        lblScore.setToolTipText("");
        jPanel1.add(lblScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 106, 109, 34));

        lblLines.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLines.setForeground(new java.awt.Color(255, 255, 255));
        lblLines.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLines.setText("Level: 1");
        lblLines.setToolTipText("");
        jPanel1.add(lblLines, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 109, 34));

        lblLines1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLines1.setForeground(new java.awt.Color(255, 255, 255));
        lblLines1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLines1.setText("Lines: 12");
        lblLines1.setToolTipText("");
        jPanel1.add(lblLines1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 169, 109, 34));

        javax.swing.GroupLayout pnlNext1Layout = new javax.swing.GroupLayout(pnlNext1);
        pnlNext1.setLayout(pnlNext1Layout);
        pnlNext1Layout.setHorizontalGroup(
            pnlNext1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );
        pnlNext1Layout.setVerticalGroup(
            pnlNext1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );

        jPanel1.add(pnlNext1, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 64, -1, -1));

        javax.swing.GroupLayout pnlNext2Layout = new javax.swing.GroupLayout(pnlNext2);
        pnlNext2.setLayout(pnlNext2Layout);
        pnlNext2Layout.setHorizontalGroup(
            pnlNext2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );
        pnlNext2Layout.setVerticalGroup(
            pnlNext2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel1.add(pnlNext2, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 224, -1, -1));

        lblTimer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(255, 255, 255));
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setText("00:00");
        lblTimer.setToolTipText("");
        jPanel1.add(lblTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 21, 93, 34));

        btnBajar.setText("Bajar");
        btnBajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBajar, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 315, -1, -1));

        btnDerecha.setText("Derecha");
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerechaActionPerformed(evt);
            }
        });
        jPanel1.add(btnDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 356, -1, -1));

        btnIzquierda.setText("Izquierda");
        btnIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzquierdaActionPerformed(evt);
            }
        });
        jPanel1.add(btnIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 397, -1, -1));

        btnGirar.setText("Girar");
        btnGirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGirarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 438, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 658, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajarActionPerformed

    }//GEN-LAST:event_btnBajarActionPerformed

    private void btnDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerechaActionPerformed
    
        
    }//GEN-LAST:event_btnDerechaActionPerformed

    private void btnIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzquierdaActionPerformed

    }//GEN-LAST:event_btnIzquierdaActionPerformed

    private void btnGirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGirarActionPerformed

    }//GEN-LAST:event_btnGirarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBajar;
    private javax.swing.JButton btnDerecha;
    private javax.swing.JButton btnGirar;
    private javax.swing.JButton btnIzquierda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLines;
    private javax.swing.JLabel lblLines1;
    private javax.swing.JLabel lblNext;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JPanel pnlBoard;
    private javax.swing.JPanel pnlNext1;
    private javax.swing.JPanel pnlNext2;
    // End of variables declaration//GEN-END:variables


}
