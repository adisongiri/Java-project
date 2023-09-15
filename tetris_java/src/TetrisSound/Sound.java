package TetrisSound;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sound {
   private final URL clear;
   private final URL success;
   private final  URL start ;
   public Sound(){

       this.success = this.getClass().getClassLoader().getResource("TetrisSound/success.wav");
       this.clear = this.getClass().getClassLoader().getResource("TetrisSound/clear.wav");
       this.start = this.getClass().getClassLoader().getResource("TetrisSound/start.wav");
   }
   public void SoundClear(){
       play(clear);
   }
    public void SoundSuccess(){
        play(success);
    }
    public void SoundStart(){play(start);}
   private void play(URL url){
       try{
           AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
           Clip clip = AudioSystem.getClip();
           clip.open(audioIn);
           clip.addLineListener(new LineListener() {
               @Override
               public void update(LineEvent event) {
                   if (event.getType()==LineEvent.Type.STOP){
                       clip.close();
                   }
               }
           });
           audioIn.close();
           clip.start();
       }catch (IOException | LineUnavailableException |UnsupportedAudioFileException e){
           System.err.println(e);
       }

   }
}
