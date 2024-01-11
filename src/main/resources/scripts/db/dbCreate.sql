CREATE DATABASE IF NOT EXISTS university_researchers;
USE university_researchers;

CREATE TABLE IF NOT EXISTS top10_researchers (
	researcher_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    researcher_name VARCHAR(50) NOT NULL UNIQUE,
    researcher_affiliations VARCHAR(100),
    researcher_cited_by INT UNSIGNED NOT NULL,
    researcher_best_article VARCHAR(255)
);

TRUNCATE top10_researchers;