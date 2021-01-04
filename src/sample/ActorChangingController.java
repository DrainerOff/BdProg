package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ActorChangingController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ActorNameField;

    @FXML
    private TextField ActorAgeField;

    @FXML
    private TextField ActorBioField;

    @FXML
    private TextField ActorIdField;

    @FXML
    private Button ActorChangeButton;

    @FXML
    private Button ActorDeleteButton;

    @FXML
    private Button BackButton;

    String ActId;

    DatabaseHandler db = new DatabaseHandler();
    String[] ActorsParts;

    public void setData(String str,String id){
        db.ActorString = str;
        db.ActorsChangeId = id;
        String[] ActorsParts = str.split("  ");
        ActorNameField.setText(ActorsParts[0]);
        ActorAgeField.setText(ActorsParts[1]);
        ActorBioField.setText(ActorsParts[2]);
    }

    @FXML
    void initialize() {
        ActorChangeButton.setOnAction(event -> {

            String newStr = ActorNameField.getText() + "  " + ActorAgeField.getText() + "  " + ActorBioField.getText();
            try {
                db.changeActor(newStr,db.getActorChangeId());
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
            loader.setLocation(getClass().getResource("/ActorsInterface/ActorsTable.fxml"));

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
