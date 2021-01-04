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

public class FilmCrewMemebrAddingController {

    @FXML
    private TextField FilmCrewMemberNameField;

    @FXML
    private TextField FilmCrewMemberAgeField;

    @FXML
    private Button FilmCrewMemberAddButton;

    @FXML
    private TextField FilmCrewMemberTeamIdField;

    @FXML
    private TextField FilmCrewMemberIdField;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        FilmCrewMemberAddButton.setOnAction(event ->{

            DatabaseHandler db = new DatabaseHandler();
            try {
                db.addFilmCrewMembers(FilmCrewMemberNameField.getText(),FilmCrewMemberAgeField.getText(),FilmCrewMemberIdField.getText(),FilmCrewMemberTeamIdField.getText());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        BackButton.setOnAction(event -> {
            BackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FilmCrewMembersInterface/FilmCrewMembersTable.fxml"));

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
