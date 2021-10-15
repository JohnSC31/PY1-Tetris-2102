/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author John
 */
public class ThreadGame extends Thread{
   
    private boolean isRunning = true;
    private boolean isPause = false;
    
    
    public Board board;
    private int level = 1;
    private CronoThread gameTimer;
    private JLabel lblLevel;
    private GameForm gameWindow;
    
    private MusicPlayer musicPlayer;
    
    // se pasan todos los componentes graficos para mostrar la informacion
    //panel principal los secundarios
    
    ThreadGame(GameForm gameWindow, JPanel pnlBoard, JLabel lblTimer, JLabel lblScore, JLabel lblLines, JLabel lblLevel, JPanel pnlNext1, JPanel pnlNext2){
        this.gameWindow = gameWindow;
        this.board = new Board(pnlBoard, pnlNext1, pnlNext2, lblScore, lblLines);
        this.lblLevel = lblLevel;
        this.gameTimer = new CronoThread(lblTimer);
        this.gameTimer.start(); // se inicia el cronometro
        musicPlayer = new MusicPlayer("./src/Media/tetris-music.wav");
    }
    
    public void run(){
        
        while(isRunning){
            try {
                
                levelUp();
                sleep(1000 - ((level - 1) * 100)); // Cambiar para los niveles
                
                if(board.validFallFigure()){
                    this.board.fallFigure();
                    
                }else{
                    board.score(); // valida el score
                    if(!board.gameOver()){
                        board.generateNewFigure();
                    }else{
                        // enviar a pantalla o imprimir mensaje de juego terminado
                        stopRunning();
                    }
                    
                }
                
                while(isPause){
                    sleep(500);
                }

            } catch (InterruptedException ex) {
                
            }
            
        }  
        
        gameOver();
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
    
    public boolean isRunning(){
        return this.isRunning;
    }
    
    // revisa y cada 2 minutos del cronometro aumenta el nivel del 1 hasta el 10 
    public void levelUp(){
        if(level != this.gameTimer.getLevel()){
            level = this.gameTimer.getLevel(); // se actualiza el nivel
            this.lblLevel.setText("Nivel " + level);
        }
        
    }

    private void gameOver() {
        this.gameTimer.stopThread();
        this.musicPlayer.getClip().stop();
        this.gameWindow.gameOverAction();
    }
}
