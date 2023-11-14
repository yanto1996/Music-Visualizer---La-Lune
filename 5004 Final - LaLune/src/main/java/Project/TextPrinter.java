package Project;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Utility class that helps print text on a graphicContext
 */
public class TextPrinter {

  /**
   * Method that prints text based on font, color, and placement of the GC
   * @param gc graphicContext to print on
   * @param text The text itself we want to write
   * @param font The font of the text
   * @param color The color of the text
   * @param x The x coordinate where you want the text
   * @param y The y coordinate where you want the text
   */
  public static void print(GraphicsContext gc, String text, Font font, Color color, double x, double y) {
    gc.setFont(font);
    gc.setFill(color);
    gc.fillText(text, x, y);
  }
}