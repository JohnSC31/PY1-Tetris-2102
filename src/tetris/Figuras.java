/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author josa
 */
public abstract class Figuras {
    
    private int fila;
    private int columna;

    public Figuras(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    
    public abstract int[][] agregarFigura(int[][] matriz);
    
    public abstract int[][] moverAbajo(int[][] matriz);
    
    public abstract int[][] moverDerecha(int[][] matriz);
    
    public abstract int[][] moverIzquierda(int[][] matriz);
    
    public abstract int[][] girar(int[][] matriz);
    
}
