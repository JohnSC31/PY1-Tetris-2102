/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
    
    private int[][] board;
    private int[][] boardNextFigure1; // la figura siguiente
    private int [][] boardNextFigure2; // la figura siguiente siguiente
    private ArrayList queueFigures;
    private int score = 0;
    private int lines = 0;
    
    // los centros de la figura actualmente manipulada
    private int centerI;
    private int centerJ;
    private int currentFigure;
    private int rotation;
    
    // incorporar en la clase figura que realice Josa los atributos de la figura
    
    private final JPanel panelBoard; // el panel donde se imprime la matriz
    
    // Constructor
    public Board(JPanel pnlBoard){
        this.panelBoard = pnlBoard;
        resetFigureCenter();
        
        initBoard(); // se inicializa la matriz
        initQueueFigures();
        generateNewFigure(); // genera una nueva figura
        printBoard(); // se imprime por primera vez la matriz
        
    }
    
    //METODOS
    private void initBoard(){
        this.board = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                this.board[i][j] = 0;
            }
        }
       this.board[centerI][centerJ] = 3;
    }
    
    // genera las primeras figuras
    private void initQueueFigures(){
        this.queueFigures = new ArrayList();
        Random r = new Random();
        for(int i = 0; i < 3; i++){
            this.queueFigures.add(r.nextInt(7)+1);
        }
         
    }
    
    private void resetFigureCenter(){
        this.centerI = 4;
        this.centerJ = 5;
    }
    
    public void printBoard(){
        int x = 0;
        int y = 0 -((ROWS - 20) * HEIGHT); // oculta las filas de arriba para que solo se muestren 20
        panelBoard.removeAll(); // elimina todos los elementos del panel
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                this.panelBoard.add(createPanel(x, y, this.board[i][j]));
                x += WIDTH;
            }
            x = 0;
            y += HEIGHT;
        }
        
        panelBoard.repaint(); // vuelve a pintar el panel
    }
    
    private JPanel createPanel(int x , int y, int value){
        JPanel panel = new JPanel();
        panel.setBackground(COLORS[value]);
        panel.setSize(WIDTH , HEIGHT);
        panel.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        panel.setLocation(x, y);      
        return panel;
    
    }
    
    // Genera una figura en la matriz y luego la imprime actualizada
    public void generateFigure(){
        switch (this.currentFigure) {
            case 1 -> {
                // figura en J
            }
            case 2 -> {
                // figura L
            }
            case 3 -> {
                // figura O
                // hace validfigura
                FiguraO.agregarFigura(centerI, centerJ, rotation, board);
            }
            case 4 -> {
                // figura S
            }
            case 5 -> {
                // figura Z
            }
            case 6 -> {
                // figura T
            }
            case 7 -> {
                // figura I
            }
            default -> {
            }
        }       
//        printBoard();
    }
    
    
    // toma de la cola de figuras y genera una figura nueva
    void generateNewFigure() {
        currentFigure = (int) this.queueFigures.get(0);
        this.queueFigures.remove(0);
        rotation = 0;
        Random r = new Random();
        this.queueFigures.add(r.nextInt(7)+1);
        // lama a generar figura
    }
    
    // Elimina de la matriz la figura actual
    public void resetFigure(){
        switch (this.currentFigure) {
            case 1 -> {
                // figura en J
                // se llama al metodo de generar figura con
                // centros, rotacion, figura y board
            }
            case 2 -> {
                // figura L
            }
            case 3 -> {
                // figura O
            }
            case 4 -> {
                 // figura S
            }
            case 5 -> {
                // figura Z
            }
            case 6 -> {
                 // figura T
            }
            case 7 -> {
                // figura I
            }
            default -> {
            }
        }
        
    }
    
    // imprime la matriz en consola
    private void printConsoleBoard(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public void fallFigure(){ 
       if(true){ // validacion para bajar el centro actual con la figura y rotacion actual
          resetFigure();
          centerI += 1;
          generateFigure();
       }
    }
    
    // valida si la figura actual puede seguir cayendo
    public boolean validFallFigure(){
        switch (this.currentFigure) {
            case 1 -> {
                // figura en J
            }
            case 2 -> {
                // figura L
            }
            case 3 -> {
                // figura O
                // validar la figura
                // resetamos la figura actual
                //FiguraO.validFigure(centerI + 1, centerJ, rotation, board);
                // si se puede se pinta con nuevo centro
                // si no se queda igual
            }
            case 4 -> {
                // figura S
            }
            case 5 -> {
                // figura Z
            }
            case 6 -> {
                // figura T
            }
            case 7 -> {
                // figura I
            }
            default -> {
            }
        } 
        
        return true;
    }
    
    public void moveLeftFigure(){
        
    }
    
    public void moveRightFigure(){
        
    }
    
    public void score(){
        int linesInRow = 0;
        for(int i = ROWS; i > 0; i--){
            // Realiza un recorrido de abajo hacia arriba para las columnas
            if(validFullLine(i)){
                resetFullLine(i);
                linesInRow++;
            }
        }
        lines += linesInRow;
        if(linesInRow > 2){
            
            this.score += linesInRow == 3 ? 4: 5; // sumara 4 puntos en caso de hacer 3 en linea, 5 si hace 4 o mas
        }else{
            score += linesInRow;
        }
        
        // actualizar las lineas y los puntos en la pantalla
    }
    
    private boolean validFullLine(int rowNumber){
        for(int j = 0; j < COLS; j++){
            if(board[rowNumber][j] == 0){
                return false;
            }
        }
        
        return true;
    }
    
    private void resetFullLine(int rowNumber){
        int rowTemp = rowNumber;
        for(int j = 0; j < COLS; j++){
            if(rowNumber == 0){
                board[rowNumber][j] = 0;
            }else{
               while(rowTemp - 1 >= 0 && board[rowTemp][j] != 0){
                   board[rowTemp][j] = board[rowTemp -1][j];
                   rowTemp--;
               }
            }
            
            rowTemp = rowNumber;
        }
    }
    
} // fin clase
