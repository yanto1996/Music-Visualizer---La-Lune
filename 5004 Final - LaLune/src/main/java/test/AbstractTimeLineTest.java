package test;
import javafx.animation.Timeline;
import javafx.util.Duration;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This test class tests the abstract timeline. It makes sure that the timeline duration is running at infinite
 * therefore it will stay static until something else overwrites this
 */
public class AbstractTimeLineTest {

  private AbstractTimeLine testAbstract;

  /**
   * Creates a new abstract timeline object
   */
  @Before
  public void setUP() {
    testAbstract = new AbstractTimeLine(new Duration(1)) {
      @Override
      protected void handle() {
      }
    };
  }

  /**
   * Test method that checks if timeline method is null
   * Checks if the cycle count for the timeline is set to infinite
   * checks if the status is running for abstract timeline. Should return false since it has not been called.
   * Calling this method to start will break the junit test as there is no save state
   */
  @Test
  public void testAbstractTimeLine() {
    assertNotNull(testAbstract.timeline);
    assertEquals(Timeline.INDEFINITE, testAbstract.timeline.getCycleCount());
    assertFalse(testAbstract.timeline.getStatus().equals(Timeline.Status.RUNNING));
  }
}