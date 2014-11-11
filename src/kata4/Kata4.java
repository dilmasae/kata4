package kata4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Kata4 {

    public static void main(String[] args) throws SQLException{
        Connection connection = createConnection("people.db");
        PersonLoader loader = new DatabasePersonLoader(connection);
        HistogramBuilder<Person> buider = new HistogramBuilder<>(loader.load());
        new ConsoleHistogramViewer<String>().show(buider.build(new AttributeExtractor<Person, String>() {
            //clase anonima
            @Override
            public String extract(Person entity) {
                return entity.getMail().getDomain();
            }
        }));
        
    }

    private static Connection createConnection(String dbPath) throws SQLException{
        DriverManager.registerDriver(new org.sqlite.JDBC());
        //sirve para hacer la conexion con el sqlite
        //---------------------------------cadena de conexión
        return DriverManager.getConnection("jdbc:sqlite:" + dbPath);
        
    }
    
}
