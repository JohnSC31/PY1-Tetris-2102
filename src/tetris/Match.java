/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class Match {
    private int[][] board = new int [Board.ROWS][Board.COLS];
    private int[][] boardNextFigure1 = new int[5][5];
    private int[][] boardNextFigure2 = new int[5][5];
    // puntajes
    private int level = 1;
    private int score = 0;
    private int lines = 0;
    // atributos para la figura actual
    private int currentFigure = -1;
    private int rotation = 0;
    private int centerI = 3;
    private int centerJ = 4;
    private ArrayList<Integer> queueFigures;
    // cronometro
    private int minutes = 0;
    private int seconds = 0;
    
    private String player;
    
    //fecha
    private Date matchDate;
    
    private int matchIndex;

    
    Match(String player){
        this.player = player;
        matchDate = new Date();
        this.matchIndex = -1;
        initBoards();
        initQueueFigures();
    }
    
    private void initBoards(){
        // inicializacion de la board principal
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLS; j++) {
                this.board[i][j] = 0;
            }
        }
        
        // inicializacion de las board secundarias
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.boardNextFigure1[i][j] = 0;
                this.boardNextFigure2[i][j] = 0;
            }
        }
        
    }
    
    private void initQueueFigures(){
        this.queueFigures = new ArrayList<Integer>();
        Random r = new Random();
        for(int i = 0; i < 3; i++){
            this.queueFigures.add((int)r.nextInt(7)+1);
        }
         
    }
    

    
    
    // GETTERS AND SETTERS
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level){
        this.level = level;
    }

    public int getScore() {
        return score;
    }
    
    public void setScore(int score){
        this.score = score;
    }

    public int getLines() {
        return lines;
    }
    
    public void setLines(int lines){
        this.lines = lines;
    }

    public String getPlayer() {
        return player;
    }
    
    
    public String getDate(){
        return new SimpleDateFormat("dd/MM/yyyy").format(matchDate);
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
    public void setBoardPos(int i, int j, int value){
        this.board[i][j] = value;
    }
    
    public int getBoardPos(int i, int j){
        return this.board[i][j];
    }

    public int[][] getBoardNextFigure1() {
        return boardNextFigure1;
    }

    public void setBoardNextFigure1(int[][] boardNextFigure1) {
        this.boardNextFigure1 = boardNextFigure1;
    }

    public int[][] getBoardNextFigure2() {
        return boardNextFigure2;
    }

    public void setBoardNextFigure2(int[][] boardNextFigure2) {
        this.boardNextFigure2 = boardNextFigure2;
    }

    public int getCurrentFigure() {
        return currentFigure;
    }

    public void setCurrentFigure(int currentFigure) {
        this.currentFigure = currentFigure;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getCenterI() {
        return centerI;
    }

    public void setCenterI(int centerI) {
        this.centerI = centerI;
    }

    public int getCenterJ() {
        return centerJ;
    }

    public void setCenterJ(int centerJ) {
        this.centerJ = centerJ;
    }

    public ArrayList getQueueFigures() {
        return queueFigures;
    }

    public void setQueueFigures(ArrayList queueFigures) {
        this.queueFigures = queueFigures;
    }
    
    public int getQuereFigure(int index){
        return (Integer)this.queueFigures.get(index);
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public int getMatchIndex() {
        return matchIndex;
    }

    public void setMatchIndex(int matchIndex) {
        this.matchIndex = matchIndex;
    }
    
    
    
}
