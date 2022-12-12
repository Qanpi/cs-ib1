CREATE TABLE movie (
  id          int        PRIMARY KEY,
  name        nvarchar   NOT NULL,
  year_       int        NOT NULL,
  director_id int    NOT NULL REFERENCES director(id));

CREATE TABLE director (
  id          int       PRIMARY KEY,
  first_name  nvarchar  NOT NULL,
  last_name  nvarchar   NOT NULL
);

INSERT INTO director VALUES 
  (1, "Theodore", "Melfi"),
  (2, "Christopher", "Nolan");
  
INSERT INTO movie VALUES
  (1, "Hidden Figures", 2016, 1),
  (2, "Interstellar", 2014, 2),
  (3, "The Dark Knight", 2008, 2);


--SELECT * FROM movie;
SELECT director.last_name, movie.name, movie.year_ FROM movie JOIN director ON movie.director_id = director.id;

SELECT movie.name FROM movie ORDER BY movie.year_ ASC;
