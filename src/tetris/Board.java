/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// esto es un nuevo cambio
public class Board extends JPanel{
    //Atributos
    public static final int ROWS = 25;
    public static final int COLS = 10;
    public static final int HEIGHT = 30;
    public static final int WIDTH = 30;
    
    // Definicion de los colores por tipo de pieza
    private static final Color COLORS[] = {
        new Color(0,0,0), // 0 Celda en blanco sin ningun valor
        new Color(236,110,87), // 1 Pieza en J
        new Color(236,208,48), // 2 Pieza en L
        new Color(143,206,32), // 3 Pieza en O
        new Color(17,193,155), // 4 Pieza en S
        new Color(14,119,192), // 5 Pieza en Z
        new Color(202,30,223), // 6 Pieza en T
        new Color(223,30,141)}; // 7 Pieza en I
    
    private int[][] board = initBoard();
    
    private final JPanel panelBoard; // el panel donde se imprime la matriz
    
    
    
    // Constructor
    public Board(JPanel pnlBoard){
        this.panelBoard = pnlBoard;
        this.board = initBoard(); // se inicializa la matriz
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
    
    public void printBoard(){
        int x = 0;
        int y = 0 -((ROWS - 20) * HEIGHT); // oculta las filas de arriba para que solo se muestren 20
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                panelBoard.add(createPanel(x, y, this.board[i][j]));
                x += WIDTH;
            }
            x = 0;
            y += HEIGHT;
        }
    }
    
    private JPanel createPanel(int x , int y, int value){
        JPanel panel = new JPanel();
        panel.setBackground(COLORS[value]);
        panel.setSize(WIDTH , HEIGHT);
        panel.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        panel.setLocation(x, y);      
        return panel;
    
    }
    
    // GETTERS AND SETTERS
}
