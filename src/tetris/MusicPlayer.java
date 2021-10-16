/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 *
 * @author John
 */
public class MusicPlayer {
    
    boolean isRunnig;
    private Clip clip;
    
    MusicPlayer(String filePath){
        
        try {
                // Se obtiene un Clip de sonido
                clip = AudioSystem.getClip();
                // Se carga con un fichero wav
                clip.open(AudioSystem.getAudioInputStream(new File(filePath)));
                // Comienza la reproducción
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
                LineListener listener = new LineListener() {
                    @Override
                    public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.START) {
                            
                            while (clip.isRunning()){
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }                            
                            clip.close();  
                        }
                    }
                };
                clip.addLineListener(listener);
               

            } catch (UnsupportedAudioFileException ex) {
                 Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                 
             } catch (IOException ex) {
                 Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                 
            } catch (LineUnavailableException ex) {
                 Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }

    public Clip getClip() {
        return clip;
    }
    
    
    
    
}
