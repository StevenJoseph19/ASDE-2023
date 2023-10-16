DROP TABLE users IF EXISTS;
DROP TABLE categories IF EXISTS;
DROP TABLE books IF EXISTS;
DROP TABLE reviews IF EXISTS;

CREATE TABLE users (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  username  VARCHAR(30),
  password  VARCHAR(200)
);
CREATE INDEX users_username ON users (username);

CREATE TABLE categories (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80)
);
CREATE INDEX categories_name ON categories (name);

CREATE TABLE books (
  id   INTEGER IDENTITY PRIMARY KEY,
  category_id INTEGER,
  author VARCHAR(80),
  title VARCHAR(80),
  rating DECIMAL(10, 2),
  price DECIMAL(10, 2),
  pages INTEGER,
  isbn10 VARCHAR(10),
  isbn13 VARCHAR(14),
  publisher VARCHAR(200),
  image VARCHAR(80),
  description VARCHAR(2000)
);
ALTER TABLE books ADD CONSTRAINT fk_category_books FOREIGN KEY (category_id) REFERENCES categories (id);

CREATE TABLE reviews (
  id   INTEGER IDENTITY PRIMARY KEY,
  book_id INTEGER NOT NULL,
  user_id INTEGER NOT NULL,
  rating DOUBLE(10),
  registered TIMESTAMP,
  title VARCHAR(100),
  review VARCHAR(2000)
);
ALTER TABLE reviews ADD CONSTRAINT fk_book_reviews FOREIGN KEY (book_id) REFERENCES books (id);
ALTER TABLE reviews ADD CONSTRAINT fk_user_reviews FOREIGN KEY (user_id) REFERENCES users (id);