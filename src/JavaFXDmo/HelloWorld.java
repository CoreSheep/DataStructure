package JavaFXDmo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class HelloWorld extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane stackPane = new StackPane();
        Button btn  = new Button();
        btn.setText("Press me!");
        btn.setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent e){
                System.out.println("Hello world!");
            }
        });
        stackPane.getChildren().add(btn);
        Scene scene = new Scene(stackPane, 300, 300);
        primaryStage.setTitle("Hello world");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
