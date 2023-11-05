package domain;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Esta clase proporciona una conexión a la base de datos a través de JDBC.
 */
public class DBConnection {


    private static Connection connection;


    private static Logger logger;


    static {
        logger = Logger.getLogger(DBConnection.class.getName());

        //Declaración de variables para la configuración de la conexión a la base de datos.
        String url;
        String user;
        String pass;
        Properties properties = new Properties();
        try {
            //Se carga la configuración de la base de datos desde un archivo de propiedades.
            InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("bbdd.properties");
            properties.load(inputStream);
            //Se construye la URL de conexión usando los valores del archivo de propiedades.
            url = "jdbc:mysql://" + properties.get("host") + ":" + properties.get("port") + "/" + properties.get("dbname");
            user = (String) properties.get("user");
            pass = (String) properties.get("pass");
        } catch (IOException e) {
            //En caso de error al cargar la configuración se lanza una excepción de tiempo de ejecución.
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Connection getConnection() {
        return connection;
    }
}
