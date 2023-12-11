/*
    Author: Alejandro Hernández

    SerpAPI dependency is needed for this class.
    The dependency isn't available in Maven Repository. To use it, is necessary utilize jitpack.io as a declared repo in the POM, and then use the declared dependency there for SerpAPI.
 */

package service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import model.Researcher;
import serpapi.SerpApiSearch;
import serpapi.SerpApiSearchException;
import utilities.DataFormatter;
import utilities.PropertiesFileGenerator;

import java.util.*;

/**
 * Service class responsible for interacting with the SerpApi to fetch top researchers' data.
 */
public class SerpApiService {

    // Load properties from a file to obtain the API key and search engine information
    private static Properties properties = PropertiesFileGenerator.generate("tokenApis.properties");
    private static String apiKey = properties.getProperty("serpApiToken");
    private static String engineAuthor = "google_scholar_author";
    private static String engineProfilesId = "google_scholar_profiles";

    /**
     * Retrieves data of the top 10 researchers from SerpApi.
     *
     * @return List of Researcher objects containing top researchers' information.
     */
    public static List<Researcher> getTop10Researchers() {
        Researcher researcherAux;
        List<Researcher> researchers = new ArrayList<>();
        Map<Integer, String> profilesIDs = getProfilesIdsByTag("Universidad de Mexico");
        Map<String, Object> dataAuthor = new HashMap<>();

        // Loop through the profiles to gather data of top researchers
        for (int i = 0; i < 10; i++) {
            dataAuthor = getDataAuthorByProfileId(profilesIDs.get(i));

            // Create Researcher objects and add them to the list
            researcherAux = new Researcher(null, dataAuthor.get("name").toString(),
                    dataAuthor.get("affiliation").toString(), dataAuthor.get("best_article").toString(),
                    Integer.parseInt(dataAuthor.get("cited_by").toString()));

            researchers.add(researcherAux);
        }

        return researchers;
    }

    /**
     * Retrieves profiles' IDs based on a specified tag using SerpApi search.
     *
     * @param tag The tag to search for profiles.
     * @return Map of profiles' IDs.
     */
    private static Map<Integer, String> getProfilesIdsByTag(String tag) {
        Map<Integer, String> profilesIDs = new HashMap<>();
        Map<String, String> parameter = new HashMap<>();

        parameter.put("mauthors", tag);
        parameter.put("hl", "es");
        parameter.put("api_key", apiKey);

        // Perform a search to obtain profiles' IDs using SerpApiSearch
        SerpApiSearch search = new SerpApiSearch(parameter, engineProfilesId);

        try {
            JsonObject result = search.getJson();
            JsonElement profilesJson = result.get("profiles");
            JsonArray profilesArray = profilesJson.getAsJsonArray();

            // Store profiles' IDs in a map
            for (int i = 0; i < 10; i++) {
                profilesIDs.put(i, String.valueOf(profilesArray.get(i).getAsJsonObject().get("author_id")));
            }

            return profilesIDs;
        } catch (SerpApiSearchException e) {
            System.out.println("Exception:");
            System.out.println(e.toString());
        }

        return profilesIDs;
    }

    /**
     * Retrieves data of an author based on their profile ID using SerpApi search.
     *
     * @param profileId The profile ID of the author.
     * @return Map containing author's data.
     */
    private static Map<String, Object> getDataAuthorByProfileId(String profileId) {
        Map<String, Object> dataAuthor = new HashMap<>();
        String profileIdFormatted = DataFormatter.deleteQuotes(profileId);
        Map<String, String> parameter = new HashMap<>();

        parameter.put("author_id", profileIdFormatted);
        parameter.put("api_key", apiKey);

        // Perform a search to obtain author's data using SerpApiSearch
        SerpApiSearch search = new SerpApiSearch(parameter, engineAuthor);

        try {
            JsonObject results = search.getJson();

            // Retrieve and store various author-related data
            dataAuthor.put("name", DataFormatter.deleteQuotes(results.get("author").getAsJsonObject().get("name").toString()));
            dataAuthor.put("affiliation", DataFormatter.deleteQuotes(results.get("author").
                    getAsJsonObject().get("affiliations").toString()));
            dataAuthor.put("cited_by", results.get("cited_by").getAsJsonObject().get("table")
                    .getAsJsonArray().get(0).getAsJsonObject().get("citations").getAsJsonObject().get("all"));
            dataAuthor.put("best_article", DataFormatter.deleteQuotes(results.get("articles").getAsJsonArray().get(0)
                    .getAsJsonObject().get("title").toString()));

            return dataAuthor;
        } catch (SerpApiSearchException e) {
            System.out.println("Exception:");
            System.out.println(e.toString());
        }

        return dataAuthor;
    }
}