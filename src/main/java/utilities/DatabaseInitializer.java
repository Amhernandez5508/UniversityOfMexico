package utilities;

import view.UserInterface;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

/**
 * Utility class for initializing the system's database.
 */
public class DatabaseInitializer {

    /**
     * Initializes the system's database by executing SQL scripts.
     * This method reads database properties, such as username and password,
     * and uses them to initialize the database.
     */
    public static void init() {
        // Get necessary resources and properties
        ClassLoader classLoader = DatabaseInitializer.class.getClassLoader();
        URL relativeUrlDbCreateFile = classLoader.getResource("scripts/db/dbCreate.sql");
        URL relativeUrlDatabaseProperties = classLoader.getResource("database.properties");
        Properties prop = new Properties();

        try {
            // Obtain absolute file paths
            String absoluteUrlDbCreateFile = new File(relativeUrlDbCreateFile.toURI()).getAbsolutePath();
            String absoluteUrlDatabaseProperties = new File(relativeUrlDatabaseProperties.toURI()).getAbsolutePath();
            prop.load(new FileInputStream(absoluteUrlDatabaseProperties));
            String DBUsername = prop.getProperty("db.username");
            String DBPassword = "-p" + prop.getProperty("db.password");

            // Set up the process to initialize the database
            ProcessBuilder processBuilder = new ProcessBuilder("mysql", "-u", DBUsername, DBPassword);
            processBuilder.redirectErrorStream(true);
            processBuilder.redirectInput(new File(absoluteUrlDbCreateFile));

            // Start the database initialization process
            UserInterface.showMessage("\nInicializando base de datos del sistema...");
            Process process = processBuilder.start();

            // Wait for the process to complete and check its exit code
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                // Database initialization was successful
                UserInterface.showMessage("Base de datos inicializada con éxito.\n\n");

            } else {
                // Display error messages if initialization failed
                UserInterface.showMessageError("Ha ocurrido un error durante la inicialización de la base de datos. Código de error: " + exitCode);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.err.println(line);
                }

            }

        } catch (URISyntaxException | IOException | InterruptedException e) {
            // Print stack trace if an exception occurs
            e.printStackTrace();
        }
    }
}
