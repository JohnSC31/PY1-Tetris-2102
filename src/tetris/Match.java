/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;

/**
 *
 * @author John
 */
public class Match {
    private int[][] mainMatrix;
    private int[][] nextMatrix1;
    private int[][] nextMatrix2;
    // puntajes
    private int level;
    private int score;
    private int lines;
    // atributos para la figura actual
    private int currentFigure;
    private int rotation;
    private int centerI;
    private int centerJ;
    private ArrayList queueFigures;
    // cronometro
    private int minutes;
    private int seconds;
    
    private String player;
    
    Match(){
        level = 3;
        lines = 4;
        score = 10;
        player = "John";
    }
    
    
    public void print(){
        System.out.println("Mi partida" + player +" puntaje" + score);
    }

    
    
    // GETTERS AND SETTERS
    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public int getLines() {
        return lines;
    }
    
    
}
