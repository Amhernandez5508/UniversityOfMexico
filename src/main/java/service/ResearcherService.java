package service;

import dao.impl.ResearcherDTO;
import model.Researcher;

import java.util.List;

/**
 * Service class responsible for handling operations related to Researcher entities.
 */
public class ResearcherService {
    private static ResearcherDTO researcherDTO = new ResearcherDTO();

    /**
     * Saves a list of researchers to the data repository.
     *
     * @param top10Researchers The list of researchers to be saved.
     * @return true if the save operation is successful, otherwise false.
     */
    public static boolean saveAllResearchers(List<Researcher> top10Researchers) {
        // Utilizes ResearcherDTO to save the list of researchers
        return (researcherDTO.saveAll(top10Researchers) ? true : false);
    }
}
