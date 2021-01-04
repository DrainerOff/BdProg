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
import java.util.ResourceBundle;

public class CharactersTableController {
    public String CharacterString;
    public String CharactersChangeId;
    public ArrayList<String> _Pool;


    @FXML
    private ResourceBundle resources;

    @FXML
    private ListView CharactersNames;

    @FXML
    private Button ShowCharacters;

    @FXML
    private Button AddCharacter;

    @FXML
    private Button BackButton;

    @FXML
    private Button CharacterChangeButton;

    @FXML
    private Button CharacterDeleteButton;



    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        DatabaseHandler db = new DatabaseHandler();

        ShowCharacters.setOnAction(event -> {
            ArrayList<String> _NamesPool = new ArrayList();
            try {
                _NamesPool = db.ShowCharacters();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            CharactersNames.getItems().clear();
            CharactersNames.getItems().addAll(_NamesPool);
        });



        CharacterChangeButton.setOnAction(event -> {
            CharacterChangeButton.getScene().getWindow().hide();

            ArrayList<String> _Pool = new ArrayList();
            try {
                _Pool = db.ShowCharacters();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            CharacterString = (String) CharactersNames.getSelectionModel().getSelectedItem();

            int count = 0;

            for(String obj : _Pool) {
                if (obj.equals(CharacterString)) {
                    CharactersChangeId = db._CharactersIdPool.get(count);
                }
                count++;
            }

            db.CharacterString = CharacterString;
            db.CharactersChangeId = CharactersChangeId;

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ActorsInterface/ChangingCharacter.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            CharacterChangingController Editer = loader.getController();
            Editer.setData(CharacterString, CharactersChangeId);

            stage.show();
        });

        AddCharacter.setOnAction(event -> {
            AddCharacter.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ChatactersInterface/AddingCharacter.fxml"));

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

        CharacterDeleteButton.setOnAction(event ->{
            ArrayList<String> _Pool = new ArrayList();
            String str = (String) CharactersNames.getSelectionModel().getSelectedItem();
            int index;
            try {
                _Pool = db.ShowCharacters();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            int count = 0;

            for(String obj : _Pool){
                if(obj.equals(str)){
                    try {
                        db.deleteCharacter(db._CharactersIdPool.get(count));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                count++;
            }


            ArrayList<String> _NamesPool = new ArrayList();
            try {
                _NamesPool = db.ShowCharacters();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            CharactersNames.getItems().clear();
            CharactersNames.getItems().addAll(_NamesPool);

        });
    }
}
