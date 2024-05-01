package test;


import javafx.util.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

   private DoubleProperty startX = new SimpleDoubleProperty();
    private DoubleProperty startY = new SimpleDoubleProperty();
    private DoubleProperty shownX = new SimpleDoubleProperty();
    private DoubleProperty shownY = new SimpleDoubleProperty();

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Circle ball = new Circle(10, Color.RED);
        ball.centerXProperty().bind(shownX);
        ball.centerYProperty().bind(shownY);
        
        // Create a Timeline
        Timeline timeline = new Timeline();
        
        // Set the duration between each execution (e.g., 100 milliseconds)
        Duration duration = Duration.millis(100);
        
        // Create a KeyFrame with the specified duration
        KeyFrame keyFrame = new KeyFrame(duration, event -> {
            // Update the ball's position
            double x = shownX.get();
            double y = shownY.get();

            double dx = 5;
            double dy = 5;

            if (x < 0 || x > 200) {
                dx = -dx;
            }
            if (y < 0 || y > 200) {
                dy = -dy;
            }


            shownX.set(x + dx);
            shownY.set(y + dy);
        });

        // Add the KeyFrame to the Timeline
        timeline.getKeyFrames().add(keyFrame);

        // Set the cycle count of the Timeline
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Create a Pane
        Pane pane = new Pane();
        pane.setPrefSize(200, 200);
        pane.getChildren().add(ball);

        timeline.play();

        primaryStage.setTitle("Bouncing Ball");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    
}