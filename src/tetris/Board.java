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
import java.util.Collections;
import java.util.HashMap;
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
        new Color(236,110,87), // 1 Pieza en J (Rojo)
        new Color(236,208,48), // 2 Pieza en L (Amarillo)
        new Color(143,206,32), // 3 Pieza en O (Verde)
        new Color(17,193,155), // 4 Pieza en S (Cyan)
        new Color(14,119,192), // 5 Pieza en Z (Azul)
        new Color(202,30,223), // 6 Pieza en T (Morado)
        new Color(223,30,141)}; // 7 Pieza en I (Rosado)
    
    private int[][] board;
    private JPanel[][] boardPanels;
    private int[][] boardNextFigure1; // la figura siguiente
    private int [][] boardNextFigure2; // la figura siguiente siguiente
    private ArrayList queueFigures;
    private int score = 0;
    private int lines = 0;
    
    // los atributos de la figura actual
    private int centerI;
    private int centerJ;
    private int rotation;
    private int currentFigure;
    
    // incorporar en la clase figura que realice Josa los atributos de la figura
    
    private final JPanel panelBoard; // el panel donde se imprime la matriz
    
    // Constructor
    public Board(JPanel pnlBoard){
        this.panelBoard = pnlBoard;
        initBoard(); // se inicializa la matriz
        initQueueFigures();
        generateNewFigure();
        printBoard(); // se imprime por primera vez la matriz
        
    }
    
    //METODOS
    private void initBoard(){
        int x = 0;
        int y = 0 -((ROWS - 20) * HEIGHT); // oculta las filas de arriba para que solo se muestren 20
        this.board = new int[ROWS][COLS];
        this.boardPanels = new JPanel[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                this.board[i][j] = 0;
                this.boardPanels[i][j] = createPanel(x, y, this.board[i][j]);
                this.panelBoard.add(this.boardPanels[i][j]);
                x += WIDTH;
            }
            x = 0;
            y += HEIGHT;
        }
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
        this.centerI = 3;
        this.centerJ = 4;
    }
    
    public void printBoard(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                this.boardPanels[i][j].setBackground(COLORS[this.board[i][j]]);
            }
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
    
    // PRUEBAS DE JOHN PARA LA IMPRESION DE LA FIGURA
    public void generateFigure(){
        switch(currentFigure){
            case 1: // se pinta la figura 1 la J
                this.board = Figuras.generateFigureJ(centerI, centerJ, rotation, this.board,1);
                break;
            
            case 2: // se pinta la figura 2 la L
                this.board = Figuras.generateFigureL(centerI, centerJ, rotation, this.board,2);
                break;    
                
            case 3: // se pinta la figura 3 la O
                this.board = Figuras.generateFigureO(centerI, centerJ, rotation, this.board,3);
                break;
            
            case 4: // se pinta la figura 4 la S
                this.board = Figuras.generateFigureS(centerI, centerJ, rotation, this.board,4);
                break; 
            
            case 5: // se pinta la figura 5 la Z
                this.board = Figuras.generateFigureZ(centerI, centerJ, rotation, this.board,5);
                break;
            
            case 6: // se pinta la figura 6 la T
                this.board = Figuras.generateFigureT(centerI, centerJ, rotation, this.board,6);
                break;
                
            case 7: // se pinta la figura 7 la I
                this.board = Figuras.generateFigureI(centerI, centerJ, rotation, this.board,7);
                break;
            
        }
        
        printBoard();
        
    }
    
    public void generateNewFigure(){
        System.out.println("Se genera una figura");
        this.currentFigure = (int)queueFigures.get(0);
        queueFigures.remove(0);
        resetFigureCenter();
        this.rotation = 0;
        Random r = new Random();
        this.queueFigures.add(r.nextInt(7)+1);
        generateFigure();
    }
    
    public void resetFigure(){
        switch(currentFigure){
            case 1: //Pieza en J
                this.board = Figuras.generateFigureJ(centerI, centerJ, rotation, this.board,0);
                break;
            case 2: //Pieza en L
                this.board = Figuras.generateFigureL(centerI, centerJ, rotation, this.board,0);
                break;
            case 3: //Pieza en O
                this.board = Figuras.generateFigureO(centerI, centerJ, rotation, this.board,0);
                break;
            case 4: //Pieza en S
                this.board = Figuras.generateFigureS(centerI, centerJ, rotation, this.board,0);
                break;
            case 5: //Pieza en Z
                this.board = Figuras.generateFigureZ(centerI, centerJ, rotation, this.board,0);
                break;
            case 6: //Pieza en T
                this.board = Figuras.generateFigureT(centerI, centerJ, rotation, this.board,0);
                break;
            case 7: //Pieza en I
                this.board = Figuras.generateFigureI(centerI, centerJ, rotation, this.board,0);
                break;

        }
        
        
    }
    
    public void fallFigure(){
        resetFigure();
        switch(currentFigure){
            case 1:
                if (Figuras.validaMovimientoFiguraJ(centerI + 1, centerJ, rotation, board)){
                    centerI++;
                }
                break;
            case 2:
                if (Figuras.validaMovimientoFiguraL(centerI + 1, centerJ, rotation, board)){
                    centerI++;
                }
                break;
            case 3:
                if (Figuras.validaMovimientoFiguraO(centerI + 1, centerJ, rotation, board)){
                    centerI++;
                }
                break;
            case 4:
                if (Figuras.validaMovimientoFiguraS(centerI + 1, centerJ, rotation, board)){
                    centerI++;
                }
                break;
            case 5:
                if (Figuras.validaMovimientoFiguraZ(centerI + 1, centerJ, rotation, board)){
                    centerI++;
                }
                break;
            case 7:
                if (Figuras.validaMovimientoFiguraI(centerI + 1, centerJ, rotation, board)){
                    centerI++;
                }
                break;
            case 6:
                if (Figuras.validaMovimientoFiguraT(centerI + 1, centerJ, rotation, board)){
                    centerI++;
                }
                break; 
        }
       generateFigure();
    }
    
    public void moveRight(){
        resetFigure();
        
        switch(currentFigure){
            case 1:
                if (Figuras.validaMovimientoFiguraJ(centerI, centerJ + 1, rotation, board)){
                    centerJ++;}
                    break;
            case 2:
                if (Figuras.validaMovimientoFiguraL(centerI, centerJ + 1, rotation, board)){
                    centerJ++;}
                    break;
            case 3:
                if (Figuras.validaMovimientoFiguraO(centerI, centerJ + 1, rotation, board)){
                    centerJ++;}
                    break;
            
            case 4:
                if (Figuras.validaMovimientoFiguraS(centerI, centerJ + 1, rotation, board)){
                    centerJ++;}
                    break;
            
            case 5:
                if (Figuras.validaMovimientoFiguraZ(centerI, centerJ + 1, rotation, board)){
                    centerJ++;}
                    break;  
                    
            case 7:
                if (Figuras.validaMovimientoFiguraI(centerI, centerJ + 1, rotation, board)){
                    centerJ++;}
                    break;
            case 6:
                if (Figuras.validaMovimientoFiguraT(centerI, centerJ + 1, rotation, board)){
                    centerJ++;}
                    break;
        }
        generateFigure();
        
    }
    
    public void moveLeft(){
        resetFigure();
        switch(currentFigure){
            case 1:
                if (Figuras.validaMovimientoFiguraJ(centerI, centerJ- 1, rotation, board)){
                    centerJ--;}
                    break;
            case 2:
                if (Figuras.validaMovimientoFiguraL(centerI, centerJ- 1, rotation, board)){
                    centerJ--;}
                    break;
            case 3:
                if (Figuras.validaMovimientoFiguraO(centerI, centerJ- 1, rotation, board)){
                    centerJ--;}
                    break;
            case 4:
                if (Figuras.validaMovimientoFiguraS(centerI, centerJ- 1, rotation, board)){
                    centerJ--;}
                    break;
            case 5:
                if (Figuras.validaMovimientoFiguraZ(centerI, centerJ- 1, rotation, board)){
                    centerJ--;}
                    break;
                    
            case 7:
                if (Figuras.validaMovimientoFiguraI(centerI, centerJ - 1, rotation, board)){
                    centerJ--;}
                    break;
            case 6:
                if (Figuras.validaMovimientoFiguraT(centerI, centerJ - 1, rotation, board)){
                    centerJ--;}
                    break;
        }
        generateFigure();
    }
    
    public void rotateFigure(){
        resetFigure();
        switch(currentFigure){
            case 1:
                if (Figuras.validaMovimientoFiguraJ(centerI, centerJ, (rotation +1) % 4, board)){
                rotation = (rotation +1) % 4;}
                break;
            case 2:
                if (Figuras.validaMovimientoFiguraL(centerI, centerJ, (rotation +1) % 4, board)){
                rotation = (rotation +1) % 4;}
                break;
            case 3: 
                break;
            case 4:
                if (Figuras.validaMovimientoFiguraS(centerI, centerJ, (rotation +1) % 4, board)){
                rotation = (rotation +1) % 4;}
                break;
            case 5:
                if (Figuras.validaMovimientoFiguraZ(centerI, centerJ, (rotation +1) % 4, board)){
                rotation = (rotation +1) % 4;}
                break;
            case 7:
                if (Figuras.validaMovimientoFiguraI(centerI, centerJ, (rotation +1) % 4, board)){
                rotation = (rotation +1) % 4;}
                break;
            case 6:
                if (Figuras.validaMovimientoFiguraT(centerI, centerJ, (rotation +1) % 4, board)){
                rotation = (rotation +1) % 4;} 
                break;
        }
        generateFigure();
    }
    
    public int eliminaLineaLlena(int[][] board){
        //retorna la cantidad de lineas que se borraron (para calcular los puntos) 
        //y se suma a la cantidad de lineas total;
        
        boolean borrar;
        int cantLineas = 0;
        for (int i = 4; i < ROWS; i++) { //empieza desde la primera fila que aparece en pantalla
            borrar = true;
            
            for (int j = 0; j < COLS; j++) {
                if(board[i][j] == 0){
                    borrar = false;
                    break;}
            }
            if (borrar){
                for (int k = i; k > 0 ; k--) { // baja todas las lineas
                    for (int l = 0; l < COLS; l++) {
                        board[k][l] = board[k-1][l];
                        }
                }
                cantLineas++;   
                }
            }
        return cantLineas;
        }
    
    
    // imprime la matriz en consola
    public void printConsoleBoard(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
   
    
    // valida si la figura actual puede seguir cayendo
    public boolean validFallFigure(){
        boolean validFall = false;
        resetFigure();
        switch(currentFigure){
            case 1:
                if (Figuras.validaMovimientoFiguraJ(centerI + 1, centerJ, rotation, board)){
                    validFall = true;
                }
                break;
            case 2:
                if (Figuras.validaMovimientoFiguraL(centerI + 1, centerJ, rotation, board)){
                    validFall = true;
                }
                break;
            case 3:
                if (Figuras.validaMovimientoFiguraO(centerI +1, centerJ, rotation, board)){
                    validFall = true;
                }
                break;
            case 4:
                if (Figuras.validaMovimientoFiguraS(centerI +1, centerJ, rotation, board)){
                    validFall = true;
                }
                break;
            case 5:
                if (Figuras.validaMovimientoFiguraZ(centerI +1, centerJ, rotation, board)){
                    validFall = true;
                }
                break;
            case 7:
                if (Figuras.validaMovimientoFiguraI(centerI + 1, centerJ, rotation, board)){
                    validFall = true;
                }
                break;
            case 6:
                if (Figuras.validaMovimientoFiguraT(centerI + 1, centerJ, rotation, board)){

                    validFall = true;
                }
                break; 
        }
        
        
        generateFigure();
        return validFall;
    }
    
    public void score(){
        int cantLineas = 0;
        boolean borrar;
        for (int i = 0; i < 25; i++) {
            borrar = true;
            for (int j = 0; j < 10; j++) {
                if(board[i][j] == 0){
                    borrar = false;
                    break;}
            }
            if (borrar){
                    for (int k = i; k > 0 ; k--) {
                        for (int l = 0; l < 10; l++) {
                            board[k][l] = board[k-1][l];
                        }}
                 cantLineas++;  
                }
            }
        score+= cantLineas;
        // actualizar las lineas y los puntos en la pantalla
    }
    
    public int resetLines(){
        int cantLineas = 0;
        boolean borrar;
        for (int i = 0; i < 25; i++) {
            borrar = true;
            for (int j = 0; j < 10; j++) {
                if(board[i][j] == 0){
                    borrar = false;
                    break;}
            }
            if (borrar){
                    for (int k = i; k > 0 ; k--) {
                        for (int l = 0; l < 10; l++) {
                            board[k][l] = board[k-1][l];
                        }}
                 cantLineas++;  
                }
            }
        return cantLineas;
        }
    
    private String[] nombres = new String[10];
    private HashMap diccionario= new HashMap();
    private ArrayList<Integer> scores = new ArrayList();
     
     public void agregaScoreARanking(String nombre, int score){
        diccionario.put(score, nombre);
        
        if (scores.isEmpty()){ // si está vacío lo agrega
            scores.add(score);
            nombres[0] = nombre;
        }
        
        else { 
            scores.add(score);
            Collections.sort(scores);
            Collections.reverse(scores);
            
            if(scores.size() > 10){//elimina el último
                scores.remove(10);}
            
            for (int i = 0; i < scores.size(); i++) {
                nombre = (String)diccionario.get(scores.get(i));
                nombres[i] = nombre;
            }
        }
           
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
    
    public boolean gameOver(){
        for(int j = 0; j < COLS; j++){
            if(board[5][j] != 0){
                return true;
            }
        }
        
        return false;
    }
    
    // GETTERS AND SETTERS
    public void setCenterI(int centerI) {
        this.centerI = centerI;
    }

    public void setCenterJ(int centerJ) {
        this.centerJ = centerJ;
    }

    public static int getROWS() {
        return ROWS;
    }

    public static int getCOLS() {
        return COLS;
    }

    public int getCenterI() {
        return centerI;
    }

    public int getCenterJ() {
        return centerJ;
    }
    
    public int getRotation(){
        return rotation;
    }
    public int getFigure(){
        return currentFigure;
    }
    
} // fin clase
