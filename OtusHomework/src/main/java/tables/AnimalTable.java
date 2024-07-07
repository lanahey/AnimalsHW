package tables;

import animals.Animal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class AnimalTable extends AbsTable {

    private final String name = "animals";

    public AnimalTable() throws SQLException {
        super("animals");
        HashMap<Object, Object> columns = new HashMap<>();
        columns.put("id","bigint PRIMARY KEY AUTO_INCREMENT");
        columns.put("type","varchar(15)");
        columns.put("name","varchar(15)");
        columns.put("color","varchar(15)");
        columns.put("weight","int");
        columns.put("age","int");
        createTable();
    }


    /*public ResultSet selectAll(){
        String sqlRequest = String.format("SELECT * FROM %s ;", name);
        ResultSet resultSet = db.idbConnector.executeQuery(sqlRequest);
        return resultSet;
    }*/

    /*public ArrayList<Animal> selectByType(String type){
        String sqlRequest = String.format("SELECT * FROM %s WHERE type = '%s';", name, type);
        return selectByType(sqlRequest);
    }*/

    /*public void insert (Animal animal){
        String sqlRequest = String.format("INSERT INTO %s (type, name, color, weight, age) " +
                "VALUES ('%s','%s','%s','%d','%d');",
                name, animal.getType(), animal.getName(), animal.getColor(), animal.getWeight(), animal.getAge());
        idbConnector.execute(sqlRequest);
    }*/

    /*public void update (Animal animal){
        String sqlRequest = String.format("UPDATE %s SET " + "type='%s', name='%s', color='%s', weight='%d', age='%d';",
                name, animal.getType(), animal.getName(), animal.getColor(), animal.getWeight(), animal.getAge());
        idbConnector.execute(sqlRequest);
    }*/

    /*public void delete (long id){
        String sqlRequest = String.format("DELETE FROM %s WHERE id='%d';", name, id);
        idbConnector.execute(sqlRequest);
    }*/


    /*public ArrayList<Animal> selectByAny(String param, String type){
        String sqlQuery = String.format("SELECT * FROM %s WHERE %s = '%s';", name, param, type);
        return selectByType(sqlQuery);
    }*/
}
