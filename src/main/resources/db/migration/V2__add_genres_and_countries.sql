CREATE TABLE genres (
                        id   BIGSERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE countries (
                           id   BIGSERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE film_genres (
                             film_id  BIGINT NOT NULL REFERENCES films(id) ON DELETE CASCADE,
                             genre_id BIGINT NOT NULL REFERENCES genres(id) ON DELETE CASCADE,
                             PRIMARY KEY (film_id, genre_id)
);

CREATE TABLE film_countries (
                                film_id    BIGINT NOT NULL REFERENCES films(id) ON DELETE CASCADE,
                                country_id BIGINT NOT NULL REFERENCES countries(id) ON DELETE CASCADE,
                                PRIMARY KEY (film_id, country_id)
);