package controller;

import model.Researcher;
import service.ResearcherService;
import service.SerpApiService;
import view.UserInterface;

import java.util.List;

/**
 * Controller class responsible for managing researcher-related operations
 * between the user interface, service layer, and data model.
 */
public class ResearcherController {

    /**
     * Initializes the researcher controller by presenting options to the user
     * and performing actions based on the user's selection.
     */
    public void init() {

        // Present options to the user and retrieve their selection
        Integer selection = UserInterface.showOptions();
        List<Researcher> top10Researchers;

        // Perform actions based on the user's selection
        switch (selection) {
            case 1:
                // Retrieve top 10 researchers' data using SerpApiService
                UserInterface.showMessage("\nRecuperando datos...");
                top10Researchers = SerpApiService.getTop10Researchers();

                // Save retrieved researchers to the database using ResearcherService
                if (ResearcherService.saveAllResearchers(top10Researchers)) {
                    // Display success message if data is successfully loaded
                    UserInterface.showMessage("\nLos datos han sido cargados de manera exitosa en la base de datos.");

                } else {
                    // Display error message if data loading fails
                    UserInterface.showMessageError("\nHa ocurrido un error durante la carga de los datos. Por favor, " +
                            "contacte al administrador del sistema.");
                }
                break;

            case 2:
                // Display a message indicating session closure
                UserInterface.showMessage("Se ha cerrado la sesión");
                break;

            default:
                break;
        }
    }
}

