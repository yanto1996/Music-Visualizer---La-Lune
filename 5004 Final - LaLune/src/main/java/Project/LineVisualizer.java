package Project;

import javafx.animation.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * This class extends JavaFX canvas and implements the visualizer interface.
 * It inherits all the methods from the visualizer interface such as start, stop, and clear
 * It uses the drawline method from the class Line in order to constantly draw lines within the canvas
 * Drawline takes in graphicsContext gc as a parameter allowing it can draw on that canvas.
 * Animation timer is used to draw line over and over based on the computers clock in nanoseconds
 */

public class LineVisualizer extends Canvas implements Visualizer{
  private GraphicsContext gc;
  private Line drawLine;
  private AnimationTimer animationTimer;

  /**
   * LineVisualizer class that takes in width and height of the canvas
   * Uses super to pass in the width and height of the canvas through the built-in javaFX canvas class
   * Calls start in the constructor in order to start drawing the lines
   * getGraphicsContext2d() is a built-in function from canvas that returns a graphicContext object
   * @param width = width of the canvas
   * @param height = height of the canvas
   */
  public LineVisualizer(double width, double height) {
    super(width, height);
    gc = getGraphicsContext2D();
    start();
    drawLine = new Line(gc);
  }


  /**
   * Start method for the lineVisualizer
   * Creates a new animation timer which will call drawline over and over based on now,
   * which is the cpu timer in nanoseconds
   */
  @Override
  public void start() {
    animationTimer = new AnimationTimer() {
      public void handle(long now) {
        drawLine.update(now);
      }
    };
    animationTimer.start();
  }

  /**
   * method to stop the LineVisualizer
   */
  @Override
  public void stop() {
    animationTimer.stop();
  }

  /**
   * method that clears the lineVisualizer
   * gc.clearRect clears the canvas within that rectangle area of the canvas
   * takes in the width and height of the canvas and clears the whole thing
   */
  @Override
  public void clear() {
    GraphicsContext gc = this.getGraphicsContext2D();
    gc.clearRect(0, 0, this.getWidth(), this.getHeight());
  }
}