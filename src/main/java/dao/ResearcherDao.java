package dao;

import java.util.ArrayList;
import java.util.List;

/**
 * This interface defines the contract for Researcher Data Access Object (DAO) operations.
 *
 * @param <Researcher> The type representing the Researcher entity.
 * @param <Long>       The type representing the identifier for the Researcher entity.
 */
public interface ResearcherDao<Researcher, Long> {

    /**
     * Retrieves a researcher by their identifier.
     *
     * @param id The identifier of the researcher.
     * @return The researcher corresponding to the given identifier.
     */
    Researcher getById(Long id);

    /**
     * Retrieves all researchers.
     *
     * @return A list containing all researchers.
     */
    List<Researcher> getAllResearchers();

    /**
     * Saves a researcher.
     *
     * @param researcher The researcher to be saved.
     * @return True if the save operation was successful, false otherwise.
     */
    boolean save(Researcher researcher);

    /**
     * Saves a list of researchers.
     *
     * @param researchers The list of researchers to be saved.
     * @return True if the save operation was successful for all researchers, false otherwise.
     */
    boolean saveAll(List<Researcher> researchers);

    /**
     * Modifies a researcher.
     *
     * @param researcher The researcher to be modified.
     */
    void modify(Researcher researcher);

    /**
     * Deletes a researcher by their identifier.
     *
     * @param id The identifier of the researcher to be deleted.
     */
    void deleteById(Long id);
}

