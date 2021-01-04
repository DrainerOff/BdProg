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

public class FilmCrewMemberChangingController {

    @FXML
    private TextField FilmCrewMemberNameField;

    @FXML
    private TextField FilmCrewMemberAgeField;

    @FXML
    private Button FilmCrewMemberChangeButton;

    @FXML
    private TextField FilmCrewMemberTeamIdField;

    @FXML
    private TextField FilmCrewMemberIdField;

    @FXML
    private Button BackButton;

    String FlmCrewId;

    DatabaseHandler db = new DatabaseHandler();


    public void setData(String str,String id){
        db.FilmCrewMemeberString = str;
        db.FilmCrewMemebersChangeId = id;
        String[] FlmCrewParts = str.split("  ");
        FilmCrewMemberNameField.setText(FlmCrewParts[0]);
        FilmCrewMemberAgeField.setText(FlmCrewParts[1]);
        FilmCrewMemberTeamIdField.setText(FlmCrewParts[2]);
    }

    @FXML
    void initialize() {
        FilmCrewMemberChangeButton.setOnAction(event ->{

            String newStr = FilmCrewMemberNameField.getText() + "  " + FilmCrewMemberAgeField.getText() + "  " + FilmCrewMemberTeamIdField.getText();
            try {
                db.changeFilmCrewMemeber(newStr,db.getFilmCrewMemeberChangeId());
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
