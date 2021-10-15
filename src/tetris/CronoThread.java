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
    private Match match;
    
    public CronoThread(JLabel timeLabel, Match match){
        this.timeLabel = timeLabel;
        this.match = match;
    }
    
    
    @Override
    public void run(){
         while(isRunning){

            try {
                sleep(1000);
                
                match.setSeconds(match.getSeconds() + 1);
                if (match.getSeconds() > 59){
                    match.setSeconds(0);
                     match.setMinutes(match.getMinutes() + 1);
                    if(match.getMinutes() > 0 && match.getMinutes() % 2 == 0 && match.getLevel() < 10){
                        match.setLevel(match.getLevel() + 1);
                    }
                    if(match.getMinutes() > 59){
                        match.setMinutes(0);
                    }
                }
         
                String timeStr = setNiceTime(match.getMinutes()) + ":" +  setNiceTime(match.getSeconds());
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
        return match.getSeconds();
    }

    public int getMinutos() {
        return match.getMinutes();
    }
    
    public int getLevel(){
        return match.getLevel();
    }
    
    public void stopThread(){
        this.isRunning = false;
    }
    
    
    
    
}
