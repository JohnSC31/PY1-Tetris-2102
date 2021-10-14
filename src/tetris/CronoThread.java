/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author John
 */
public class CronoThread extends Thread {
    private JLabel timeLabel;
    private boolean isRunning = true;
    private int segundos = 0;
    private int minutos = 0;
    private int gameLevel = 1;
    
    public CronoThread(JLabel timeLabel){
        this.timeLabel = timeLabel;

    }
    
    
    public void run(){
         while(isRunning){
            
            
            try {
                sleep(1000);
                
                segundos++;
                if (segundos > 59){
                    segundos = 0;
                    minutos++;
                    if(minutos > 0 && minutos % 2 == 0 && gameLevel < 10){
                        gameLevel++;
                    }
                    if(minutos > 59){
                        minutos = 0;
                    }
                }
         
                String timeStr = setNiceTime(minutos) + ":" +  setNiceTime(segundos);
                timeLabel.setText(timeStr);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(CronoThread.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
    
    
    private String setNiceTime(int number){
        if (number < 10)
            return "0"+number;
        return ""+number;
    }
    
    // GETTERS AND SETTERS

    public int getSegundos() {
        return segundos;
    }

    public int getMinutos() {
        return minutos;
    }
    
    public int getLevel(){
        return gameLevel;
    }
    
    
    
    
}
