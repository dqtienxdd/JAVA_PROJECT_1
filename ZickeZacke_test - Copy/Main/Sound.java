package Main;

import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound(){
        soundURL[0] = getClass().getResource("/res/sound/click_sound.wav");
        soundURL[1] = getClass().getResource("/res/sound/feather_take_sound.wav");
        soundURL[2] = getClass().getResource("/res/sound/move_sound.wav");
        soundURL[3] = getClass().getResource("/res/sound/wrong_choose_sound.wav");
        soundURL[4] = getClass().getResource("/res/sound/winning_sound.wav");
    }
    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais); 
        } catch (Exception e) {
            
        }
    }
    public void play(){
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
