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

public class CharacterAddingController {
    @FXML
    private TextField ActorNameField;

    @FXML
    private TextField CharacterUrlField;

    @FXML
    private TextField CharacterBioField;

    @FXML
    private Button CharacterAddButton;

    @FXML
    private TextField CharacterEventIdField;

    @FXML
    private TextField CharacterFractionIdField;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        CharacterAddButton.setOnAction(event ->{

            DatabaseHandler db = new DatabaseHandler();
            try {
                db.addCharacter(ActorNameField.getText(),CharacterUrlField.getText(),CharacterBioField.getText(),
                        CharacterEventIdField.getText(), CharacterFractionIdField.getText());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        BackButton.setOnAction(event -> {
            BackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ChatactersInterface/CharactersTable.fxml"));

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
