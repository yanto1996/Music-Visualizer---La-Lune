package test;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This test class tests the line class and its methods. It sets up a new canvas and tests if
 * lines are in bounds, if the line is updating directions, and if the line is resetting
 */
public class LineTest {
  private GraphicsContext testGC;
  private Line testLine;

  /**
   * setup method for the tests
   */
  @Before
  public void setUP(){
    testGC = new Canvas().getGraphicsContext2D();
    testLine  = new Line(testGC);
  }

  /**
   * Test method for the initial values of the line. It should be within bounds of the canvas
   * To get the bounds of canvas, we use getCanvas.getwidth or .getheight
   */
  @Test
  public void testInitialValues(){
    assertEquals(testLine.color, Color.GRAY);
    assertTrue(testLine.x >= 0.0 && testLine.x <= testGC.getCanvas().getWidth());
    assertTrue(testLine.y >= 0.0 && testLine.y <= testGC.getCanvas().getHeight());
    assertNotNull(testLine.xDir);
    assertNotNull(testLine.yDir);
  }

  /**
   * Test method for updating the position of the line.
   * Once update position is called, the initial values should change for x and y
   */
  @Test
  public void testUpdatePosition() {
    double initialX = testLine.x;
    double initialY = testLine.y;
    testLine.updatePosition();
    assertNotEquals(initialX, testLine.x);
    assertNotEquals(initialY, testLine.y);
  }

  /**
   * Test method that checks the bounds of the where the line is going.
   * the object will call checkBounds and will test if x and y are still within the bounds of the canvas
   */
  @Test
  public void testCheckBounds() {
    testLine.x = -1.0;
    testLine.checkBounds();
    assertTrue(testLine.x >= 0.0 && testLine.x <= testGC.getCanvas().getWidth());
    testLine.x = testGC.getCanvas().getWidth();
    testLine.checkBounds();
    assertTrue(testLine.x >= 0.0 && testLine.x <= testGC.getCanvas().getWidth());
    testLine.y = -3.0;
    testLine.checkBounds();
    assertTrue(testLine.y >= 0.0 && testLine.y <= testGC.getCanvas().getHeight());
    testLine.y = testGC.getCanvas().getHeight();
    testLine.checkBounds();
    assertTrue(testLine.y >= 0.0 && testLine.y <= testGC.getCanvas().getHeight());
  }
}