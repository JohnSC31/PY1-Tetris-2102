/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import javax.swing.JPanel;

/**
 *
 * @author John
 */
public class ThreadGame extends Thread{
   
    private boolean isRunning = true;
    private boolean isPause = false;
    
    
    public Board board;
    private double level; // segundos
    
    // se pasan todos los componentes graficos para mostrar la informacion
    //panel principal los secundarios
    
    ThreadGame(JPanel pnlBoard){
        this.board = new Board(pnlBoard);
    }
    
    public void run(){
        
        while(isRunning){
            try {
                
                sleep(1000); // Cambiar para los niveles
                this.board.fallFigure();
                
                if(!board.validFallFigure()){
                    board.generateNewFigure();
                    board.score();
                }
                
                
                
                
                
                while(isPause){
                    sleep(500);
                }

            } catch (InterruptedException ex) {
                
            }
            
        }   
    }
    
    

    public void stopRunning(){
        this.isRunning = false;
    }
    
    public void pauseThread(){
        this.isPause = true;
    }
    
    public void resumeThread(){
        this.isPause = false;
    }
}
