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
public class FiguraO extends Figuras {
    private int fila = 0;
    private int columna;

    public FiguraO(int columna) {
        super(0, columna);
        this.columna = columna;
        
        
    }
    
    // A ESTA CLASE DE FIGURA NO DEBERIA DE HACERLE UN NEW POR LO TANTO EL CONSTRUCTOR NO ES
    // NECESARIO LA IDEA ES HACER SOLAMENTE UN METODO ESTATICO PARA GENERAR O BORRAR LA FIGURA X
    // CON CENTRO I,J EN LA ROTACION n
    
  
//    @Override
//    public int[][] agregarFigura(int[][] matriz){
//        
//        for (int i = 0; i < 2; i++) {
//            for (int j = columna; j < columna + 2; j++) {
//                matriz[i][j] = 1;
//            }   
//        }
//        
//        return matriz;
//    }
    
    // PRUEBAS JOHN PARA AGREGAR FIGURA
    // se coloca el metodo estatico para no tener que hacer instancia de la clase para
    // poder uilizarlo
    public static int[][] agregarFigura(int centerI, int centerJ, int rotation,  int[][] board){
       // una vez definido que el centro de la figura es la esquina inferior izquieda
       // por ser la figura en forma de O
       
       // hacer in if para cada rotacion de la figura en forma de O
       // en cada if hacer la validacion de si se puede crear la figura en ese centro y 
       // con esa rotacion especificada
       
       
       board[centerI][centerJ] = 3; // porque se agrega la figura numero 3
       board[centerI  - 1][centerJ] = 3; // esquina superior izquierda
       board[centerI - 1][centerJ + 1] = 3; // esquina superior derecha
       board[centerI][centerJ + 1] = 3; // esquina inferior derecha
        
        return board;
    }
    @Override
    public  int[][] moverAbajo(int[][] matriz){
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
