package test;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * This test class tests the visualizer interface.
 * It creates a new class called sampleVisualizer which implements the actual visualizer interface and
 * will test each of its methods.
 */
public class VisualizerTest {

  private sampleVisualizer visualizer;

  /**
   * Creates new sample interface with start, stop, and clear as false
   */
  private class sampleVisualizer implements Visualizer {

    private boolean isStarted = false;
    private boolean isStopped = false;
    private boolean isCleared = false;

    /**
     * Override start method so that when called, the boolean will toggle and becomes true
     */
    @Override
    public void start() {
      isStarted = true;
    }

    /**
     * override the stop method so that when called, the boolean will toggle and becomes true
     */
    @Override
    public void stop() {
      isStopped = true;
    }

    /**
     * override the clear method so that when clear is called, the boolean will toggle and becomes true
     */
    @Override
    public void clear() {
      isCleared = true;
    }
  }

  /**
   * Setup method for the test object
   */
  @Before
  public void setUp() {
    visualizer = new sampleVisualizer();
  }

  /**
   * Test method that starts the visualizer. Will return true if start is called and false if stop and clear
   * are not called
   */
  @Test
  public void testSampleVisualizerStart() {
    visualizer.start();
    assertTrue(visualizer.isStarted);
    assertFalse(visualizer.isStopped);
    assertFalse(visualizer.isCleared);
  }

  /**
   * Test method that test if the stop method is flagging true once it is called. Start and clear should return false
   * because it is not called
   */
  @Test
  public void testSampleVisualizerStop() {
    visualizer.stop();
    assertFalse(visualizer.isStarted);
    assertTrue(visualizer.isStopped);
    assertFalse(visualizer.isCleared);
  }

  /**
   * Test method that tests if the clear method is flagging true once called. Start and stop should return false
   * because it is not called
   */
  @Test
  public void testSampleVisualizerClear() {
    visualizer.clear();
    assertFalse(visualizer.isStarted);
    assertFalse(visualizer.isStopped);
    assertTrue(visualizer.isCleared);
  }
}