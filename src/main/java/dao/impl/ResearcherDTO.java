package dao.impl;

import dao.ResearcherDao;
import datasource.ConnectionDB;
import model.Researcher;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Implementation of ResearcherDao interface responsible for database operations related to Researcher entities.
 */
public class ResearcherDTO implements ResearcherDao<Researcher, Long> {

    @Override
    public Researcher getById(Long id) {
        return null;
    }

    @Override
    public List<Researcher> getAllResearchers() {
        return null;
    }

    /**
     * Saves a single researcher entity to the database.
     *
     * @param researcher The researcher to be saved.
     * @return true if the save operation is successful, otherwise false.
     */
    @Override
    public boolean save(Researcher researcher) {
        // SQL query to insert researcher data into the database
        String sqlQuery = "INSERT INTO " +
                "top10_researchers (researcher_name, researcher_affiliations, researcher_cited_by, researcher_best_article) " +
                "VALUES (?, ?, ?, ?);";

        try (PreparedStatement preparedStatement = ConnectionDB.connect().prepareStatement(sqlQuery)) {
            // Set parameters for the prepared statement
            preparedStatement.setString(1, researcher.getResearcher_name());
            preparedStatement.setString(2, researcher.getResearcher_affiliation());
            preparedStatement.setInt(3, researcher.getResearcher_cited_by());
            preparedStatement.setString(4, researcher.getResearcher_best_article());

            // Execute the SQL query and return true if successful
            if (preparedStatement.executeUpdate() == 1) {
                preparedStatement.close();
                return true;
            }
        } catch (SQLException e) {
            // Print the stack trace in case of SQL exception
            e.printStackTrace();
            return false;
        }

        return false;
    }

    /**
     * Saves a list of researchers to the database.
     *
     * @param researchers The list of researchers to be saved.
     * @return true if the save operation is successful for all researchers, otherwise false.
     */
    @Override
    public boolean saveAll(List<Researcher> researchers) {
        boolean flag = true;

        while (flag) {
            // Loop through the list of researchers and attempt to save each one
            for (Researcher researcher : researchers) {
                boolean flagAux = save(researcher);
                if (!flagAux) {
                    flag = false;
                    break;
                }
            }
            return true;
        }

        return flag;
    }

    @Override
    public void modify(Researcher researcher) {
        // To be implemented
    }

    @Override
    public void deleteById(Long id) {
        // To be implemented
    }
}
