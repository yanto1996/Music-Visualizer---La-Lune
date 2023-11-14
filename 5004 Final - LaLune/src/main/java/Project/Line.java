package Project;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This class draws the line for the visualizer. It uses the GraphicsContext class to draw.
 * Uses a random number generator to randomly generate direction of the drawing
 * Starting point (x, y)
 * Uses java class color to get the color of the line
 * Enum direction to help set the coordinates for the line
 */
public class Line {
  private GraphicsContext gc;
  private double x, y;
  private Direction xDir = Direction.RIGHT;
  private Direction yDir = Direction.LEFT;
  private Color color = Color.GRAY;
  private double strokeWidth;

  /**
   * Constructs a line using the GraphicsContext object and random that randomizes starting and end points for the drawing
   * @param gc Java class that is used draw to line into a canvas
   */
  public Line(GraphicsContext gc) {
    this.gc = gc;
    this.x = (int) (Math.random() * gc.getCanvas().getWidth());
    this.y = (int) (Math.random() * gc.getCanvas().getHeight());
    this.strokeWidth = Math.random() * 3.0 + 1.0;
  }

  /**
   * This method constantly updates the visualizer. It calls drawline to draw the line, update the position,
   * and check its boundaries.
   * @param now the current system time in nanoseconds, often used to time animations
   */
  public void update(long now) {
    drawLine();
    updatePosition();
    checkBounds();
  }

  /**
   *This method draws the line. It uses the built-in methods from GraphicsContext to set the line color,
   * set the line width, and draw extend the line from directions (x,y) to (x2,y2)
   */
  private void drawLine() {
    gc.setStroke(color);
    gc.setLineWidth(strokeWidth);
    gc.strokeLine(x, y, x + xDir.getX() * 20, y + yDir.getY() * 20);
  }

  /**
   * Method that updates the direction x and y
   * Increments the current x and y values by using a random method that generates a number between 2 and 4
   * That number is then added by 2 to generate the 3D effect. (Found this by random experimentation)
   */
  private void updatePosition() {
    x += xDir.getX() * (Math.random() * 2.0 + 2.0) + 2;
    y += yDir.getY() * (Math.random() * 2.0 + 2.0) + 2;
  }

  /**
   * Method to check if the x, y coordinates are out of bounds.
   * Uses a method from GraphicsContext to get the width and height of the canvas
   * If the x or y coordinate is greater than width or height, reset the line.
   * If it is not, just randomly change the direction
   */
  private void checkBounds() {
    if (x < 0 || x > gc.getCanvas().getWidth() || y < 0 || y > gc.getCanvas().getHeight()) {
      resetLine();
    }
    else {
      randomlyChangeDirection();
    }
  }

  /**
   * Method to reset the x and y values of the line
   * Math.random generates a double between 0 and 1 so if we set it 0.5 we have 50/50 chance to reset the direction
   */
  private void resetLine() {
    double widthCanvas = gc.getCanvas().getWidth();
    double heightCanvas = gc.getCanvas().getHeight();
    x = Math.random() * widthCanvas;
    y = Math.random() * heightCanvas;

    if (Math.random() < 0.5) {
      xDir = Direction.RIGHT;
    }
    else {
      xDir = Direction.LEFT;
    }

    if (Math.random() < 0.5) {
      yDir = Direction.UP;
    }
    else {
      yDir = Direction.DOWN;
    }
  }

  /**
   * Method that randomly changes the direction of the line. It adds variation to the line design.
   * Uses math.random to flag if the direction should change left to right, down to up and vice versa.
   */
  private void randomlyChangeDirection() {
    if (Math.random() < 0.01) {
      if (xDir == Direction.RIGHT) {
        xDir = Direction.LEFT;
      } else {
        xDir = Direction.RIGHT;
      }
    }
    if (Math.random() < 0.01) {
      if (yDir == Direction.UP) {
        yDir = Direction.DOWN;
      } else {
        yDir = Direction.UP;
      }
    }
  }
}