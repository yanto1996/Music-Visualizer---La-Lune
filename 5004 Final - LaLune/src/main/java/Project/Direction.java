package Project;

/**
 * Enum that helps represent the directions of the line
 * Directions go from UP, DOWN, LEFT, RIGHT
 */
public enum Direction {
  /**
   * Up direction, with x = 0 and y = -1.
   */
  UP(0, -1),

  /**
   * Down direction, with x = 0 and y = 1.
   */
  DOWN(0, 1),

  /**
   * Left direction, with x = -1 and y = 0.
   */
  LEFT(-1, 0),

  /**
   * Right direction, with x = 1 and y = 0.
   */
  RIGHT(1, 0);

  private int x;
  private int y;

  /**
   * creates new direction object that takes in x and y as coordinates
   * @param x x coordinate of the direction
   * @param y y coordinate of the direction
   */
  Direction(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * getter method for x coordinate
   * @return integer x coordinate
   */
  public int getX() {
    return x;
  }

  /**
   * getter method for y coordinate
   * @return integer y coordinate
   */
  public int getY() {
    return y;
  }
}