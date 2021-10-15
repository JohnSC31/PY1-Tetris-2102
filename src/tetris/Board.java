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
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


// esto es un nuevo cambio
public class Board extends JPanel{
    //Atributos
    public static final int ROWS = 25;
    public static final int COLS = 10;
    public static final int HEIGHT = 30;
    public static final int WIDTH = 30;
    // atributos para los paneles de las siguientes figuras
    
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
    private JPanel[][] boardNextFigure1Panels;
    private JPanel[][] boardNextFigure2Panels;
    private ArrayList queueFigures;
    private int score = 0;
    private int lines = 0;
    
    // los atributos de la figura actual
    private int centerI;
    private int centerJ;
    private int rotation;
    private int currentFigure;
    
    private final JPanel panelBoard; // el panel donde se imprime la matriz
    private final JPanel panelNext1;
    private final JPanel panelNext2;
    private final JLabel labelScore;
    private final JLabel labelLines;
    private Match match;
    
    // Constructor
    public Board(JPanel pnlBoard, JPanel pnlNext1, JPanel pn1Next2, JLabel lblScore, JLabel lblLines, Match match){
        this.panelBoard = pnlBoard;
        this.panelNext1 = pnlNext1;
        this.panelNext2 = pn1Next2;
        this.labelScore = lblScore;
        this.labelLines = lblLines;
        this.match = match;
        initBoard(); // se inicializa la matriz
        initScores();
        if(match.getCurrentFigure() == -1){
            generateNewFigure();
        }
        
        printBoard(); // se imprime por primera vez la matriz
        
    }
    
    //METODOS
    private void initBoard(){
        int x = 0;
        int y = 0 -((ROWS - 20) * HEIGHT); // oculta las filas de arriba para que solo se muestren 20
        this.boardPanels = new JPanel[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                this.boardPanels[i][j] = createPanel(x, y, this.match.getBoard()[i][j]);
                this.panelBoard.add(this.boardPanels[i][j]);
                x += WIDTH;
            }
            x = 0;
            y += HEIGHT;
        }
        
        // inicializacion de las matrices para las siguientes figuras
        y = 0;
        x = 0;
        
        this.boardNextFigure1Panels = new JPanel[5][5];
        this.boardNextFigure2Panels = new JPanel[5][5];
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.boardNextFigure1Panels[i][j] = createPanel(x, y, this.match.getBoardNextFigure1()[i][j]);
                this.panelNext1.add(this.boardNextFigure1Panels[i][j]);
                
                this.boardNextFigure2Panels[i][j] = createPanel(x, y, this.match.getBoardNextFigure2()[i][j]);
                this.panelNext2.add(this.boardNextFigure2Panels[i][j]);
                
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
    
    private void resetFigureCenter(){
        this.match.setCenterI(3);
        this.match.setCenterJ(4);
    }
    
    private void initScores(){
        this.labelLines.setText("Lineas " + match.getLines());
        this.labelScore.setText("Puntos " + match.getScore());
    }
    
