/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author John
 */
public class MatchesForm extends javax.swing.JFrame {
    
    private MainForm mainWindow;
    private ArrayList<Match> matchList;
    private ArrayList<Match> newMatchList;
    private Gson gson = new Gson();
    private final String MATCHFILEPATH = "./src/Data/Matches.txt";
    
    /**
     * Creates new form Matches
     */
    public MatchesForm(MainForm mainWindow) {
        initComponents();
        this.mainWindow = mainWindow;
        this.matchList = new ArrayList<>();
        
        Match myMatch = new Match();
        
        this.matchList.add(myMatch);
        String representacionJSON = gson.toJson(matchList);
        System.out.println(representacionJSON);
        FileManager.writeToFile(MATCHFILEPATH, representacionJSON);
        
        
        loadMatches();
        
    }

    
    private void loadMatches(){
        String matchesStr = FileManager.readFile(MATCHFILEPATH);
        if(matchesStr != ""){
                this.newMatchList = gson.fromJson(matchesStr, new TypeToken<ArrayList<Match>>(){}.getType()); // se carga la lista de partidas
        }
        
        for(int i = 0; i < newMatchList.size(); i++){
            newMatchList.get(i).print();
        }
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
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
    // End of variables declaration//GEN-END:variables
}
