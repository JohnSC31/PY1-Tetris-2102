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
public class Figuras {
    
    int ROWS = Board.ROWS;
    int COLS = Board.COLS;
    
    public static int[][] generateFigureO(int centerI, int centerJ, int rotation,  int[][] board, int figure){
       // una vez definido que el centro de la figura es la esquina inferior izquieda
       // por ser la figura en forma de O
       
       // hacer in if para cada rotacion de la figura en forma de O
       // en cada if hacer la validacion de si se puede crear la figura en ese centro y 
       // con esa rotacion especificada
       
       
       board[centerI][centerJ] = figure; // porque se agrega la figura numero 3
       board[centerI  - 1][centerJ] = figure; // esquina superior izquierda
       board[centerI - 1][centerJ + 1] = figure; // esquina superior derecha
       board[centerI][centerJ + 1] = figure; // esquina inferior derecha
        
       return board;
    }
    
    public static boolean validaMovimientoFiguraO(int centerI, int centerJ, int rotation,  int[][] board){
        int rows = Board.ROWS;
        int cols = Board.COLS;
        return (centerI < rows )
                && (centerJ >= 0)
                && (centerJ < cols)
                && board[centerI][centerJ] == 0;
        
    }
    
    public static int[][] generateFigureI(int centerI, int centerJ, int rotation,  int[][] board, int figure){
            
            switch(rotation){
                case 0: //norte
                    board[centerI][centerJ] = figure; 
                    board[centerI  - 1][centerJ] = figure; 
                    board[centerI + 1][centerJ] = figure; 
                    board[centerI + 2][centerJ] = figure;
                    break;
                    
                case 1: // este
                    board[centerI][centerJ] = figure; 
                    board[centerI][centerJ + 1 ] = figure;
                    board[centerI][centerJ - 1] = figure; 
                    board[centerI][centerJ - 2] = figure;
                    break;
                    
                case 2: // sur
                    board[centerI][centerJ] = figure; 
                    board[centerI  - 1][centerJ] = figure; 
                    board[centerI - 2][centerJ] = figure; 
                    board[centerI + 1][centerJ] = figure;
                    break;
                    
                case 3: // oeste
                    board[centerI][centerJ] = figure; 
                    board[centerI][centerJ + 1 ] = figure;
                    board[centerI][centerJ - 1] = figure; 
                    board[centerI][centerJ + 2] = figure;
                    break;
            }
    
    
            return board;
    }
    
    
    public static boolean validaMovimientoFiguraI(int centerI, int centerJ, int rotation,  int[][] board){
        int rows = Board.ROWS;
        int cols = Board.COLS;
        
        switch(rotation){
                case 0: //norte
                    return 
                    centerI + 2 < rows
                    && (centerJ >= 0) 
                    && (centerJ < cols)
                    && board[centerI][centerJ] == 0
                    && board[centerI  - 1][centerJ] == 0 
                    && board[centerI + 1][centerJ] == 0 
                    && board[centerI + 2][centerJ] == 0; 
                             
                case 1: // este
                    return(centerJ + 1 < cols)
                    && (centerJ - 2 >= 0)
                    && centerI < rows
                    && board[centerI][centerJ] == 0
                    && board[centerI][centerJ + 1 ] == 0
                    && board[centerI][centerJ - 1] == 0 
                    && board[centerI][centerJ - 2] == 0;
                    
                case 2: // sur
                    return  
                    centerI + 1 < rows
                    && (centerJ >= 0) 
                    && (centerJ < cols)        
                    && board[centerI][centerJ] == 0
                    && board[centerI  - 1][centerJ] == 0
                    && board[centerI - 2][centerJ] == 0 
                    && board[centerI + 1][centerJ] == 0;
                     
                case 3: // oeste
                    return 
                    (centerJ - 1 >= 0) 
                    && (centerJ + 2 < cols)
                    && (centerI < rows)
                    && board[centerI][centerJ] == 0
                    && board[centerI][centerJ + 1 ]  == 0
                    && board[centerI][centerJ - 1]  == 0 
                    && board[centerI][centerJ + 2]  == 0;
            }
        return true;
    }
    
     public static int[][] generateFigureT(int centerI, int centerJ, int rotation,  int[][] board, int figure){
         switch(rotation){
                case 0: //norte
                    board[centerI][centerJ] = figure; 
                    board[centerI  - 1][centerJ] = figure; 
                    board[centerI][centerJ + 1] = figure; 
                    board[centerI][centerJ - 1] = figure;
                    break;
                    
                case 1: // este
                    board[centerI][centerJ] = figure; 
                    board[centerI][centerJ + 1 ] = figure;
                    board[centerI - 1][centerJ] = figure; 
                    board[centerI + 1][centerJ] = figure;
                    break;
                    
                case 2: // sur
                    board[centerI][centerJ] = figure; 
                    board[centerI + 1][centerJ] = figure; 
                    board[centerI][centerJ - 1] = figure; 
                    board[centerI][centerJ + 1] = figure;
                    break;
                    
                case 3: // oeste
                    board[centerI][centerJ] = figure; 
                    board[centerI][centerJ - 1 ] = figure;
                    board[centerI - 1][centerJ] = figure; 
                    board[centerI + 1][centerJ] = figure;
                    break;
            }
    
            return board;
         
     }
     

