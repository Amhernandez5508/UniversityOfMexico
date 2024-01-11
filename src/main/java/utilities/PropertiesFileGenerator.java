package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

/**
 * Utility class for generating Properties objects from a properties file.
 */
public class PropertiesFileGenerator {

    /**
     * Generates a Properties object from a specified properties file.
     *
     * @param relativeURL The relative URL of the properties file.
     * @return Properties object containing the loaded properties, or null if an error occurs.
     */
    public static Properties generate(String relativeURL) {
        // Obtain the class loader and resource URL for the specified file
        ClassLoader classLoader = PropertiesFileGenerator.class.getClassLoader();
        URL relativeUrlDatabaseProperties = classLoader.getResource(relativeURL);
        Properties properties = new Properties();

        try {
            // Get the absolute path of the properties file
            String absoluteUrlDatabaseProperties = new File(relativeUrlDatabaseProperties.toURI()).getAbsolutePath();

            // Load properties from the file
            properties.load(new FileInputStream(absoluteUrlDatabaseProperties));
            return properties;

        } catch (URISyntaxException | IOException e) {
            // Handle exceptions by printing the stack trace
            e.printStackTrace();
        }

        return null; // Return null if an error occurs during loading
    }
}