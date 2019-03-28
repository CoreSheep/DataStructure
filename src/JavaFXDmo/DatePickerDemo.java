package JavaFXDmo;

import javafx.application.Application;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Locale;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class DatePickerDemo extends Application {

    private Stage stage;
    private DatePicker checkInDatePicker;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        launch(args);  //? What does it means?
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("DatePickerSample ");
        initUI();
        stage.show();
    }

    private void initUI() {
        VBox vbox = new VBox(20);  //
        vbox.setStyle("-fx-padding: 10;");
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);

        //1. create a new datePicker
        checkInDatePicker = new DatePicker();
        checkInDatePicker = new DatePicker(LocalDate.of(1997, 9, 24));
        checkInDatePicker.setShowWeekNumbers(true);


        //2. create a GridPane; which is extremely the same as GridPanel in UWP.
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        //3. add a label on the top of date layout.
        Label checkInlabel = new Label("Check-In Date:");
        gridPane.add(checkInlabel, 0, 0);

        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        gridPane.add(checkInDatePicker, 0, 1);
        vbox.getChildren().add(gridPane);
    }
}