    public static boolean validaMovimientoFiguraT(int centerI, int centerJ, int rotation,  int[][] board){
        int rows = Board.ROWS;
        int cols = Board.COLS;
        
        switch(rotation){
                case 0: 
                    return (centerJ + 1 >= 0) 
                    && (centerJ + 1 < cols)
                    && (centerJ - 1 >= 0) 
                    && (centerJ - 1 < cols)
                    && centerI < rows
                    
                    && board[centerI][centerJ] == 0 
                    && board[centerI  - 1][centerJ] == 0
                    && board[centerI][centerJ + 1] == 0
                    && board[centerI][centerJ - 1] == 0;
                    
                    
                case 1: // este
                    return (centerJ >= 0) 
                    && (centerJ + 1 < cols)
                    && centerI - 1 < rows        
                    && centerI + 1 < rows
                    
                    && board[centerI][centerJ] == 0 
                    && board[centerI][centerJ + 1 ] == 0
                    && board[centerI - 1][centerJ] == 0
                    && board[centerI + 1][centerJ] == 0;
                    
                case 2: // sur
                    return (centerJ + 1 >= 0) 
                    && (centerJ + 1 < cols)
                    && (centerJ - 1 >= 0) 
                    && (centerJ - 1 < cols)
                    && centerI + 1 < rows
                    
                    && board[centerI][centerJ] == 0 
                    && board[centerI + 1][centerJ] == 0 
                    && board[centerI][centerJ - 1] == 0 
                    && board[centerI][centerJ + 1] == 0 ;
                    
                    
                case 3: // oeste
                    return (centerJ - 1 >= 0) 
                    && (centerJ < cols)
                    && centerI + 1 < rows
                    
                    && board[centerI][centerJ] == 0 
                    && board[centerI][centerJ - 1 ] == 0
                    && board[centerI - 1][centerJ] == 0 
                    && board[centerI + 1][centerJ] == 0;
                    
            }
    
            return true;}
            

    public static int[][] generateFigureJ(int centerI, int centerJ, int rotation,  int[][] board, int figure){
        switch(rotation){
                case 0: //norte
                    board[centerI][centerJ] = figure; 
                    board[centerI  - 1][centerJ] = figure; 
                    board[centerI + 1][centerJ] = figure; 
                    board[centerI + 1][centerJ - 1] = figure;
                    break;
                    
                case 1: // este
                    board[centerI][centerJ] = figure; 
                    board[centerI][centerJ + 1 ] = figure;
                    board[centerI][centerJ - 1] = figure; 
                    board[centerI - 1][centerJ - 1] = figure;
                    break;
                    
                case 2: // sur
                    board[centerI][centerJ] = figure; 
                    board[centerI + 1][centerJ] = figure; 
                    board[centerI - 1][centerJ] = figure; 
                    board[centerI - 1][centerJ + 1] = figure;
                    break;
                    
                case 3: // oeste
                    board[centerI][centerJ] = figure; 
                    board[centerI ][centerJ - 1 ] = figure;
                    board[centerI ][centerJ + 1] = figure; 
                    board[centerI + 1][centerJ + 1] = figure;
                    break;
            }
        
        return board;
    }
    
    public static boolean validaMovimientoFiguraJ(int centerI, int centerJ, int rotation,  int[][] board){
        int rows = Board.ROWS;
        int cols = Board.COLS;
        switch(rotation){
                case 0: //norte
                    return
                    centerJ < cols
                    && centerI + 1 < rows
                    && centerJ - 1 >= 0
                    && board[centerI][centerJ] == 0
                    && board[centerI  - 1][centerJ] == 0
                    && board[centerI + 1][centerJ] == 0 
                    && board[centerI + 1][centerJ - 1]  == 0;
                    
                    
                case 1: // este
                    return
                    centerJ + 1 < cols
                    && centerJ - 1 >= 0
                    && centerI < rows
                    && board[centerI][centerJ]  == 0 
                    && board[centerI][centerJ + 1 ]  == 0 
                    && board[centerI][centerJ - 1]  == 0  
                    && board[centerI - 1][centerJ - 1]  == 0 ;
                    
                    
                case 2: // sur
                    return centerJ + 1 < cols
                    && centerI + 1 < rows
                    && centerJ >= 0
                    && board[centerI][centerJ] == 0  
                    && board[centerI + 1][centerJ] == 0 
                    && board[centerI - 1][centerJ] == 0 
                    && board[centerI - 1][centerJ + 1] == 0 ;
                    
                case 3: // oeste
                    return centerJ + 1 < cols
                    && centerJ - 1 >= 0
                    && centerI + 1 < rows
                    && board[centerI][centerJ] == 0
                    && board[centerI ][centerJ - 1 ] == 0
                    && board[centerI ][centerJ + 1] == 0
                    && board[centerI + 1][centerJ + 1] == 0;
            }
        
        return true;
    }
    
