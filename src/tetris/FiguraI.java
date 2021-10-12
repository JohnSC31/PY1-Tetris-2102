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
public class FiguraI {
    private int fila = 0;
    private int columna;
    private String estadoLinea;

    public FiguraI(int columna) {
        
        this.columna = columna;
        
        
        
    }
    
    public static int[][] agregarFigura(int centerI, int centerJ, int rotation,  int[][] board){
       // una vez definido que el centro de la figura es la esquina inferior izquieda
       // por ser la figura en forma de O
       
       // hacer in if para cada rotacion de la figura en forma de O
       // en cada if hacer la validacion de si se puede crear la figura en ese centro y 
       // con esa rotacion especificada
       
       switch(rotation){
           case 0: //norte
                board[centerI][centerJ] = 7; // porque se agrega la figura numero 3
                board[centerI  - 1][centerJ] = 7; // esquina superior izquierda
                board[centerI + 1][centerJ] = 7; // esquina superior derecha
                board[centerI + 2][centerJ] = 7;
           case 1: //este
                board[centerI][centerJ] = 7; 
                board[centerI][centerJ + 1] = 7; 
                board[centerI][centerJ - 1] = 7; 
                board[centerI][centerJ - 2] = 7;
       }
       
       board[centerI][centerJ] = 3; // porque se agrega la figura numero 3
       board[centerI  - 1][centerJ] = 3; // esquina superior izquierda
       board[centerI - 1][centerJ + 1] = 3; // esquina superior derecha
       board[centerI][centerJ + 1] = 3; // esquina inferior derecha
        
       return board;
    }
    
    public int[][] agregarFigura(int[][] matriz){
        for (int i = fila; i < 4; i++) {
                matriz[i][columna] = 2;
               
        }
        
        estadoLinea = "VERTICAL";
        fila = 0;
        
        return matriz;
    }
    
    
    
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
