package sample;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/my_database?useSSL=false";
        String user = "root";
        String password = "471119";
        String DB_Driver = "org.gjt.mm.mysql.Driver";

        Class.forName(DB_Driver);
        dbConnection = DriverManager.getConnection(url, user, password);
        return dbConnection;
    }

    public void addActor(String name, String age, String bio)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.ACTOR_TABLE + "("
                + Const.ACTORS_AGE + ","
                + Const.ACTORS_Biography + ","
                + Const.ACTORS_FULL_NAME + ")"
                + "VALUES(?,?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, name);
        prSt.setString(2, age);
        prSt.setString(3, bio);

        prSt.executeUpdate();
    }

    public void addCharacter(String name, String url, String biog, String char_event_id, String char_fraction_id)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.CHARACTER_TABLE + "("
                + Const.CHARACTERS_FULL_NAME + ","
                + Const.CHARACTERS_URL + ","
                + Const.CHARACTERS_BIOGRAPHY + ","
                + Const.CHARACTERS_EVENT_ID + ","
                + Const.CHARACTERS_FRACTION_ID + ")"
                + "VALUES(?,?,?,?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, name);
        prSt.setString(2, url);
        prSt.setString(3, biog);
        prSt.setString(4, char_event_id);
        prSt.setString(5, char_fraction_id);
        prSt.executeUpdate();
    }

    public void addEpisode(String number, String name, String seasonId)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.EPISODES_TABLE + "("
                + Const.EPISODE_NUMBER + ","
                + Const.EPISODE_NAME + ","
                + Const.SEASON_ID + ")"
                + "VALUES(?,?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, number);
        prSt.setString(2, name);
        prSt.setString(3, seasonId);
        prSt.executeUpdate();
    }

    public void addEvent(String name, String descrip, String event_id, String sroty_arc_id, String location_id)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.EVENTS_TABLE + "("
                + Const.EVENT_NAME + ","
                + Const.EVENT_DESCRIPTION + ","
                + Const.EVENT_ID + ","
                + Const.EVENT_STORY_ARC_ID + ","
                + Const.EVENT_LOCATION_ID + ")"
                + "VALUES(?,?,?,?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, name);
        prSt.setString(2, descrip);
        prSt.setString(3, event_id);
        prSt.setString(4, sroty_arc_id);
        prSt.setString(5, location_id);
        prSt.executeUpdate();
    }

    public void addFilmCrewMembers(String name, String age, String id, String team_id)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.FILM_CREW_MEMBERS_TABLE + "("
                + Const.FILM_CREW_MEMBERS_NAME + ","
                + Const.FILM_CREW_MEMBERS_AGE + ","
                + Const.FILM_CREW_MEMBERS_ID + ","
                + Const.FILM_CREW_MEMBERS_TEAM_ID + ")"
                + "VALUES(?,?,?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, name);
        prSt.setString(2, age);
        prSt.setString(3, id);
        prSt.setString(4, team_id);
        prSt.executeUpdate();
    }

    public void addFraction(String name, String biogrf, String isItNeagative)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.FRACTIONS_TABLE + "("
                + Const.FRACTION_NAME + ","
                + Const.FRACTION_BIOGRAPHY + ","
                + Const.FRACTION_IS_IT_NEGATIVE + ")"
                + "VALUES(?,?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, name);
        prSt.setString(2, biogrf);
        prSt.setString(3, isItNeagative);
        prSt.executeUpdate();
    }

    public void addLocation(String name)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.LOCATIONS_TABLE + "("
                + Const.LOCATION_NAME + ")"
                + "VALUES(?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, name);
        prSt.executeUpdate();
    }

    public void addSeason(String number, String name, String showsId)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.SEASONS_TABLE + "("
                + Const.SEASON_NUMBER + ","
                + Const.SEASON_NAME + ","
                + Const.SEASON_SHOWS_ID + ")"
                + "VALUES(?,?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, number);
        prSt.setString(2, name);
        prSt.setString(3, showsId);
        prSt.executeUpdate();
    }

    public void addShow(String date, String annotation, String name, String teamId)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.SHOWS_TABLE + "("
                + Const.SHOW_RELEASE_DATE + ","
                + Const.SHOW_ANNOTATION + ","
                + Const.SHOW_NAME + ","
                + Const.SHOW_TEAM_ID + ")"
                + "VALUES(?,?,?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, date);
        prSt.setString(2, annotation);
        prSt.setString(3, name);
        prSt.setString(3, teamId);
        prSt.executeUpdate();
    }

    public void addStoryArcs(String name, String description, String seasonId)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.STORY_ARCS_TABLE + "("
                + Const.STORY_ARC_NAME + ","
                + Const.STORY_ARC_DESCRIPTION + ","
                + Const.STORY_ARC_SEASON_ID + ")"
                + "VALUES(?,?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, name);
        prSt.setString(2, description);
        prSt.setString(3, seasonId);
        prSt.executeUpdate();
    }

    public void addTypesOfActors(String type, String actrId, String charId)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.TYPES_OF_ACTORS_TABLE + "("
                + Const.TYPES_OF_ACTOR_TYPE + ","
                + Const.TYPES_OF_ACTOR_ACTORS_ID + ","
                + Const.TYPES_OF_ACTOR_CHARACTER_ID + ")"
                + "VALUES(?,?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, type);
        prSt.setString(2, actrId);
        prSt.setString(3, charId);
        prSt.executeUpdate();
    }

    public void addTypesOfFilmCrewMembers(String teamId, String role)
            throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.TYPES_OF_FILM_CREW_MEMBERS_TABLE + "("
                + Const.TYPES_OF_FILM_CREW_MEMBERS_TEAM_ID + ","
                + Const.TYPES_OF_FILM_CREW_MEMBERS_ROLE + ")"
                + "VALUES(?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, teamId);
        prSt.setString(2, role);
        prSt.executeUpdate();
    }

    private ArrayList<String> _ActorsPool = new ArrayList();
    public ArrayList<String> _ActorsIdPool = new ArrayList();

    public ArrayList ShowActors() throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM my_database.actors;";

        dbConnection = getDbConnection();
        Statement stmt = dbConnection.createStatement();
        ResultSet result = stmt.executeQuery(SQL);
        String name = new String();

        _ActorsPool.removeAll(_ActorsPool);
        _ActorsIdPool.removeAll(_ActorsIdPool);

        while (result.next()) {
            _ActorsPool.add(result.getString(1) + "  " +
                    result.getString(2) + "  " +
                    result.getString(3));
            _ActorsIdPool.add(result.getString(4));
        }


        dbConnection.close();
        return _ActorsPool;
    }

    private ArrayList<String> _CharactersPool = new ArrayList();
    public ArrayList<String> _CharactersIdPool = new ArrayList();

    public ArrayList ShowCharacters() throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM my_database.characters;";

        dbConnection = getDbConnection();
        Statement stmt = dbConnection.createStatement();
        ResultSet result = stmt.executeQuery(SQL);
        String name = new String();

        _CharactersPool.removeAll(_CharactersPool);
        _CharactersIdPool.removeAll(_CharactersIdPool);

        while (result.next()) {
            _CharactersPool.add(result.getString(1) + " " +
                    result.getString(2) + " " +
                    result.getString(3) + " " +
                    result.getString(5) + " " +
                    result.getString(6));
            _CharactersIdPool.add(result.getString(4));
        }

        dbConnection.close();
        return _CharactersPool;
    }

    private ArrayList<String> _EpisodesPool = new ArrayList();

    public ArrayList ShowEpisodes() throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM my_database.episodes;";

        dbConnection = getDbConnection();
        Statement stmt = dbConnection.createStatement();
        ResultSet result = stmt.executeQuery(SQL);
        String name = new String();

        while (result.next()) {
            _EpisodesPool.add(result.getString(1) + "  " +
                    result.getString(2) + "  " +
                    result.getString(3));
        }

        dbConnection.close();
        return _EpisodesPool;
    }

    private ArrayList<String> _EventsPool = new ArrayList();

    public ArrayList ShowEvents() throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM my_database.events;";

        dbConnection = getDbConnection();
        Statement stmt = dbConnection.createStatement();
        ResultSet result = stmt.executeQuery(SQL);
        String name = new String();

        while (result.next()) {
            _EventsPool.add(result.getString(1) + " " +
                    result.getString(2) + " " +
                    result.getString(4) + " " +
                    result.getString(5));
        }

        dbConnection.close();
        return _EventsPool;
    }

    private ArrayList<String> _FilmCrewMembersPool = new ArrayList();
    public ArrayList<String> _FilmCrewMembersIdPool = new ArrayList();

    public ArrayList ShowFilmCrewMembers() throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM my_database.film_crew_members;";

        dbConnection = getDbConnection();
        Statement stmt = dbConnection.createStatement();
        ResultSet result = stmt.executeQuery(SQL);
        String name = new String();

        _FilmCrewMembersPool.removeAll(_FilmCrewMembersPool);
        _FilmCrewMembersIdPool.removeAll(_FilmCrewMembersIdPool);

        while (result.next()) {
            _FilmCrewMembersPool.add(result.getString(1) + "  " +
                    result.getString(2) + "  " +
                    result.getString(4));
            _FilmCrewMembersIdPool.add(result.getString(3));
        }

        dbConnection.close();
        return _FilmCrewMembersPool;
    }

    private ArrayList<String> _FractionsPool = new ArrayList();

    public ArrayList ShowFractions() throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM my_database.fractions;";

        dbConnection = getDbConnection();
        Statement stmt = dbConnection.createStatement();
        ResultSet result = stmt.executeQuery(SQL);
        String name = new String();

        while (result.next()) {
            _FractionsPool.add(result.getString(1) + " " +
                    result.getString(2) + " " +
                    result.getString(3));
        }

        dbConnection.close();
        return _FractionsPool;
    }

    private ArrayList<String> _LocationsPool = new ArrayList();

    public ArrayList ShowLocations() throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM my_database.locations;";

        dbConnection = getDbConnection();
        Statement stmt = dbConnection.createStatement();
        ResultSet result = stmt.executeQuery(SQL);
        String name = new String();

        while (result.next()) {
            _LocationsPool.add(result.getString(1));
        }

        dbConnection.close();
        return _LocationsPool;
    }

    private ArrayList<String> _ShowsPool = new ArrayList();

    public ArrayList ShowShows() throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM my_database.shows;";

        dbConnection = getDbConnection();
        Statement stmt = dbConnection.createStatement();
        ResultSet result = stmt.executeQuery(SQL);
        String name = new String();

        while (result.next()) {
            _ShowsPool.add(result.getString(1) + " " +
                    result.getString(2) + " " +
                    result.getString(3) + " " +
                    result.getString(5));
        }

        dbConnection.close();
        return _ShowsPool;
    }

    private ArrayList<String> _StoryArcsPool = new ArrayList();

    public ArrayList ShowStoryArcs() throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM my_database.story_arcs;";

        dbConnection = getDbConnection();
        Statement stmt = dbConnection.createStatement();
        ResultSet result = stmt.executeQuery(SQL);
        String name = new String();

        while (result.next()) {
            _StoryArcsPool.add(result.getString(1) + " " +
                    result.getString(2) + " " +
                    result.getString(4));
        }

        dbConnection.close();
        return _StoryArcsPool;
    }

    private ArrayList<String> _TypesOfActorsPool = new ArrayList();

    public ArrayList ShowTypesOfActors() throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM my_database.types_of_actors;";

        dbConnection = getDbConnection();
        Statement stmt = dbConnection.createStatement();
        ResultSet result = stmt.executeQuery(SQL);
        String name = new String();

        while (result.next()) {
            _TypesOfActorsPool.add(result.getString(1) + " " +
                    result.getString(2) + " " +
                    result.getString(3));
        }

        dbConnection.close();
        return _TypesOfActorsPool;
    }

    private ArrayList<String> _TypesOfFilmCrewMembersPool = new ArrayList();

    public ArrayList ShowTypesOfFilmCrewMembers() throws SQLException, ClassNotFoundException {
        String SQL = "SELECT * FROM my_database.types_of_film_crew_members;";

        dbConnection = getDbConnection();
        Statement stmt = dbConnection.createStatement();
        ResultSet result = stmt.executeQuery(SQL);
        String name = new String();

        while (result.next()) {
            _TypesOfFilmCrewMembersPool.add(result.getString(1) + " " +
                    result.getString(2));
        }

        dbConnection.close();
        return _TypesOfFilmCrewMembersPool;
    }

    public void deleteActor(String id)
            throws SQLException, ClassNotFoundException {
        String delete = "DELETE FROM `my_database`.`actors` WHERE (`Actors_id` = " + id + ");";

        PreparedStatement prSt = getDbConnection().prepareStatement(delete);
        prSt.executeUpdate();
    }

    public void deleteCharacter(String id)
            throws SQLException, ClassNotFoundException {
        String delete = "DELETE FROM `my_database`.`characters` WHERE (`Character_id` = " + id + ");";

        PreparedStatement prSt = getDbConnection().prepareStatement(delete);
        prSt.executeUpdate();
    }

    public void deleteFilmCrewMember(String id)
            throws SQLException, ClassNotFoundException {
        String delete = "DELETE FROM `my_database`.`film_crew_members` WHERE (`Film_crew_members_id` = " + id + ");";

        PreparedStatement prSt = getDbConnection().prepareStatement(delete);
        prSt.executeUpdate();
    }



    public void changeActor(String str, String id) throws SQLException, ClassNotFoundException {
        String name,age,bio;
        String[] ActorsParts = str.split("  ");
        name = ActorsParts[0];
        age = ActorsParts[1];
        bio = ActorsParts[2];
        String update = "UPDATE `my_database`.`actors` SET `Actor_Full_name` = '"
                + name + "', `Current_age` = '"
                + age + "', `Biography` = '"
                + bio + "' WHERE (`Actors_id` = '"
                + id +"');";

        PreparedStatement prSt = getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
        dbConnection.close();
    }


    public String ActorString;
    public String ActorsChangeId;
    public String getActorChangeId()
    {
        return ActorsChangeId;
    }



    public String CharacterString;
    public String CharactersChangeId;
    public String getCharacterChangeId()
    {
        return CharactersChangeId;
    }

    public void changeCharacter(String str, String id) throws SQLException, ClassNotFoundException {
        String number,name,biog,eventId,fractionId;
        String[] CharacterParts = str.split("  ");
        number = CharacterParts[0];
        name = CharacterParts[1];
        biog = CharacterParts[2];
        eventId = CharacterParts[3];
        fractionId = CharacterParts[4];

        String update = "UPDATE `my_database`.`characters` SET `Character_Name` = '"
                + number + "', `Photo_URL` = '"
                + name + "', `Biography` = '"
                + biog + "', `Event_id` = '"
                + eventId + "', `Fractions_id` = '"
                + fractionId + "' WHERE (`Character_id` = '"
                + id +"');";

        PreparedStatement prSt = getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
        dbConnection.close();
    }

    public String FilmCrewMemeberString;
    public String FilmCrewMemebersChangeId;
    public String getFilmCrewMemeberChangeId()
    {
        return FilmCrewMemebersChangeId;
    }

    public void changeFilmCrewMemeber(String str, String id) throws SQLException, ClassNotFoundException {
        String name,age,teamId;
        String[] CharacterParts = str.split("  ");
        name = CharacterParts[0];
        age = CharacterParts[1];
        teamId = CharacterParts[2];

        String update = "UPDATE `my_database`.`film_crew_members` SET `Film_crew_members_name` = '"
                + name + "', `Сrew_members_аge` = '"
                + age + "', `Team_id` = '"
                + teamId + "' WHERE (`Film_crew_members_id` = '"
                + id +"');";

        PreparedStatement prSt = getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
        dbConnection.close();
    }


    private ArrayList<String> _ActorsCharactersPool = new ArrayList();

    public ArrayList ShowActorsCharacters(String id) throws SQLException, ClassNotFoundException {
        String shwActChr = "Select Actor_Full_Name,Character_Name from actors" +
                " join types_of_actors on types_of_actors.Actors_id = actors.Actors_id" +
                " join characters on characters.Character_id = types_of_actors.Actors_id" +
                " where actors.Actors_id = " + id + ";";

        dbConnection = getDbConnection();
        Statement stmt = dbConnection.createStatement();
        ResultSet result = stmt.executeQuery(shwActChr);
        String name = new String();
        _ActorsCharactersPool.removeAll(_ActorsCharactersPool);

        while (result.next()) {
            _ActorsCharactersPool.add(result.getString(1) + "  " +
                    result.getString(2));
        }

        dbConnection.close();
        return _ActorsCharactersPool;
    };

    private ArrayList<String> _ShowsForCurrentTeamPool = new ArrayList();

    public ArrayList ShowShowsForCurrentTeam(String id) throws SQLException, ClassNotFoundException {
        String shwActChr = "SELECT Film_crew_members_name, Show_Name FROM film_crew_members" +
                " join types_of_film_crew_members on types_of_film_crew_members.Team_id = film_crew_members.Team_id" +
                " join shows on shows.Team_id = types_of_film_crew_members.Team_id" +
                " where film_crew_members.Team_id = " + id + ";";

        dbConnection = getDbConnection();
        Statement stmt = dbConnection.createStatement();
        ResultSet result = stmt.executeQuery(shwActChr);
        String name = new String();
        _ShowsForCurrentTeamPool.removeAll(_ShowsForCurrentTeamPool);

        while (result.next()) {
            _ShowsForCurrentTeamPool.add(result.getString(1) + "  " +
                    result.getString(2));
        }

        dbConnection.close();
        return _ShowsForCurrentTeamPool;
    };

}






