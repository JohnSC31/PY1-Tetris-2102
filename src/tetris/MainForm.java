/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author John
 */
public class MainForm extends javax.swing.JFrame {
    
    private MatchesForm matchesWindow;
    private RankingForm rankingWindow;
    private GameForm gameWindow;
    
    public MainForm() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        btnPlay = new javax.swing.JButton();
        btnRanking1 = new javax.swing.JButton();
        btnMatches = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        txfName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tetris");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        btnPlay.setBackground(new java.awt.Color(255, 255, 255));
        btnPlay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPlay.setText("Jugar");
        btnPlay.setEnabled(false);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 140, 30));

        btnRanking1.setBackground(new java.awt.Color(255, 255, 255));
        btnRanking1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRanking1.setText("Ranking");
        btnRanking1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRanking1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnRanking1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 140, 30));

        btnMatches.setBackground(new java.awt.Color(255, 255, 255));
        btnMatches.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMatches.setText("Partidas");
        btnMatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatchesActionPerformed(evt);
            }
        });
        jPanel1.add(btnMatches, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 140, 30));

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 140, 30));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Nombre");
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 140, -1));

        txfName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txfName.setToolTipText("");
        txfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNameActionPerformed(evt);
            }
        });
        txfName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNameKeyReleased(evt);
            }
        });
        jPanel1.add(txfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 140, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/background2.jpg"))); // NOI18N
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        this.setVisible(false);
        this.gameWindow = new GameForm();
        this.gameWindow.setVisible(true);
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnRanking1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRanking1ActionPerformed
        this.setVisible(false);
        this.rankingWindow = new RankingForm(this);
        this.rankingWindow.setVisible(true);
    }//GEN-LAST:event_btnRanking1ActionPerformed

    private void btnMatchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatchesActionPerformed
         this.setVisible(false);
        this.matchesWindow = new MatchesForm(this);
        this.matchesWindow.setVisible(true);
    }//GEN-LAST:event_btnMatchesActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void txfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNameActionPerformed

    private void txfNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNameKeyReleased
        if(!txfName.getText().equals("")){
            btnPlay.setEnabled(true);
        }else{
            btnPlay.setEnabled(false);
        }
    }//GEN-LAST:event_txfNameKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMatches;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRanking1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField txfName;
    // End of variables declaration//GEN-END:variables
}
