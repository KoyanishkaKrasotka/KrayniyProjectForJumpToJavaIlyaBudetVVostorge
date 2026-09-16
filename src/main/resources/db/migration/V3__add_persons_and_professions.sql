CREATE TABLE persons (
                         id BIGSERIAL PRIMARY KEY,
                         staff_id INTEGER UNIQUE NOT NULL,
                         staff_name_ru VARCHAR(255),
                         staff_name_en VARCHAR(255),
                         poster_url TEXT,
                         description TEXT
);

CREATE TABLE professions (
                           id   BIGSERIAL PRIMARY KEY,
                           profession_key VARCHAR(255) NOT NULL UNIQUE,
                           profession_text TEXT
);

CREATE TABLE film_persons (
                              id            BIGSERIAL PRIMARY KEY,
                              film_id       BIGINT NOT NULL REFERENCES films(id) ON DELETE CASCADE,
                              person_id     BIGINT NOT NULL REFERENCES persons(id) ON DELETE CASCADE,
                              profession_id BIGINT NOT NULL REFERENCES professions(id) ON DELETE CASCADE,
                              UNIQUE (film_id, person_id, profession_id)
);
