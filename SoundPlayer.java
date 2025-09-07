import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class SoundPlayer {
    
    /**
     * Used to create a sound file
     */
    public static void voice(String fileName) throws MalformedURLException, LineUnavailableException, UnsupportedAudioFileException, IOException {
        File url = new File(fileName);
        if (!url.exists()) {
            System.err.println("Sound file not found: " + fileName);
            return;
        }
        
        Clip clip = AudioSystem.getClip();
        
        try (AudioInputStream ais = AudioSystem.getAudioInputStream(url)) {
            clip.open(ais);
            clip.start();
            // Wait for the sound to finish playing before returning (optional)
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
            System.err.println("Error playing sound: " + fileName);
        }
    }
    
    /**
     * Method to play sound effect for bouncing
     */
    public static void playSound(String path) {
        try {
            voice(path);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            // Handle the specific sound exception here
            e.printStackTrace();
        }
    }
    

}
