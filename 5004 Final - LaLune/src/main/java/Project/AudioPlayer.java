package Project;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * This is an AudioPlayer class. It contains all methods that an audio player has such as play, stop, and pause
 * Uses Java Sound API to play the audio files
 */
public class AudioPlayer {
  private Clip clip;

  /**
   * Creates a new AudioPlayer Object that loads a WAV file given the file path.
   * @param filePath file path to load WAV file.
   */
  public AudioPlayer(String filePath) throws Exception {
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
        new File(filePath).getAbsoluteFile());
    clip = AudioSystem.getClip();
    clip.open(audioInputStream);
  }

  /**
   * Method to play the loaded WAV file from the beginning 0:00.
   */
  public void play() {
    clip.start();
  }

  /**
   * Pauses the WAV loaded WAV file.
   */
  public void pause() {
    clip.stop();
  }

  /**
   * Stops the playback of the loaded WAV file at its current timestamp.
   */
  public void stop() {
    clip.stop();
    clip.setFramePosition(0);
  }

  /**
   * getter method to return the clip object
   * @return clip object
   */
  public Clip getClip(){
    return clip;
  }
}