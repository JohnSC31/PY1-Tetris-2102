package tetris;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josa
 */
public class Ranking {
    private String nombre;
    private String tiempo;
    private int score;

    public Ranking(String nombre, String tiempo, int score) {
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.score = score;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTiempo() {
        return tiempo;
    }

    public int getScore() {
        return score;
    }
    
    @Override
    public String toString(){
        return nombre + "\t" + tiempo + "\t" + score ;
    }
    
    
    
    
}
