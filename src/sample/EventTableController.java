package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventTableController {

    @FXML
    private Button ShowEvents;

    @FXML
    private ListView EventsNames;

    @FXML
    private Button AddEvent;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        DatabaseHandler db = new DatabaseHandler();

        ShowEvents.setOnAction(event -> {
            ArrayList<String> _NamesPool = new ArrayList();
            try {
                _NamesPool = db.ShowEvents();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            EventsNames.getItems().addAll(_NamesPool);
        });

        AddEvent.setOnAction(event -> {
            AddEvent.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/IventsInterface/AddingEvent.fxml"));

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

        BackButton.setOnAction(event -> {
            BackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample.fxml"));

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


