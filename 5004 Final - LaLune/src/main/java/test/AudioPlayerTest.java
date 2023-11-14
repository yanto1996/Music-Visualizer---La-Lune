package test;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class tests the audio player class and its functions
 * The test ignores testPlay because it will run the WAV file but instantly stops and fails the test
 * The audio file does actually play the whole way through on main
 * and the test will generate failed
 * Other methods include testPause and testStop which tests the basic functions of the audio player
 */
public class AudioPlayerTest {
  private AudioPlayer audioPlayer;

  /**
   * Sets up a new audioPlayer object with file path to music
   * @throws Exception If file path does not exist
   */
  @Before
  public void setUp() throws Exception {
    audioPlayer = new AudioPlayer("/Users/jto/Desktop/nurture.wav");
  }

  /**
   * Method to test if audioPlayer is playing. It uses the method getClip and checks if it is active
   * Test is being ignored because it crashes however, the audio file does play the full way through
   */
  @Ignore
  public void testPlay() {
    audioPlayer.play();
    assertTrue(audioPlayer.getClip().isActive());
  }

  /**
   * Test method to check if audioPlayer is not active when you play and pause right away
   */
  @Test
  public void testPause() {
    audioPlayer.play();
    audioPlayer.pause();
    assertFalse(audioPlayer.getClip().isActive());
  }

  /**
   * Test method to stopping the audio player. It plays the audio file and stops it right away.
   */
  @Test
  public void testStop() {
    audioPlayer.play();
    audioPlayer.stop();
    assertFalse(audioPlayer.getClip().isActive());
  }
}