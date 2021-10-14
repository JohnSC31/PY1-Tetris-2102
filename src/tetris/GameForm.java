/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        this.game = new ThreadGame(pnlBoard, lblTimer, lblScore, lblLines, lblLevel, pnlNext1, pnlNext2);
        this.game.start();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlBoard = new javax.swing.JPanel();
        lblNext = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        lblLines = new javax.swing.JLabel();
        pnlNext1 = new javax.swing.JPanel();
        pnlNext2 = new javax.swing.JPanel();
        lblTimer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(672, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 600));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
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
            .addGap(0, 598, Short.MAX_VALUE)
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
        lblScore.setText("Puntos 0");
        lblScore.setToolTipText("");
        jPanel1.add(lblScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 106, 109, 34));

        lblLevel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLevel.setForeground(new java.awt.Color(255, 255, 255));
        lblLevel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLevel.setText("Nivel 1");
        lblLevel.setToolTipText("");
        jPanel1.add(lblLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 109, 34));

        lblLines.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLines.setForeground(new java.awt.Color(255, 255, 255));
        lblLines.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLines.setText("Lineas 0");
        lblLines.setToolTipText("");
        jPanel1.add(lblLines, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 169, 109, 34));

        javax.swing.GroupLayout pnlNext1Layout = new javax.swing.GroupLayout(pnlNext1);
        pnlNext1.setLayout(pnlNext1Layout);
        pnlNext1Layout.setHorizontalGroup(
            pnlNext1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        pnlNext1Layout.setVerticalGroup(
            pnlNext1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel1.add(pnlNext1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 150, 150));

        javax.swing.GroupLayout pnlNext2Layout = new javax.swing.GroupLayout(pnlNext2);
        pnlNext2.setLayout(pnlNext2Layout);
        pnlNext2Layout.setHorizontalGroup(
            pnlNext2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        pnlNext2Layout.setVerticalGroup(
            pnlNext2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel1.add(pnlNext2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 150, 150));

        lblTimer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(255, 255, 255));
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setText("00:00");
        lblTimer.setToolTipText("");
        jPanel1.add(lblTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 21, 93, 34));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 658, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
 
        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_W){
             game.board.rotateFigure();
        }else if(evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_S){
            game.board.fallFigure();
        }else if(evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_D){
            game.board.moveRight();
        }else if(evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_A){
            game.board.moveLeft();
        }
    }//GEN-LAST:event_formKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblLines;
    private javax.swing.JLabel lblNext;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JPanel pnlBoard;
    private javax.swing.JPanel pnlNext1;
    private javax.swing.JPanel pnlNext2;
    // End of variables declaration//GEN-END:variables


}
