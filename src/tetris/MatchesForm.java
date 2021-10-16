/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author John
 */
public class MatchesForm extends javax.swing.JFrame {
    
    private MainForm mainWindow;
    private GameForm gameWindow;
    
    private ArrayList<JButton> buttons;
    private ArrayList<Match> matchList;
    
    /**
     * Creates new form Matches
     */
    public MatchesForm(MainForm mainWindow, GameForm gameWindow) {
        initComponents();
        this.mainWindow = mainWindow;
        this.gameWindow = gameWindow;
        this.matchList = new ArrayList<>();
        this.buttons = new ArrayList<>();
        
        
    }

    public void loadMatches(){
        pnlMatches.removeAll();
        this.matchList = MatchList.getMatchList();
        int x = 10;
        int y = 10;
        
        for(int i = 0; i < matchList.size(); i++){
            this.pnlMatches.add(createMatchLabel(matchList.get(i).getPlayer(), x,y, 50));
            x += 55;
            this.pnlMatches.add(createMatchLabel(matchList.get(i).getDate(), x,y, 100));
            x += 105;
            this.buttons.add(createMatchButton("Jugar", x, y, i, this));
            System.out.println("Button :" + x + ":" + y +": "+ i);
            this.pnlMatches.add(buttons.get(i));
            
            x = 10;
            y += 50;
        }
        
    }
    
    private JLabel createMatchLabel(String text, int x, int y, int width){
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, 30);
        label.setForeground(Color.WHITE);
        return label;

    } 
    
    private JButton createMatchButton(String text, int x, int y, int index, MatchesForm window){
        JButton button = new JButton(text);
        button.setBounds(x, y, 100, 30);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
                gameWindow.setFocusable(true);
                gameWindow.setVisible(true);
                gameWindow.startGame(index);
            }
        
        
        });
        return button;

    } 
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        pnlMatches = new javax.swing.JPanel();
        background = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Partidas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        btnBack.setText("Volver");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        pnlMatches.setBackground(new java.awt.Color(36, 36, 36));
        pnlMatches.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlMatches.setAutoscrolls(true);

        javax.swing.GroupLayout pnlMatchesLayout = new javax.swing.GroupLayout(pnlMatches);
        pnlMatches.setLayout(pnlMatchesLayout);
        pnlMatchesLayout.setHorizontalGroup(
            pnlMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );
        pnlMatchesLayout.setVerticalGroup(
            pnlMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        jPanel1.add(pnlMatches, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 270, 270));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/background2.jpg"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
        this.mainWindow.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlMatches;
    // End of variables declaration//GEN-END:variables
}
