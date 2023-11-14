package Project;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * This class represents a static background on the canvas. It will generate a background in the scene
 * indefinitely until the stop method is called.
 * Inherits all the methods from the abstract timeline class
 */
public class BackgroundStaticCanvas extends AbstractTimeLine {
  private Scene scene;

  /**
   * Creates a new BackgroundStaticCanvas object that takes in a scene and duration
   * @param scene scene in which the background will be to set to
   * @param duration duration between timelines. This will be indefinite since we set the cycle count to indefinite.
   */
  public BackgroundStaticCanvas(Scene scene, Duration duration) {
    super(duration);
    this.scene = scene;
  }

  /**
   * method that sets the background to black forever until a method overwrites it or a stop is called.
   */
  @Override
  protected void handle() {
      scene.setFill(Color.BLACK);
    }
  }