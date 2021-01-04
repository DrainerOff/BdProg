package sample;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ActorTabelController {

    public String ActorString;
    public String ActorsChangeId;
    public ArrayList<String> _Pool;

    @FXML
    private ResourceBundle resources;

    @FXML
    private ListView ActorsNames;

    @FXML
    private Button ShowActors;

    @FXML
    private Button AddActor;

    @FXML
    private Button ActorDeleteButton;

    @FXML
    private Button ActorChange;

    @FXML
    private Button BackButton;

    @FXML
    private Button ShowActorsCharacters;


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        ActorChange.setDisable(true);

        DatabaseHandler db = new DatabaseHandler();


        ShowActors.setOnAction(event -> {

            ActorChange.setDisable(false);
            ArrayList<String> _NamesPool = new ArrayList();
            try {
                _NamesPool = db.ShowActors();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

                ActorsNames.getItems().clear();
                ActorsNames.getItems().addAll(_NamesPool);
        });

        ShowActorsCharacters.setOnAction(event -> {
            ArrayList<String> _NamesPool = new ArrayList();

            String str = (String) ActorsNames.getSelectionModel().getSelectedItem();

            try {
                _Pool = db.ShowActors();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            int count = 0;

            for(String obj : _Pool){
                if(obj.equals(str)){
                    try {
                        _NamesPool = db.ShowActorsCharacters(db._ActorsIdPool.get(count));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                count++;
            }
            ActorsNames.getItems().clear();
            ActorsNames.getItems().addAll(_NamesPool);
        });

        AddActor.setOnAction(event -> {
            AddActor.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ActorsInterface/AddingActor.fxml"));

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

        ActorDeleteButton.setOnAction(event ->{

            _Pool = new ArrayList();
            String str = (String) ActorsNames.getSelectionModel().getSelectedItem();
            int index;
            try {
                _Pool = db.ShowActors();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            int count = 0;

            for(String obj : _Pool){
                if(obj.equals(str)){
                    try {
                        db.deleteActor(db._ActorsIdPool.get(count));
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
                _NamesPool = db.ShowActors();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            ActorsNames.getItems().clear();
            ActorsNames.getItems().addAll(_NamesPool);

        });

        ActorChange.setOnAction(event -> {
            ActorChange.getScene().getWindow().hide();

            ArrayList<String> _Pool = new ArrayList();
            try {
                _Pool = db.ShowActors();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            ActorString = (String) ActorsNames.getSelectionModel().getSelectedItem();

            int count = 0;

            for(String obj : _Pool) {
                if (obj.equals(ActorString)) {
                    ActorsChangeId = db._ActorsIdPool.get(count);
                }
                count++;
            }


            db.ActorString = ActorString;
            db.ActorsChangeId = ActorsChangeId;

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/ActorsInterface/ChangingActor.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));

                ActorChangingController Editer = loader.getController();
                Editer.setData(ActorString, ActorsChangeId);

                stage.show();
            });

    }

}

