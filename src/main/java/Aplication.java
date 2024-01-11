import controller.ResearcherController;
import utilities.DatabaseInitializer;

/**
 * Main class responsible for initiating and running the application.
 */
public class Aplication {

    /**
     * The main method, starting point of the application.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Initialize and set up the database
        DatabaseInitializer.init();

        // Create an instance of ResearcherController and start the application
        ResearcherController researcherController = new ResearcherController();
        researcherController.init();
    }
}