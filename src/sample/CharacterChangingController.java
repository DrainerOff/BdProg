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

public class CharacterChangingController {
    @FXML
    private TextField ActorNameField;

    @FXML
    private TextField CharacterUrlField;

    @FXML
    private TextField CharacterBioField;

    @FXML
    private Button CharacterChangeButton;

    @FXML
    private TextField CharacterEventIdField;

    @FXML
    private TextField CharacterFractionIdField;

    @FXML
    private Button BackButton;

    String ActId;

    DatabaseHandler db = new DatabaseHandler();
    String[] ActorsParts;

    public void setData(String str,String id){
        db.CharacterString = str;
        db.CharactersChangeId = id;
        String[] CharactersParts = str.split("  ");
        ActorNameField.setText(CharactersParts[0]);
        CharacterUrlField.setText(CharactersParts[1]);
        CharacterBioField.setText(CharactersParts[2]);
        CharacterFractionIdField.setText(CharactersParts[3]);
    }

    @FXML
    void initialize() {
        CharacterChangeButton.setOnAction(event ->{

            String newStr = ActorNameField.getText() + "  " + CharacterUrlField.getText() + "  " + CharacterBioField.getText() + "  " + CharacterFractionIdField.getText();
            try {
                db.changeCharacter(newStr,db.getCharacterChangeId());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            BackButton.fire();


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
