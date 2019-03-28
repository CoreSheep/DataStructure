package JavaFXDmo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoginWindows extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //create a root panel
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        //set vertical gap and horizontal gap
        grid.setVgap(5);
        grid.setHgap(5);
        final PasswordField password = new PasswordField();
        //create a tooltip for a password to remind user how to set a correct password
        final Tooltip tooltip = new Tooltip();
        tooltip.setText("\nYour password must be\n" +
                "at least 8 characters in length\n");


        password.setTooltip(tooltip);
        Label label1 = new Label("Username:");
        Label label2 = new Label("Password:");

        //add label and textfield into a HBox
        HBox hb = new HBox();
        TextField textField = new TextField ();
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(10);

        HBox hb2  = new HBox(10);
        hb2.getChildren().addAll(label2, password);
        hb2.setSpacing(10);

        grid.add(hb, 0, 2 );
        grid.add(hb2, 0, 3);

        //add gridpane into scene and show the stage
        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Page");
        primaryStage.show();


    }
}
