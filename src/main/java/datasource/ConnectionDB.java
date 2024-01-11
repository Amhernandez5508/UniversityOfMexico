package datasource;

import utilities.PropertiesFileGenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This interface manages the database connection by providing a method to establish a connection.
 */
public interface ConnectionDB {

    /**
     * Establishes a connection to the database using the properties defined in the "database.properties" file.
     *
     * @return A database connection if successful; otherwise, returns null.
     */
    static Connection connect() {
        Properties properties = PropertiesFileGenerator.generate("database.properties");

        try {
            Connection connection = DriverManager.getConnection(properties.getProperty("db.urlConnection"),
                    properties.getProperty("db.username"), properties.getProperty("db.password"));
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}