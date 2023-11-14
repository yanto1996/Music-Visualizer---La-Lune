package Project;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This class main extends the Application subclass and uses it to create a GUI for the visualizer.
 * It converts the LineVisualizer graphicsContext into the root of the scene using StackPane.
 * Creates the stage and plays the music and the visualizer at the same time.
 * Visualizer is coded through the timeline class and the animations trigger based on certain timers
 * which aligns with the music being passed in.
 */

public class Main extends Application {

  /**
   * Starts the GUI by generating a new linevisualizer, audioplayer, root, and scene.
   * @param primaryStage primary stage that takes in a scene to be played.
   * graphicsContext generates the canvas for the drawing, which is passed through
   * to the scene for it to be played.
   * graphicsContext serves as the canvas, scene serves as the primary node for the canvas to be played.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    // creates new line visualizer with width and height input
    LineVisualizer lineVisualizer = new LineVisualizer(1200, 600);

    // creates new audio player with file path input. WILL NEED TO BE UPDATED
    AudioPlayer mp3 = new AudioPlayer("/Users/jto/Desktop/nurture.wav");

    // converts the line visualizer into a root node with stack pane
    StackPane root = new StackPane(lineVisualizer);

    // create new scene object that passes in the root object and weight / height inputs
    Scene scene = new Scene(root, 1200, 600);

    // initialize the background color of the scene, the title of GUI
    scene.setFill(Color.WHITE);
    primaryStage.setTitle("Visualizer");
    primaryStage.setScene(scene);
    primaryStage.show();

    // Get the GraphicsContext object from the LineVisualizer and creates a new timeline animation object
    GraphicsContext gc = lineVisualizer.getGraphicsContext2D();
    TimeLine timeLine = new TimeLine(scene, lineVisualizer);

    // plays the timeline animation and the audioplayer at the same time
    timeLine.playTimeLine(gc);
    mp3.play();
  }

  /**
   * Method to launch the GUI
   * @param args
   */
    public static void main(String[] args) {
    launch(args);
  }
}