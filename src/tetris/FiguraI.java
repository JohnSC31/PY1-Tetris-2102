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
public class FiguraI extends Figuras{
    private int fila = 0;
    private int columna;
    private String estadoLinea;

    public FiguraI(int columna) {
        super(0, columna);
        this.columna = columna;
        
        
        
    }
    
    
    
    public int[][] agregarFigura(int[][] matriz){
        for (int i = fila; i < 4; i++) {
                matriz[i][columna] = 2;
               
        }
        
        estadoLinea = "VERTICAL";
        fila = 0;
        
        return matriz;
    }
    
    
    @Override
    public int[][] moverAbajo(int[][] matriz){
        //Agregar restricciones
        
        if(estadoLinea.equals("VERTICAL")){
            //limpiar fila anterior
            matriz[fila][columna] = 0;
            matriz[fila + 4][columna] = 2;
            
        }
        
        else if(estadoLinea.equals("HORIZONTAL")){

                for (int j = columna; j < columna + 4; j++) {
                    matriz[fila][j] = 0;
                    matriz[fila + 1][j] = 2;
                }

            }
        
        fila++;
        return matriz;
    }
    
    @Override
    public int[][] moverDerecha(int[][] matriz){
        if(estadoLinea.equals("VERTICAL")){
            for (int i = fila; i < fila + 4; i++) {
                matriz[i][columna] = 0;
                matriz[i][columna + 1] = 2;
            }
        } 
        else{
           matriz[fila][columna] = 0;
           matriz[fila][columna + 4] = 2;
        }
        columna++;
        return matriz;
    }
    
    @Override
    public int[][] moverIzquierda(int[][] matriz){
        if(estadoLinea.equals("VERTICAL")){
            for (int i = fila; i < fila + 4; i++) {
                matriz[i][columna] = 0;
                matriz[i][columna - 1] = 2;
            }
        } 
        else{
           matriz[fila][columna + 3] = 0;
           matriz[fila][columna - 1] = 2;
        }
        columna--;
        return matriz;
    }
    
    @Override
    public int[][] girar(int[][] matriz){
        if(estadoLinea.equals("VERTICAL")){
            for (int i = fila; i < fila + 4; i++) { //limpirar fila anterior
                matriz[i][columna] = 0;
            }

            
            for (int j = columna - 1 ; j < columna + 3; j++) {
                matriz[fila + 2][j] = 2;
            }

          
            estadoLinea = "HORIZONTAL";
            fila += 2;
            columna--;
        }
        else{
          for (int i = columna; i < columna + 4; i++) { //limpirar fila anterior
                matriz[fila][i] = 0;
            }

            
            for (int i = fila - 2; i < fila + 2; i++) { //limpirar fila anterior
                matriz[i][columna + 1] = 2;
            }

          
            estadoLinea = "VERTICAL";
            fila -= 2;
            columna++;
        }
        return matriz;
    }
    
}
