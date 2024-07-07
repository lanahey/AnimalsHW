package tables;

import animals.Animal;
import db.IDBConnector;
import db.MySQLDBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class AbsTable {

    public AbsTable(String name){
        this.name = name;
    }

    public IDBConnector idbConnector = new MySQLDBConnector();

    private String name ="";

    public void createTable(/*List<String> columns*/) throws SQLException {
        if (!isTableExist()) {
            String sqlRequest = String.format("CREATE TABLE IF NOT EXISTS %s;", name, String.join(","));
            idbConnector.execute(sqlRequest);
        }
    }

    private boolean isTableExist() throws SQLException {
        String sqlRequest = String.format("SELECT * FROM information_schema.tables WHERE table_name = '%s' LIMIT 1;", name);
        ResultSet resultSet = idbConnector.executeQuery(sqlRequest);

        while(resultSet.next()){
            if(resultSet.getString(1).equals(name)){
                return true;
            }
        }
        return false;
    }

    public ResultSet selectAll() throws SQLException {
        String sqlRequest = String.format("SELECT * FROM %s ;", name);
        idbConnector.executeQuery(sqlRequest);
        return null;
    }

    /*public void resultList() throws SQLException {
        String sqlRequest = String.format("SELECT * FROM %s;", name);
        idbConnector.execute(sqlRequest);
    }*/

   /* private ArrayList<Animal> selectResult(String sqlRequest) throws SQLException {
        ArrayList<Animal> animals = new ArrayList<>();
        ResultList resultList = idbConnector.executeQuery(sqlRequest);
        try{
            while (resultList.next()) {
                animals.add(new Animal(
                        resultList.getLong("id"),

                        ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }*/

}
