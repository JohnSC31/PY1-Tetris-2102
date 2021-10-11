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
public class FiguraT extends Figuras{
    private int fila = 0;
    private int columna;
    private String direcT;

    public FiguraT(int columna) {
        super(0, columna);
        this.columna = columna;
        
    }
    
    @Override
    public int[][] agregarFigura(int[][] matriz){
        
        matriz[fila][columna] = 3;
        
        for (int j = columna - 1; j < columna + 2; j++) {
                matriz[fila + 1][j] = 3;
            }   
        fila++;
        direcT = "NORTE";
        
        return matriz;
    }
    
    @Override
    public int[][] moverAbajo(int[][] matriz){
        //Agregar restricciones
        switch (direcT) {
            case "NORTE":
                matriz[fila - 1][columna] = 0;
                for (int j = columna - 1; j < columna + 2; j++) {
                    matriz[fila][j] = 0;
                }
                matriz[fila][columna] = 3;
                for (int j = columna - 1; j < columna + 2; j++) {
                    matriz[fila + 1][j] = 3;
                }
                fila++;
                break;
            case "ESTE":
                matriz[fila - 1][columna] = 0;
                matriz[fila + 2][columna] = 3;
                matriz[fila ][columna + 1] = 0;
                matriz[fila + 1][columna + 1] = 3;
                fila++;
                break;
            case "SUR":
                for (int i = columna - 1; i < columna + 2; i++) {
                    matriz[fila][i] = 0;
                }   fila++;
                for (int i = columna - 1; i < columna + 2; i++) {
                    matriz[fila][i] = 3;
                }   matriz[fila+1][columna] = 3;
                break;
            case "OESTE":
                matriz[fila - 1][columna] = 0;
                matriz[fila + 2][columna] = 3;
                matriz[fila ][columna - 1] = 0;
                matriz[fila + 1][columna - 1] = 3;
                fila++;
                break;
            default:
                break;}
                
        return matriz;
       
    }
    
    @Override
    public int[][] moverDerecha(int[][] matriz){
        switch (direcT) {
            case "NORTE":
                matriz[fila - 1][columna] = 0;
                matriz[fila][columna - 1] = 0;
                matriz[fila][columna + 2] = 3;
                matriz[fila - 1][columna + 1] = 3;
                columna++;
                break;
            case "ESTE":
                for (int i = fila - 1; i < fila + 2; i++) {
                    matriz[i][columna] = 0;
                    matriz[i][columna + 1] = 3;}
                columna++;
                matriz[fila][columna + 1] = 3;
                break;
            case "SUR":
                matriz[fila][columna - 1] = 0;
                matriz[fila][columna + 2] = 3;
                matriz[fila + 1][columna + 1] = 3;
                matriz[fila + 1][columna] = 0;
                columna++;
                break;
            case "OESTE":
                for (int i = fila - 1; i < fila + 2; i++) {
                    matriz[i][columna] = 0;
                    matriz[i][columna + 1] = 3;}
                matriz[fila][columna] = 3;
                matriz[fila][columna-1] = 0;
                columna++;
                break;
            default:
                break;
        }
        return matriz;
    }
    
    @Override
    public int[][] moverIzquierda(int[][] matriz){
        switch (direcT) {
            case "NORTE":
                matriz[fila - 1][columna] = 0;
                matriz[fila][columna + 1] = 0;
                matriz[fila][columna - 2] = 3;
                matriz[fila - 1][columna - 1] = 3;
                columna--;
                break;
            case "ESTE":
                matriz[fila - 1][columna] = 0;
                matriz[fila + 1][columna] = 0;
                matriz[fila][columna + 1] = 0;
                for (int i = fila - 1; i < fila + 2; i++) {
                    matriz[i][columna - 1] = 3;}
                columna--;
                matriz[fila][columna + 1] = 3;
                break;
            case "SUR":
                matriz[fila][columna + 1] = 0;
                matriz[fila][columna - 2] = 3;
                matriz[fila + 1][columna - 1] = 3;
                matriz[fila + 1][columna] = 0;
                columna--;
                break;
            case "OESTE":
                for (int i = fila - 1; i < fila + 2; i++) {
                    matriz[i][columna] = 0;
                    matriz[i][columna - 1] = 3;}
                
                matriz[fila][columna - 2] = 3;
                columna--;
                break;
            default:
                break;
        }
        return matriz;
    }
    
    @Override
    public int[][] girar(int[][] matriz){
        switch (direcT) {
            case "NORTE":
                matriz[fila][columna -1] = 0;
                matriz[fila + 1][columna] = 3;
                direcT= "ESTE";
                break;
            case "ESTE":
                matriz[fila][columna -1] = 3;
                matriz[fila - 1][columna] = 0;
                direcT= "SUR";
                break;
            case "SUR":
                matriz[fila][columna + 1] = 0;
                matriz[fila - 1][columna] = 3;
                direcT= "OESTE";
                break;
            case "OESTE":
                matriz[fila + 1][columna] = 0;
                matriz[fila][columna + 1] = 3;
                direcT="NORTE";
                break;
            default:
                break;}
        
        return matriz;
    }
    
}
