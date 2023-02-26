-- Author
INSERT INTO author
    (author_name)
VALUES
    ('Michel Faber'),
    ('Joyce Carol Oates'),
    ('Caleb Carr'),
    ('Martin Amis'),
    ('Sara Gruen'),
    ('Dennis Lehane'),
    ('Louis Bayard'),
    ('Cormac McCarthy'),
    ('Erik Larson'),
    ('Lionel Shiver'),
    ('John Steinbeck'),
    ('Tova Friedman'),
    ('Malcolm Brabant'),
    ('Don DeLillo')
;
-- Location
  INSERT INTO location
      (location_name)
  VALUES
     ('Basement'),
     ('First Floor'),
     ('Second Floor')
;
-- Book
  INSERT INTO book
	(book_name, location_name)
  VALUES 
    ('The Book Of Strange New Things', 'Basement'),
    ('My Life As A Rat', 'Basement'),
    ('The Angel Of Darkness', 'Basement'),
    ('The Zone Of Interest', 'Basement'),
    ('At The Water''s Edge', 'Basement'),
    ('Shutter Island', 'First Floor'),
    ('Mr. Timothy', 'First Floor'),
    ('The Road', 'First Floor'),
    ('Devil In The White City', 'First Floor'),
    ('Blonde', 'First Floor'),
    ('A Perfectly Good Family', 'Second Floor'),
    ('Of Mice And Men', 'Second Floor'),
    ('The Daughter Of Auschwitz', 'Second Floor'),
    ('The Black Tower', 'Second Floor'),
    ('White Noise', 'Second Floor')
;
-- book_author
INSERT INTO book_author
(book_id, author_id)
VALUES
   (1, 1),
   (2, 2),
   (3, 3),
   (4, 4),
   (5, 5),
   (6, 6),
   (7, 7),
   (8, 8),
   (9, 9),
   (10, 2),
   (11, 10),
   (12, 11),
   (13, 12),
   (14, 2),
   (15, 13)
;
    SELECT * FROM book;
   SELECT * FROM author;
   SELECT * FROM book_author;
    SELECT * FROM location;