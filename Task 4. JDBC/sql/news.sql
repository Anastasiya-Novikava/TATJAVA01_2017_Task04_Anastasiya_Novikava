DROP TABLE IF EXISTS news;
CREATE TABLE news
  (id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
   title CHAR(50) NOT NULL,
   category CHAR(5) NOT NULL,
   content CHAR(100) NOT NULL UNIQUE);
INSERT INTO news (title, category, content)
  VALUES ('Oscar_nominees', 'film', 'Announced_nominees_for_the_Oscar_2017');
INSERT INTO news (title, category, content)
  VALUES ('New_song', 'disk', 'Beyonce_has_released_a_new_song');
INSERT INTO news (title, category, content)
  VALUES ('Popular_book', 'book', 'The_most_popular_book_in_last_year_was_"The_outcasts"_by_Victor_Hugo');
