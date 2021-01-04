package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ActorAddingController {
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
    private Button ActorAddButton;

    @FXML
    private Button ActorDeleteButton;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
       ActorAddButton.setOnAction(event ->{

           DatabaseHandler db = new DatabaseHandler();
           try {
               db.addActor(ActorAgeField.getText(),ActorBioField.getText(),ActorNameField.getText());
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
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
