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
public class FiguraO {
    private int fila = 0;
    private int columna;
    

    public FiguraO(int columna) {
        
        this.columna = columna;
        
        
    }
    
    // A ESTA CLASE DE FIGURA NO DEBERIA DE HACERLE UN NEW POR LO TANTO EL CONSTRUCTOR NO ES
    // NECESARIO LA IDEA ES HACER SOLAMENTE UN METODO ESTATICO PARA GENERAR O BORRAR LA FIGURA X
    // CON CENTRO I,J EN LA ROTACION n
   
    
    // PRUEBAS JOHN PARA AGREGAR FIGURA
    // se coloca el metodo estatico para no tener que hacer instancia de la clase para
    // poder uilizarlo
    public static int[][] agregarFigura(int centerI, int centerJ, int rotation,  int[][] board){
        // una vez definido que el centro de la figura es la esquina inferior izquieda
        // por ser la figura en forma de O
        // hacer in if para cada rotacion de la figura en forma de O
        // en cada if hacer la validacion de si se puede crear la figura en ese centro y
        // con esa rotacion especificada       
       if(rotation == 0 ){
           
       }
       
       board[centerI][centerJ] = 3; // porque se agrega la figura numero 3
       board[centerI  - 1][centerJ] = 3; // esquina superior izquierda
       board[centerI - 1][centerJ + 1] = 3; // esquina superior derecha
       board[centerI][centerJ + 1] = 3; // esquina inferior derecha
        
       return board;
    }
    
    public static int[][] resetFigure(int centerI, int centerJ, int rotation,int[][] board){
       
       board[centerI][centerJ] = 0; 
       board[centerI  - 1][centerJ] = 0; 
       board[centerI - 1][centerJ + 1] = 0; 
       board[centerI][centerJ + 1] = 0; 
        
        return board;
    }
    
    
    
//    public static int[][] fallFigure(Board board1, int rotation){
////        int [][] board = board1.getBoard();
//        
//        int centerI = board1.getCenterI();
//        int centerJ = board1.getCenterJ();
//        
//        if(centerI + 1 < board1.getROWS() && board[centerI + 1][centerJ] == 0 && board[centerI + 1][centerJ+1] == 0 ){
//            board = resetFigure(centerI,centerJ, rotation, board);
//        
//            board = agregarFigura(centerI+1,centerJ, rotation, board);
//        
//            board1.setCenterI(centerI + 1); }
//        
//        return board;
//    }
    
    
//    public static int[][] moveRight(Board board1, int rotation){
////        int [][] board = board1.getBoard();
//        
//        int centerI = board1.getCenterI();
//        int centerJ = board1.getCenterJ();
//        
//        if(centerI + 1 < board1.getROWS() && centerJ + 2 < board1.getCOLS() && board[centerI][centerJ+2] == 0 ){
//            board = resetFigure(centerI, centerJ, rotation, board);
//        
//            board = agregarFigura(centerI, centerJ + 1, rotation, board);
//            
//            board1.setCenterJ(centerJ + 1); }
//        
//        
//        return board; 
//    }
    
    
//    public static int[][] moveLeft(Board board1, int rotation){
//        int [][] board = board1.getBoard();
//        
//        int centerI = board1.getCenterI();
//        int centerJ = board1.getCenterJ();
//        
//        if(centerI + 1 < board1.getROWS() && centerJ - 1 >= 0 && board[centerI][centerJ - 1] == 0 ){
//            board = resetFigure(centerI, centerJ, rotation, board);
//        
//            board = agregarFigura(centerI, centerJ - 1, rotation, board);
//            board1.setCenterJ(centerJ + -1);}
//        
//        
//        return board; 
//    }
    
    
//    public static int[][] girar(Board board1, int rotation){
//        int [][] board = board1.getBoard();
//        return board; 
//    }

    
    
    
    
    
    
    
    
}