    public void printBoard(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                this.boardPanels[i][j].setBackground(COLORS[this.match.getBoardPos(i, j)]);
            }
        }
        panelBoard.repaint(); // vuelve a pintar el panel
    }
    
    private void printNextBoards(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.boardNextFigure1Panels[i][j].setBackground(COLORS[this.match.getBoardNextFigure1()[i][j]]);
                this.boardNextFigure2Panels[i][j].setBackground(COLORS[this.match.getBoardNextFigure2()[i][j]]);
            }
        }
        panelNext1.repaint(); // vuelve a pintar el panel
        panelNext2.repaint();
    }
    
    public void generateFigure(){
        switch(this.match.getCurrentFigure()){
            case 1: // se pinta la figura 1 la J
                this.match.setBoard(Figuras.generateFigureJ(match.getCenterI(), match.getCenterJ(), match.getRotation(), this.match.getBoard(),1));
                break;
            
            case 2: // se pinta la figura 2 la L
                this.match.setBoard(Figuras.generateFigureL(match.getCenterI(), match.getCenterJ(), match.getRotation(), this.match.getBoard(),2));
                break;    
                
            case 3: // se pinta la figura 3 la O
                this.match.setBoard(Figuras.generateFigureO(match.getCenterI(), match.getCenterJ(), match.getRotation(), this.match.getBoard(),3));
                break;
            
            case 4: // se pinta la figura 4 la S
                this.match.setBoard(Figuras.generateFigureS(match.getCenterI(), match.getCenterJ(), match.getRotation(), this.match.getBoard(),4));
                break; 
            
            case 5: // se pinta la figura 5 la Z
                this.match.setBoard(Figuras.generateFigureZ(match.getCenterI(), match.getCenterJ(), match.getRotation(), this.match.getBoard(),5));
                break;
            
            case 6: // se pinta la figura 6 la T
                this.match.setBoard(Figuras.generateFigureT(match.getCenterI(), match.getCenterJ(), match.getRotation(), this.match.getBoard(),6));
                break;
                
            case 7: // se pinta la figura 7 la I
                this.match.setBoard(Figuras.generateFigureI(match.getCenterI(), match.getCenterJ(), match.getRotation(), this.match.getBoard(),7));
                break;
            
        }
        
        printBoard();
        
    }
    
    public void generateNextFigure(int figure, int nextFigure){
        switch(figure){
            case 1: //Pieza en J
                if(nextFigure == 1)
                    match.setBoardNextFigure1(Figuras.generateFigureJ(2, 2, 0, match.getBoardNextFigure1(),1));
                else
                    match.setBoardNextFigure2(Figuras.generateFigureJ(2, 2, 0, match.getBoardNextFigure2(),1));
                break;
            case 2: //Pieza en L
                if(nextFigure == 1)
                    match.setBoardNextFigure1(Figuras.generateFigureL(2, 2, 0, match.getBoardNextFigure1(),2));
                else
                    match.setBoardNextFigure2(Figuras.generateFigureL(2, 2, 0, match.getBoardNextFigure2(),2));
                break;
            case 3: //Pieza en 2
                if(nextFigure == 1)
                    match.setBoardNextFigure1(Figuras.generateFigureO(2, 2, 0, match.getBoardNextFigure1(),3));
                else
                    match.setBoardNextFigure2(Figuras.generateFigureO(2, 2, 0, match.getBoardNextFigure2(),3));
                break;
            case 4: //Pieza en S
                if(nextFigure == 1)
                    match.setBoardNextFigure1(Figuras.generateFigureS(2, 2, 0, match.getBoardNextFigure1(),4));
                else
                    match.setBoardNextFigure2(Figuras.generateFigureS(2, 2, 0, match.getBoardNextFigure2(),4));
                break;
            case 5: //Pieza en Z
                if(nextFigure == 1)
                    match.setBoardNextFigure1(Figuras.generateFigureZ(2, 2, 0, match.getBoardNextFigure1(),5));
                else
                    match.setBoardNextFigure2(Figuras.generateFigureZ(2, 2, 0, match.getBoardNextFigure2(),5));
                break;
            case 6: //Pieza en T
                if(nextFigure == 1)
                    match.setBoardNextFigure1(Figuras.generateFigureT(2, 2, 0, match.getBoardNextFigure1(),6));
                else
                    match.setBoardNextFigure2(Figuras.generateFigureT(2, 2, 0, match.getBoardNextFigure2(),6));
                break;
            case 7: //Pieza en I
                if(nextFigure == 1)
                    match.setBoardNextFigure1(Figuras.generateFigureI(2, 2, 0, match.getBoardNextFigure1(),7));
                else
                    match.setBoardNextFigure2(Figuras.generateFigureI(2, 2, 0, match.getBoardNextFigure2(),7));
                break;
            
        } 
    }
    
    public void generateNewFigure(){
        match.setCurrentFigure(match.getQuereFigure(0));
        // se eliminan las figuras siguientes
        resetNextFigure(match.getCurrentFigure(), 1);
        resetNextFigure((int)match.getQueueFigures().get(1), 2);
        match.getQueueFigures().remove(0);
        resetFigureCenter();
        match.setRotation(0);
        Random r = new Random();
        match.getQueueFigures().add(r.nextInt(7)+1);
        // se generan las figuras siguientes y se pintan en los paneles
        generateNextFigure((int)match.getQueueFigures().get(0), 1);
        generateNextFigure((int)match.getQueueFigures().get(1), 2);
        printNextBoards();
        
        // se genera la figura en el panel principal
        generateFigure();
    }
    
