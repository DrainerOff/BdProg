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

public class EpisodeAddingController {

    @FXML
    private TextField EpisodeNumberField;

    @FXML
    private TextField EpisodeNameField;

    @FXML
    private Button EpisodeAddButton;

    @FXML
    private TextField EpisodeSeasonIdField;

    @FXML
    private Button BackButton;


    @FXML
    void initialize() {
        EpisodeAddButton.setOnAction(event -> {

            DatabaseHandler db = new DatabaseHandler();
            try {
                db.addEpisode(EpisodeNumberField.getText(), EpisodeNameField.getText(), EpisodeSeasonIdField.getText());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        BackButton.setOnAction(event -> {
            BackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/EpisodesInterface/EpisodesTable.fxml"));

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

