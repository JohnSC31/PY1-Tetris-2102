/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

// esto es un nuevo cambio
public class Board {
    //Atributos
    private static final int ROWS = 25;
    private static final int COLS = 10;
    private static final int HEIGHT = 50;
    private static final int WIDTH = 50;
    
    private int[][] board = initBoard();
    
    
    
    // Constructor
    public Board(){
        
    }
    
    //METODOS
    private int[][] initBoard(){
        int [][] board = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = 0;
            }
        }
        
        return board;
    }
    
    public void printBoard(JPanel panel){
        Graphics g = panel.getGraphics();
        int x = panel.getX();
        int y = panel.getY();
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                g.drawRect(x, y, WIDTH, HEIGHT);
                g.fillRect(240,52,52,1);
                x += WIDTH;
            }
            y += HEIGHT;
        }
    }
    
    // GETTERS AND SETTERS
}
