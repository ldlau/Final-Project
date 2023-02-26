DROP TABLE IF EXISTS book_author;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS author;

CREATE TABLE author (
  author_id INT AUTO_INCREMENT NOT NULL,
  author_name VARCHAR(128) NOT NULL,
  PRIMARY KEY (author_id)
);

CREATE TABLE location (
  location_name VARCHAR(128) NOT NULL,
  PRIMARY KEY (location_name)
);

CREATE TABLE book (
  book_id INT AUTO_INCREMENT NOT NULL,
  location_name VARCHAR(128) NOT NULL,
  book_name VARCHAR(128) NOT NULL,
  PRIMARY KEY (book_id),
  FOREIGN KEY (location_name) REFERENCES location (location_name) ON DELETE CASCADE
);
  
CREATE TABLE book_author (
  book_id INT NOT NULL,
  author_id INT NOT NULL,
  FOREIGN KEY (book_id) REFERENCES book (book_id) ON DELETE CASCADE,
  FOREIGN KEY (author_id) REFERENCES author (author_id) ON DELETE CASCADE,
  UNIQUE KEY (book_id, author_id)
);





