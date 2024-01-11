package utilities;

/**
 * Utility class for formatting data.
 */
public class DataFormatter {

    /**
     * Removes quotes from a given string input.
     *
     * @param stringInput The input string from which quotes are to be removed.
     * @return A string with quotes removed.
     */
    public static String deleteQuotes(String stringInput) {
        return stringInput.replace("\"", "");
    }
}
