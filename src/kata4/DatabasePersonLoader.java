package kata4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DatabasePersonLoader  implements PersonLoader{
    
    private final Connection connection;

    public DatabasePersonLoader(Connection connection) {
        this.connection = connection;
    }
   
    @Override
    public Person[] load() {
        try {
            return processPeople(connection.createStatement().executeQuery("SELECT* FROM people"));
        } catch (SQLException ex) {
            return new Person[0];
        }
                
    }

    private Person[] processPeople(ResultSet resulSet) throws SQLException {
        ArrayList<Person> personList = new ArrayList<>();
        while(resulSet.next())
            personList.add(processPerson(resulSet));
        return personList.toArray(new Person[personList.size()]);
    }

    private Person processPerson(ResultSet resulSet) throws SQLException {
        return new Person(
                resulSet.getString("first_name"),
                resulSet.getString("last_name"),
                resulSet.getString("company_name"),
                resulSet.getString("address"),
                resulSet.getString("city"),
                resulSet.getString("state"),
                new Mail(resulSet.getString("email")),
                resulSet.getString("web"));
    }
}