<<<<<<< HEAD
    private void resetFigure(){
        switch(currentFigure){
=======
    public void resetFigure(){
        switch(match.getCurrentFigure()){
>>>>>>> development
            case 1: //Pieza en J
                match.setBoard(Figuras.generateFigureJ(match.getCenterI(), match.getCenterJ(), match.getRotation(), match.getBoard(),0));
                break;
            case 2: //Pieza en L
                match.setBoard(Figuras.generateFigureL(match.getCenterI(), match.getCenterJ(), match.getRotation(), match.getBoard(),0));
                break;
            case 3: //Pieza en O
                match.setBoard(Figuras.generateFigureO(match.getCenterI(), match.getCenterJ(), match.getRotation(), match.getBoard(),0));
                break;
            case 4: //Pieza en S
                match.setBoard(Figuras.generateFigureS(match.getCenterI(), match.getCenterJ(), match.getRotation(), match.getBoard(),0));
                break;
            case 5: //Pieza en Z
                match.setBoard(Figuras.generateFigureZ(match.getCenterI(), match.getCenterJ(), match.getRotation(), match.getBoard(),0));
                break;
            case 6: //Pieza en T
                match.setBoard(Figuras.generateFigureT(match.getCenterI(), match.getCenterJ(), match.getRotation(), match.getBoard(),0));
                break;
            case 7: //Pieza en I
                match.setBoard(Figuras.generateFigureI(match.getCenterI(), match.getCenterJ(), match.getRotation(), match.getBoard(),0));
                break;

        }
        
        
    }
    
    private void resetNextFigure(int figure, int nextFigure){

        switch(figure){
            case 1: //Pieza en J
                if(nextFigure == 1)
                    match.setBoardNextFigure1(Figuras.generateFigureJ(2, 2, 0, match.getBoardNextFigure1(),0));
                else
                    match.setBoardNextFigure2(Figuras.generateFigureJ(2, 2, 0, match.getBoardNextFigure2(),0));
                break;
            case 2: //Pieza en L
                 if(nextFigure == 1)
                    match.setBoardNextFigure1(Figuras.generateFigureL(2, 2, 0, match.getBoardNextFigure1(),0));
                else
                    match.setBoardNextFigure2(Figuras.generateFigureL(2, 2, 0, match.getBoardNextFigure2(),0));
                break;
            case 3: //Pieza en 2
                 if(nextFigure == 1)
                    match.setBoardNextFigure1(Figuras.generateFigureO(2, 2, 0, match.getBoardNextFigure1(),0));
                else
                    match.setBoardNextFigure2(Figuras.generateFigureO(2, 2, 0, match.getBoardNextFigure2(),0));
                break;
            case 4: //Pieza en S
                 if(nextFigure == 1)
                    match.setBoardNextFigure1(Figuras.generateFigureS(2, 2, 0, match.getBoardNextFigure1(),0));
                else
                    match.setBoardNextFigure2(Figuras.generateFigureS(2, 2, 0, match.getBoardNextFigure2(),0));
                break;
            case 5: //Pieza en Z
                 if(nextFigure == 1)
                    match.setBoardNextFigure1(Figuras.generateFigureZ(2, 2, 0, match.getBoardNextFigure1(),0));
                else
                    match.setBoardNextFigure2(Figuras.generateFigureZ(2, 2, 0, match.getBoardNextFigure2(),0));
                break;
            case 6: //Pieza en T
                 if(nextFigure == 1)
                    match.setBoardNextFigure1(Figuras.generateFigureT(2, 2, 0, match.getBoardNextFigure1(),0));
                else
                    match.setBoardNextFigure2(Figuras.generateFigureT(2, 2, 0, match.getBoardNextFigure2(),0));
                break;
            case 7: //Pieza en I
                 if(nextFigure == 1)
                    match.setBoardNextFigure1(Figuras.generateFigureI(2, 2, 0, match.getBoardNextFigure1(),0));
                else
                    match.setBoardNextFigure2(Figuras.generateFigureI(2, 2, 0, match.getBoardNextFigure2(),0));
                break;
        }
 
    }
    
    public void fallFigure(){
        resetFigure();
        switch(match.getCurrentFigure()){
            case 1:
                if (Figuras.validaMovimientoFiguraJ(match.getCenterI() + 1, match.getCenterJ(), match.getRotation(), match.getBoard())){
                    match.setCenterI(match.getCenterI() + 1);
                }
                break;
            case 2:
                if (Figuras.validaMovimientoFiguraL(match.getCenterI() + 1, match.getCenterJ(),  match.getRotation(), match.getBoard())){
                    match.setCenterI(match.getCenterI() + 1);
                }
                break;
            case 3:
                if (Figuras.validaMovimientoFiguraO(match.getCenterI() + 1, match.getCenterJ(),  match.getRotation(), match.getBoard())){
                    match.setCenterI(match.getCenterI() + 1);
                }
                break;
            case 4:
                if (Figuras.validaMovimientoFiguraS(match.getCenterI() + 1, match.getCenterJ(),  match.getRotation(), match.getBoard())){
                    match.setCenterI(match.getCenterI() + 1);
                }
                break;
            case 5:
                if (Figuras.validaMovimientoFiguraZ(match.getCenterI() + 1, match.getCenterJ(),  match.getRotation(), match.getBoard())){
                    match.setCenterI(match.getCenterI() + 1);
                }
                break;
            case 7:
                if (Figuras.validaMovimientoFiguraI(match.getCenterI() + 1, match.getCenterJ(),  match.getRotation(), match.getBoard())){
                    match.setCenterI(match.getCenterI() + 1);
                }
                break;
            case 6:
                if (Figuras.validaMovimientoFiguraT(match.getCenterI() + 1, match.getCenterJ(),  match.getRotation(), match.getBoard())){
                    match.setCenterI(match.getCenterI() + 1);
                }
                break; 
        }
       generateFigure();
    }
    
    public void moveRight(){
        resetFigure();
        
        switch(match.getCurrentFigure()){
            case 1:
                if (Figuras.validaMovimientoFiguraJ(match.getCenterI(), match.getCenterJ() + 1, match.getRotation(), match.getBoard())){
                    match.setCenterJ(match.getCenterJ() + 1);}
                    break;
            case 2:
                if (Figuras.validaMovimientoFiguraL(match.getCenterI(), match.getCenterJ() + 1, match.getRotation(), match.getBoard())){
                    match.setCenterJ(match.getCenterJ() + 1);}
                    break;
            case 3:
                if (Figuras.validaMovimientoFiguraO(match.getCenterI(), match.getCenterJ() + 1, match.getRotation(), match.getBoard())){
                    match.setCenterJ(match.getCenterJ() + 1);}
                    break;
            
            case 4:
                if (Figuras.validaMovimientoFiguraS(match.getCenterI(), match.getCenterJ() + 1, match.getRotation(), match.getBoard())){
                    match.setCenterJ(match.getCenterJ() + 1);}
                    break;
            
            case 5:
                if (Figuras.validaMovimientoFiguraZ(match.getCenterI(), match.getCenterJ() + 1, match.getRotation(), match.getBoard())){
                    match.setCenterJ(match.getCenterJ() + 1);}
                    break;  
                    
            case 7:
                if (Figuras.validaMovimientoFiguraI(match.getCenterI(), match.getCenterJ() + 1, match.getRotation(), match.getBoard())){
                    match.setCenterJ(match.getCenterJ() + 1);}
                    break;
            case 6:
                if (Figuras.validaMovimientoFiguraT(match.getCenterI(), match.getCenterJ() + 1, match.getRotation(), match.getBoard())){
                    match.setCenterJ(match.getCenterJ() + 1);}
                    break;
        }
        generateFigure();
        
    }
    
    public void moveLeft(){
        resetFigure();
        switch(match.getCurrentFigure()){
            case 1:
                if (Figuras.validaMovimientoFiguraJ(match.getCenterI(), match.getCenterJ()- 1, match.getRotation(), match.getBoard())){
                    match.setCenterJ(match.getCenterJ() - 1);}
                    break;
            case 2:
                if (Figuras.validaMovimientoFiguraL(match.getCenterI(), match.getCenterJ()- 1, match.getRotation(), match.getBoard())){
                    match.setCenterJ(match.getCenterJ() - 1);}
                    break;
            case 3:
                if (Figuras.validaMovimientoFiguraO(match.getCenterI(), match.getCenterJ()- 1, match.getRotation(), match.getBoard())){
                    match.setCenterJ(match.getCenterJ() - 1);}
                    break;
            case 4:
                if (Figuras.validaMovimientoFiguraS(match.getCenterI(), match.getCenterJ()- 1, match.getRotation(), match.getBoard())){
                    match.setCenterJ(match.getCenterJ() - 1);}
                    break;
            case 5:
                if (Figuras.validaMovimientoFiguraZ(match.getCenterI(), match.getCenterJ()- 1, match.getRotation(), match.getBoard())){
                    match.setCenterJ(match.getCenterJ() - 1);}
                    break;
                    
            case 7:
                if (Figuras.validaMovimientoFiguraI(match.getCenterI(), match.getCenterJ()- 1, match.getRotation(), match.getBoard())){
                    match.setCenterJ(match.getCenterJ() - 1);}
                    break;
            case 6:
                if (Figuras.validaMovimientoFiguraT(match.getCenterI(), match.getCenterJ()- 1, match.getRotation(), match.getBoard())){
                    match.setCenterJ(match.getCenterJ() - 1);}
                    break;
        }
        generateFigure();
    }
    
    public void rotateFigure(){
        resetFigure();
        switch(match.getCurrentFigure()){
            case 1:
                if (Figuras.validaMovimientoFiguraJ(match.getCenterI(), match.getCenterJ(), (match.getRotation() +1) % 4, match.getBoard())){
                match.setRotation((match.getRotation() + 1) % 4);}
                break;
            case 2:
                if (Figuras.validaMovimientoFiguraL(match.getCenterI(), match.getCenterJ(), (match.getRotation() +1) % 4, match.getBoard())){
                match.setRotation((match.getRotation() + 1) % 4);}
                break;
            case 3: 
                break;
            case 4:
                if (Figuras.validaMovimientoFiguraS(match.getCenterI(), match.getCenterJ(), (match.getRotation() +1) % 4, match.getBoard())){
                match.setRotation((match.getRotation() + 1) % 4);}
                break;
            case 5:
                if (Figuras.validaMovimientoFiguraZ(match.getCenterI(), match.getCenterJ(), (match.getRotation() +1) % 4, match.getBoard())){
                match.setRotation((match.getRotation() + 1) % 4);}
                break;
            case 7:
                if (Figuras.validaMovimientoFiguraI(match.getCenterI(), match.getCenterJ(), (match.getRotation() +1) % 4, match.getBoard())){
                match.setRotation((match.getRotation() + 1) % 4);}
                break;
            case 6:
                if (Figuras.validaMovimientoFiguraT(match.getCenterI(), match.getCenterJ(), (match.getRotation() +1) % 4, match.getBoard())){
                match.setRotation((match.getRotation() + 1) % 4);} 
                break;
        }
        generateFigure();
    }
    
    
    // imprime la matriz en consola
    public void printConsoleBoard(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(match.getBoard()[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
   
    
    // valida si la figura actual puede seguir cayendo
    public boolean validFallFigure(){
        boolean validFall = false;
        resetFigure();
        switch(match.getCurrentFigure()){
            case 1:
                if (Figuras.validaMovimientoFiguraJ(match.getCenterI() + 1, match.getCenterJ(), match.getRotation(), match.getBoard())){
                    validFall = true;
                }
                break;
            case 2:
                if (Figuras.validaMovimientoFiguraL(match.getCenterI() + 1, match.getCenterJ(), match.getRotation(), match.getBoard())){
                    validFall = true;
                }
                break;
            case 3:
                if (Figuras.validaMovimientoFiguraO(match.getCenterI() + 1, match.getCenterJ(), match.getRotation(), match.getBoard())){
                    validFall = true;
                }
                break;
            case 4:
                if (Figuras.validaMovimientoFiguraS(match.getCenterI() + 1, match.getCenterJ(), match.getRotation(), match.getBoard())){
                    validFall = true;
                }
                break;
            case 5:
                if (Figuras.validaMovimientoFiguraZ(match.getCenterI() + 1, match.getCenterJ(), match.getRotation(), match.getBoard())){
                    validFall = true;
                }
                break;
            case 7:
                if (Figuras.validaMovimientoFiguraI(match.getCenterI() + 1, match.getCenterJ(), match.getRotation(), match.getBoard())){
                    validFall = true;
                }
                break;
            case 6:
                if (Figuras.validaMovimientoFiguraT(match.getCenterI() + 1, match.getCenterJ(), match.getRotation(), match.getBoard())){

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
                if(match.getBoard()[i][j] == 0){
                    borrar = false;
                    break;}
            }
            if (borrar){
                    for (int k = i; k > 0 ; k--) {
                        for (int l = 0; l < 10; l++) {
                            match.setBoardPos(k, l, match.getBoard()[k-1][l]);
                        }}
                 cantLineas++;  
                }
            }

        updateScore(cantLineas);
        // actualizar las lineas y los puntos en la pantalla
    }
    
    private void updateScore(int lines){
        if(lines > 0){
            match.setLines(match.getLines() + 1);
            
            this.labelLines.setText("Lineas " + match.getLines());
            if(lines < 3){
                match.setScore(match.getScore() + lines);
                
            }else if(lines < 4){
                match.setScore(match.getScore() + 4);
                
            }else{
                match.setScore(match.getScore() + 5);
            }
            
            this.labelScore.setText("Puntos " + match.getScore());
            
        }
    }
    
<<<<<<< HEAD
=======
    public int resetLines(){
        int cantLineas = 0;
        boolean borrar;
        for (int i = 0; i < 25; i++) {
            borrar = true;
            for (int j = 0; j < 10; j++) {
                if(match.getBoard()[i][j] == 0){
                    borrar = false;
                    break;}
            }
            if (borrar){
                    for (int k = i; k > 0 ; k--) {
                        for (int l = 0; l < 10; l++) {
                           match.setBoardPos(k, l, match.getBoard()[k-1][l]);
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
            if(match.getBoard()[rowNumber][j] == 0){
                return false;
            }
        }
        
        return true;
    }
    
    private void resetFullLine(int rowNumber){
        int rowTemp = rowNumber;
        for(int j = 0; j < COLS; j++){
            if(rowNumber == 0){
                match.getBoard()[rowNumber][j] = 0;
            }else{
               while(rowTemp - 1 >= 0 && match.getBoard()[rowTemp][j] != 0){
                   match.setBoardPos(rowTemp, j, match.getBoard()[rowTemp -1][j]);
                   rowTemp--;
               }
            }
            
            rowTemp = rowNumber;
        }
    }
    
>>>>>>> development
    public boolean gameOver(){
        for(int j = 0; j < COLS; j++){
            if(match.getBoard()[5][j] != 0){
                return true;
            }
        }
        
        return false;
    }
    
    // GETTERS AND SETTERS
    public void setCenterI(int centerI) {
        this.match.setCenterI(centerI);
    }

    public void setCenterJ(int centerJ) {
        this.match.setCenterJ(centerJ);
    }

    public static int getROWS() {
        return ROWS;
    }

    public static int getCOLS() {
        return COLS;
    }

    public int getCenterI() {
        return match.getCenterI();
    }

    public int getCenterJ() {
        return match.getCenterI();
    }
    
    public int getRotation(){
        return match.getRotation();
    }
    public int getFigure(){
        return match.getCurrentFigure();
    }

    public int getScore() {
        return match.getScore();
    }
    
    
    
} // fin clase
