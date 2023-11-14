package Project;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * This represents the abstract timeline class from JavaFX.
 * It creates an abstract timeline that can be inherited from other timeline classes that can start, stopped, and
 * played indefinitely.
 * This is used to help design the background effects of the GUI
 */
public abstract class AbstractTimeLine {

  /**
   * timeline object that controls the timing of the animation
   */
  public Timeline timeline;

  /**
   * creates a new abstract timeline object with a specific duration between animations.
   * @param duration duration between events in the timeline.
   * Timeline is set to infinite so we can manually configure animations.
   */
  public AbstractTimeLine(Duration duration) {
    timeline = new Timeline(new KeyFrame(duration, event -> {
      handle();
    }));
    timeline.setCycleCount(Timeline.INDEFINITE);
  }

  /**
   * method to play the timeline
   */
  public void play() {
    timeline.play();
  }

  /**
   * method to stop the timeline
   */
  public void stop() {
    timeline.stop();
  }

  /**
   * Method for the subclasses to overwrite as each background function provides something different
   */
  protected abstract void handle();
}