    public static int[][] generateFigureL(int centerI, int centerJ, int rotation,  int[][] board, int figure){
        switch(rotation){
                case 0: //norte
                    board[centerI][centerJ] = figure; 
                    board[centerI  - 1][centerJ] = figure; 
                    board[centerI + 1][centerJ] = figure; 
                    board[centerI + 1][centerJ + 1] = figure;
                    break;
                    
                case 1: // este
                    board[centerI][centerJ] = figure; 
                    board[centerI][centerJ + 1 ] = figure;
                    board[centerI][centerJ - 1] = figure; 
                    board[centerI + 1][centerJ - 1] = figure;
                    break;
                    
                case 2: // sur
                    board[centerI][centerJ] = figure; 
                    board[centerI + 1][centerJ] = figure; 
                    board[centerI - 1][centerJ] = figure; 
                    board[centerI - 1][centerJ - 1] = figure;
                    break;
                    
                case 3: // oeste
                    board[centerI][centerJ] = figure; 
                    board[centerI ][centerJ - 1 ] = figure;
                    board[centerI ][centerJ + 1] = figure; 
                    board[centerI - 1][centerJ + 1] = figure;
                    break;
            }
        
        return board;
    }
    
    public static boolean validaMovimientoFiguraL(int centerI, int centerJ, int rotation,  int[][] board){
        int rows = Board.ROWS;
        int cols = Board.COLS;
        switch(rotation){
                case 0: //norte
                    return
                    centerJ + 1 < cols
                    && centerI < rows
                    && centerJ >= 0
                    && board[centerI][centerJ] == 0
                    && board[centerI  - 1][centerJ] == 0
                    && board[centerI + 1][centerJ] == 0 
                    && board[centerI + 1][centerJ + 1]  == 0;
                    
                    
                case 1: // este
                    return
                    centerJ + 1 < cols
                    && centerJ - 1 >= 0
                    && centerI + 1< rows
                    && board[centerI][centerJ]  == 0 
                    && board[centerI][centerJ + 1 ]  == 0 
                    && board[centerI][centerJ - 1]  == 0  
                    && board[centerI + 1][centerJ - 1]  == 0 ;
                    
                    
                case 2: // sur
                    return centerJ < cols
                    && centerI + 1 < rows
                    && centerJ - 1 >= 0
                    && board[centerI][centerJ] == 0  
                    && board[centerI + 1][centerJ] == 0 
                    && board[centerI - 1][centerJ] == 0 
                    && board[centerI - 1][centerJ - 1] == 0 ;
                    
                case 3: // oeste
                    return centerJ + 1 < cols
                    && centerJ - 1 >= 0
                    && centerI < rows
                    && board[centerI][centerJ] == 0
                    && board[centerI ][centerJ - 1 ] == 0
                    && board[centerI ][centerJ + 1] == 0
                    && board[centerI - 1][centerJ + 1] == 0;
            }
        
        return true;
    }
    
    public static int[][] generateFigureS(int centerI, int centerJ, int rotation,  int[][] board, int figure){
        switch(rotation){
                case 0: //norte
                    board[centerI][centerJ] = figure; 
                    board[centerI  - 1][centerJ] = figure; 
                    board[centerI - 1][centerJ + 1] = figure; 
                    board[centerI][centerJ - 1] = figure;
                    break;
                    
                case 1: // este
                    board[centerI][centerJ] = figure; 
                    board[centerI - 1][centerJ] = figure;
                    board[centerI][centerJ + 1] = figure; 
                    board[centerI + 1][centerJ + 1] = figure;
                    break;
                    
                case 2: // sur
                    board[centerI][centerJ] = figure; 
                    board[centerI + 1][centerJ] = figure; 
                    board[centerI][centerJ + 1] = figure; 
                    board[centerI + 1][centerJ - 1] = figure;
                    break;
                    
                case 3: // oeste
                    board[centerI][centerJ] = figure; 
                    board[centerI ][centerJ - 1 ] = figure;
                    board[centerI + 1][centerJ] = figure; 
                    board[centerI - 1][centerJ - 1] = figure;
                    break;
            }
        
        return board;
    }
    
