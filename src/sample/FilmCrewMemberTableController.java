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

public class FilmCrewMemberTableController {

    @FXML
    private Button ShowFilmCrewMembers;

    @FXML
    private ListView FilmCrewMembersNames;

    @FXML
    private Button AddFilmCrewMember;

    @FXML
    private Button BackButton;

    @FXML
    private Button ChangeFilmCrewMemberButton;

    @FXML
    private Button FilmCrewMemeberDeleteButton;

    @FXML
    private Button ShowAllShowsWithCurrentTeam;

    public String FilmCrewMemeberString;
    public String FilmCrewMemebersChangeId;
    public ArrayList<String> _Pool;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        DatabaseHandler db = new DatabaseHandler();

        ShowFilmCrewMembers.setOnAction(event -> {
            ArrayList<String> _NamesPool = new ArrayList();
            try {
                _NamesPool = db.ShowFilmCrewMembers();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            FilmCrewMembersNames.getItems().clear();
            FilmCrewMembersNames.getItems().addAll(_NamesPool);
        });

        ShowAllShowsWithCurrentTeam.setOnAction(event -> {
            ArrayList<String> _NamesPool = new ArrayList();

            String str = (String) FilmCrewMembersNames.getSelectionModel().getSelectedItem();

            try {
                _Pool = db.ShowFilmCrewMembers();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            int count = 0;

            for(String obj : _Pool){
                if(obj.equals(str)){
                    try {
                        _NamesPool = db.ShowShowsForCurrentTeam(db._FilmCrewMembersIdPool.get(count));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                count++;
            }
            FilmCrewMembersNames.getItems().clear();
            FilmCrewMembersNames.getItems().addAll(_NamesPool);
        });

        ChangeFilmCrewMemberButton.setOnAction(event -> {
            ChangeFilmCrewMemberButton.getScene().getWindow().hide();

            ArrayList<String> _Pool = new ArrayList();
            try {
                _Pool = db.ShowFilmCrewMembers();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            FilmCrewMemeberString = (String) FilmCrewMembersNames.getSelectionModel().getSelectedItem();

            int count = 0;

            for(String obj : _Pool) {
                if (obj.equals(FilmCrewMemeberString)) {
                    FilmCrewMemebersChangeId = db._FilmCrewMembersIdPool.get(count);
                }
                count++;
            }

            db.FilmCrewMemeberString = FilmCrewMemeberString;
            db.FilmCrewMemebersChangeId = FilmCrewMemebersChangeId;

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FilmCrewMembersInterface/ChangingFilmCrewMember.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            FilmCrewMemberChangingController Editer = loader.getController();
            Editer.setData(FilmCrewMemeberString, FilmCrewMemebersChangeId);

            stage.show();
        });

        AddFilmCrewMember.setOnAction(event -> {
            AddFilmCrewMember.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FilmCrewMembersInterface/AddingFilmCrewMember.fxml"));

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


    FilmCrewMemeberDeleteButton.setOnAction(event ->{
        ArrayList<String> _Pool = new ArrayList();
        String str = (String) FilmCrewMembersNames.getSelectionModel().getSelectedItem();
        int index;
        try {
            _Pool = db.ShowFilmCrewMembers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int count = 0;

        for(String obj : _Pool){
            if(obj.equals(str)){
                try {
                    db.deleteFilmCrewMember(db._FilmCrewMembersIdPool.get(count));
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
            _NamesPool = db.ShowFilmCrewMembers();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        FilmCrewMembersNames.getItems().clear();
        FilmCrewMembersNames.getItems().addAll(_NamesPool);

    });
    }
}
