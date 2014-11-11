package kata4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Kata4 {

    public static void main(String[] args) throws SQLException{
        Connection connection = createConnection("people.db");
        PersonLoader loader = new DatabasePersonLoader(connection);
        HistogramBuilder<Person> buider = new HistogramBuilder<>(loader.load());
        new ConsoleHistogramViewer<Person>().show(buider.build());
        
    }

    private static Connection createConnection(String dbPath) throws SQLException{
        DriverManager.registerDriver(new org.sqlite.JDBC());
        //sirve para hacer la conexion con el sqlite
        //---------------------------------cadena de conexión
        return DriverManager.getConnection("jdbc:sqlite:" + dbPath);
        
    }
    
}
