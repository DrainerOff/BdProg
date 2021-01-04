package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class EventAddingController {

    @FXML
    private TextField EventNameField;

    @FXML
    private TextField DescriptionEventField;

    @FXML
    private Button EventAddButton;

    @FXML
    private TextField StoryArcsIdField;

    @FXML
    private TextField LocationIdField;

    @FXML
    private TextField EventArcsIdField;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        EventAddButton.setOnAction(event ->{

            DatabaseHandler db = new DatabaseHandler();
            try {
                db.addEvent(EventNameField.getText(),DescriptionEventField.getText(),EventArcsIdField.getText(),StoryArcsIdField.getText(),LocationIdField.getText());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        BackButton.setOnAction(event -> {
            BackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/IventsInterface/EventsTable.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }


            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}