    public static boolean validaMovimientoFiguraS(int centerI, int centerJ, int rotation,  int[][] board){
        int rows = Board.ROWS;
        int cols = Board.COLS;
        switch(rotation){
                case 0: //norte
                    return
                    centerJ + 1 < cols
                    && centerI < rows
                    && centerJ - 1 >= 0
                    && board[centerI][centerJ] == 0
                    && board[centerI  - 1][centerJ]  == 0
                    && board[centerI - 1][centerJ + 1]  == 0 
                    && board[centerI][centerJ - 1]  == 0;
                    
                    
                case 1: // este
                    return
                    centerJ + 1 < cols
                    && centerJ >= 0
                    && centerI + 1 < rows
                    && board[centerI][centerJ]  == 0 
                    && board[centerI - 1][centerJ] == 0
                    && board[centerI][centerJ + 1] == 0 
                    && board[centerI + 1][centerJ + 1] == 0;
                    
                    
                case 2: // sur
                    return centerJ + 1 < cols
                    && centerI + 1 < rows
                    && centerJ - 1 >= 0
                    && board[centerI][centerJ] == 0  
                    && board[centerI + 1][centerJ]  == 0
                    && board[centerI][centerJ + 1]  == 0 
                    && board[centerI + 1][centerJ - 1]  == 0;
                    
                case 3: // oeste
                    return centerJ < cols
                    && centerJ - 1 >= 0
                    && centerI + 1< rows
                    && board[centerI][centerJ] == 0
                    && board[centerI ][centerJ - 1 ]  == 0 
                    && board[centerI + 1][centerJ]  == 0 
                    && board[centerI - 1][centerJ - 1]  == 0 ;
            }
        
        return true;
    }
    
    public static int[][] generateFigureZ(int centerI, int centerJ, int rotation,  int[][] board, int figure){
        switch(rotation){
                case 0: //norte
                    board[centerI][centerJ] = figure; 
                    board[centerI  - 1][centerJ ] = figure; 
                    board[centerI - 1][centerJ - 1] = figure; 
                    board[centerI][centerJ + 1] = figure;
                    break;
                    
                case 1: // este
                    board[centerI][centerJ] = figure; 
                    board[centerI - 1][centerJ + 1] = figure;
                    board[centerI][centerJ + 1] = figure; 
                    board[centerI + 1][centerJ] = figure;
                    break;
                    
                case 2: // sur
                    board[centerI][centerJ] = figure; 
                    board[centerI + 1][centerJ] = figure; 
                    board[centerI + 1][centerJ + 1] = figure; 
                    board[centerI ][centerJ - 1] = figure;
                    break;
                    
                case 3: // oeste
                    board[centerI][centerJ] = figure; 
                    board[centerI ][centerJ - 1 ] = figure;
                    board[centerI + 1][centerJ - 1] = figure; 
                    board[centerI - 1][centerJ] = figure;
                    break;
            }
        
        return board;
    }
    
    public static boolean validaMovimientoFiguraZ(int centerI, int centerJ, int rotation,  int[][] board){
        int rows = Board.ROWS;
        int cols = Board.COLS;
        switch(rotation){
                case 0: //norte
                    return
                    centerJ + 1 < cols
                    && centerI < rows
                    && centerJ - 1 >= 0
                    && board[centerI][centerJ] == 0
                    && board[centerI  - 1][centerJ]  == 0
                    && board[centerI - 1][centerJ - 1]  == 0 
                    && board[centerI][centerJ + 1]  == 0;
                    
                    
                case 1: // este
                    return
                    centerJ + 1 < cols
                    && centerJ >= 0
                    && centerI + 1 < rows
                    && board[centerI][centerJ]  == 0 
                    && board[centerI + 1][centerJ] == 0
                    && board[centerI][centerJ + 1] == 0 
                    && board[centerI - 1][centerJ + 1] == 0;
                    
                    
                case 2: // sur
                    return centerJ + 1 < cols
                    && centerI + 1 < rows
                    && centerJ - 1 >= 0
                    && board[centerI][centerJ] == 0  
                    && board[centerI + 1][centerJ]  == 0
                    && board[centerI + 1][centerJ + 1]  == 0 
                    && board[centerI ][centerJ - 1]  == 0;
                    
                case 3: // oeste
                    return centerJ < cols
                    && centerJ - 1 >= 0
                    && centerI + 1< rows
                    && board[centerI][centerJ] == 0
                    && board[centerI ][centerJ - 1 ]  == 0 
                    && board[centerI + 1][centerJ - 1]  == 0 
                    && board[centerI - 1][centerJ]  == 0 ;
            }
        
        return true;
    }
}
