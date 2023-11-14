package Project;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * This class creates a background flash effect that alternates between 2 colors when the toggle triggers.
 * Inherits all the methods from the abstract timeline class.
 */
public class BGFlash extends AbstractTimeLine {
  private Scene scene;
  private Color color1;
  private Color color2;
  private boolean toggle = false;

  /**
   * Constructs the BGFlash object with a given scene, duration, and 2 colors to alternate between
   * @param scene Scene for the BGFlash to be played on
   * @param duration Duration of the flash effect. How fast a color appears before another
   * @param color1 Color 1
   * @param color2 Color 2
   */
  public BGFlash(Scene scene, Duration duration, Color color1, Color color2) {
    super(duration);
    this.scene = scene;
    this.color1 = color1;
    this.color2 = color2;
  }

  /**
   * method that toggles between 2 colors. Controlled with the duration parameter from an object level
   */
  @Override
  protected void handle() {
    if (toggle) {
      scene.setFill(color1);
    } else {
      scene.setFill(color2);
    }
    toggle = !toggle;
  }
}