package model;

/**
 * Represents a Researcher entity with various attributes.
 */
public class Researcher {

    private Long researcher_id;
    private String researcher_name;
    private String researcher_affiliation;
    private String researcher_best_article;
    private Integer researcher_cited_by;

    /**
     * Constructor to initialize a Researcher object with specific attributes.
     *
     * @param researcher_id           The identifier of the researcher.
     * @param researcher_name         The name of the researcher.
     * @param researcher_affiliation  The affiliation of the researcher.
     * @param researcher_best_article The best article of the researcher.
     * @param researcher_cited_by     The number of times the researcher has been cited.
     */
    public Researcher(Long researcher_id, String researcher_name, String researcher_affiliation,
                      String researcher_best_article, Integer researcher_cited_by) {
        this.researcher_id = researcher_id;
        this.researcher_name = researcher_name;
        this.researcher_affiliation = researcher_affiliation;
        this.researcher_best_article = researcher_best_article;
        this.researcher_cited_by = researcher_cited_by;
    }

    // Getters and setters for Researcher attributes
    public Long getResearcher_id() {
        return researcher_id;
    }

    public void setResearcher_id(Long researcher_id) {
        this.researcher_id = researcher_id;
    }

    public String getResearcher_name() {
        return researcher_name;
    }

    public void setResearcher_name(String researcher_name) {
        this.researcher_name = researcher_name;
    }

    public String getResearcher_affiliation() {
        return researcher_affiliation;
    }

    public void setResearcher_affiliation(String researcher_affiliation) {
        this.researcher_affiliation = researcher_affiliation;
    }

    public String getResearcher_best_article() {
        return researcher_best_article;
    }

    public void setResearcher_best_article(String researcher_best_article) {
        this.researcher_best_article = researcher_best_article;
    }

    public Integer getResearcher_cited_by() {
        return researcher_cited_by;
    }

    public void setResearcher_cited_by(Integer researcher_cited_by) {
        this.researcher_cited_by = researcher_cited_by;
    }

    // toString method for representing Researcher object details
    @Override
    public String toString() {
        return "Researcher{" + "\n" +
                "\tresearcher_id= " + researcher_id + ",\n" +
                "\tresearcher_name= " + researcher_name + ",\n" +
                "\tresearcher_affiliation= " + researcher_affiliation + ",\n" +
                "\tresearcher_best_article= " + researcher_best_article + ",\n" +
                "\tresearcher_cited_by= " + researcher_cited_by +
                '}';
    }
}
