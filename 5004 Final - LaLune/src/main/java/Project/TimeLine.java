package Project;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * This is the timeline class that plays the triggers all the animation from the other classes.
 * Takes in the scene to play the animation and the lineVisualizer as the root of the scene.
 */
public class TimeLine{
    private Scene scene;
    private LineVisualizer lineVisualizer;

    public TimeLine(Scene scene, LineVisualizer lineVisualizer){
      this.scene = scene;
      this.lineVisualizer = lineVisualizer;
    }

  /**
   * Method that generates the visuals. It uses all the other classes such as background canvas, BGFlash,
   * linevisualizer, and passes it into a timeline where each trigger is coded to happen at certain
   * timestamps.
   * @param gc The graphicContexts to play the animation in.
   */
  public void playTimeLine(GraphicsContext gc) {
    BackgroundStaticCanvas staticCanvas = new BackgroundStaticCanvas(scene, Duration.seconds(20));
    BGFlash whiteBlack = new BGFlash(scene, Duration.seconds(0.1), Color.WHITE, Color.BLACK);
    BGFlash backGroundFlash = new BGFlash(scene, Duration.seconds(0.1), Color.BLACK, Color.DEEPSKYBLUE);
    BGFlash whiteBlue = new BGFlash(scene, Duration.seconds(0.2), Color.BLACK, Color.WHITESMOKE);
    BGFlash whiteBlackTwo = new BGFlash(scene, Duration.seconds(0.2), Color.WHITE, Color.BLACK);
    staticCanvas.play();
    Timeline animation = new Timeline(
        new KeyFrame(Duration.seconds(3), event -> {
          gc.setFill(Color.BLACK);
          gc.fillOval(425, 175, 300, 300);
        }),
        new KeyFrame(Duration.seconds(1), event ->{
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "TOP 100 MUSIC PRODUCTION TIPS", new Font("Arial", 20), Color.BLACK, 220, 132);
        }),
        new KeyFrame(Duration.seconds(4.5), event ->{
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "THIS SONG WILL BE A HIT", new Font("Arial", 20), Color.BLACK, 620, 132);
        }),
        new KeyFrame(Duration.seconds(2), event ->{
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "IM ON TOP OF THE WORLD!!!!", new Font("Arial", 20), Color.BLACK, 120, 532);
        }),
        new KeyFrame(Duration.seconds(5), event -> {
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "LOOK AT THE SKY!",
              new Font("Arial", 20), Color.BLACK, 520, 532);
        }),
        new KeyFrame(Duration.seconds(5), event -> {
          lineVisualizer.stop();
        }),
        new KeyFrame(Duration.seconds(7), event -> {
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "La Lune", new Font("Arial", 20), Color.WHITE, 545, 325);
        }),
        new KeyFrame(Duration.seconds(10), event -> {
          lineVisualizer.clear();
          scene.setFill(Color.BLACK);
        }),
        new KeyFrame(Duration.seconds(12), event -> {
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "TRYING TO FEEL ALIVE", new Font("Arial", 20), Color.WHITE, 515, 300);
        }),
        new KeyFrame(Duration.seconds(13.5), event -> {
          lineVisualizer.clear();
          lineVisualizer.start();
          gc.fillText("L-TRIP", 550, 450);
          gc.fillText("TRYING TO FEEL ALIVE", 550, 550);
          gc.fillText("WHAT IS WORTH LIVING", 550, 250);
          gc.fillText("WHAT IS BEING SAD ALL ABOUT?", 150, 550);
          backGroundFlash.play();
        }),
        new KeyFrame(Duration.seconds(15.5), event -> {
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "I JUST WANNA WOP", new Font("Arial", 20), Color.WHITE, 220, 132);
        }),
        new KeyFrame(Duration.seconds(16.5), event -> {
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "IS LIFE JUST SUFFERING", new Font("Arial", 20), Color.WHITE, 520, 132);
        }),
        new KeyFrame(Duration.seconds(18.5), event -> {
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "WHY AM I ALWAYS SORRY", new Font("Arial", 25), Color.WHITE, 525, 332);
        }),
        new KeyFrame(Duration.seconds(19.5), event -> {
          backGroundFlash.stop();
          whiteBlack.play();
        }),
        new KeyFrame(Duration.seconds(20), event -> {
          whiteBlack.stop();
          lineVisualizer.clear();
          scene.setFill(Color.BLACK);
        }),
        new KeyFrame(Duration.seconds(20), event -> {
          gc.setFill(Color.BLACK);
          gc.fillOval(425, 175, 300, 300);
        }),
        new KeyFrame(Duration.seconds(23), event -> {
          whiteBlue.play();
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "EWNIAH", new Font("Arial", 20), Color.WHITE, 545, 325);
        }),
        new KeyFrame(Duration.seconds(25), event -> {
          whiteBlue.stop();
        }),
        new KeyFrame(Duration.seconds(26.5), event -> {
          whiteBlackTwo.play();
        }),
        new KeyFrame(Duration.seconds(32.6), event -> {
          backGroundFlash.play();
        }),
        new KeyFrame(Duration.seconds(33), event -> {
          backGroundFlash.stop();
        }),
        new KeyFrame(Duration.seconds(34), event -> {
          backGroundFlash.play();
        }),
        new KeyFrame(Duration.seconds(34.5), event -> {
          backGroundFlash.stop();
          gc.setFill(Color.WHITE);
        }),
        new KeyFrame(Duration.seconds(36), event -> {
          backGroundFlash.play();
        }),
        new KeyFrame(Duration.seconds(36.5), event -> {
          backGroundFlash.stop();
          whiteBlackTwo.stop();
          lineVisualizer.clear();
          scene.setFill(Color.WHITE);
          gc.setFill(Color.BLACK);
          gc.fillOval(425, 175, 300, 300);
        }),

        new KeyFrame(Duration.seconds(38), event -> {
          whiteBlack.play();
        }),
        new KeyFrame(Duration.seconds(38.5), event -> {
          backGroundFlash.play();
        }),
        new KeyFrame(Duration.seconds(40), event -> {
          scene.setFill(Color.WHITE);
          backGroundFlash.stop();
          whiteBlack.stop();
        }),
        new KeyFrame(Duration.seconds(46), event -> {
          whiteBlack.play();
          lineVisualizer.clear();
        }),
        new KeyFrame(Duration.seconds(47), event -> {
          whiteBlack.stop();
        }),
        new KeyFrame(Duration.seconds(52.5), event -> {
          backGroundFlash.play();
        }),
        new KeyFrame(Duration.seconds(53.5), event -> {
          backGroundFlash.stop();
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "EWNIAH", new Font("Arial", 30), Color.WHITE, 464, 335);
          scene.setFill(Color.PINK);
        }),
        new KeyFrame(Duration.seconds(55.5), event -> {
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "ACCEPTANCE", new Font("Arial", 30), Color.WHITE, 264, 535);
        }),
        new KeyFrame(Duration.seconds(56.5), event -> {
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "ANGER", new Font("Arial", 30), Color.WHITE, 600, 225);
        }),
        new KeyFrame(Duration.seconds(58.5), event -> {
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "PAIN", new Font("Arial", 30), Color.WHITE, 376, 225);
        }),
        new KeyFrame(Duration.seconds(60.5), event -> {
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "LOVE", new Font("Arial", 30), Color.WHITE, 600, 325);
          lineVisualizer.stop();
        }),
        new KeyFrame(Duration.seconds(62.5), event -> {
          TextPrinter.print(lineVisualizer.getGraphicsContext2D(), "PASSION", new Font("Arial", 30), Color.WHITE, 600, 425);
        }),
        new KeyFrame(Duration.seconds(66.5), event -> {
          lineVisualizer.start();
        }),
        new KeyFrame(Duration.seconds(80), event -> {
          lineVisualizer.clear();
          scene.setFill(Color.BLACK);
          lineVisualizer.stop();
        })
    );
    animation.play();
  }
}