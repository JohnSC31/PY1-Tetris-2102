/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebamatriztetris;

/**
 *
 * @author josa
 */
public class FiguraO extends Figuras {
    private int fila = 0;
    private int columna;

    public FiguraO(int columna) {
        super(0, columna);
        this.columna = columna;
        
        
    }
    @Override
    public int[][] agregarFigura(int[][] matriz){
        
        for (int i = 0; i < 2; i++) {
            for (int j = columna; j < columna + 2; j++) {
                matriz[i][j] = 1;
            }   
        }
        
        return matriz;
    }
    
    @Override
    public int[][] moverAbajo(int[][] matriz){
        //Agregar restricciones
        
        matriz[fila][columna] = 0;
        matriz[fila][columna + 1] = 0;
        
        matriz[fila+ 2][columna] = 1;
        matriz[fila+ 2][columna + 1] = 1;
        
        fila++;
        return matriz;
    }
    
    @Override
    public int[][] moverDerecha(int[][] matriz){
        matriz[fila][columna] = 0;
        matriz[fila + 1][columna] = 0;
        
        matriz[fila][columna + 2] = 1;
        matriz[fila + 1][columna + 2] = 1;
        
        columna++;
        return matriz;
    }
    
    @Override
    public int[][] moverIzquierda(int[][] matriz){
        matriz[fila][columna + 1] = 0;
        matriz[fila + 1][columna + 1] = 0;
        
        matriz[fila][columna - 1] = 1;
        matriz[fila + 1][columna - 1] = 1;
        
        columna--;
        return matriz;
    }
    
    @Override
    public int[][] girar(int[][] matriz){
        return matriz;
    }
    
    
    
    
}
