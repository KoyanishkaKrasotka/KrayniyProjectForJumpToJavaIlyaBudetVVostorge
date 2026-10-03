CREATE TABLE favorites (
                           id        BIGSERIAL PRIMARY KEY,
                           user_id   BIGINT NOT NULL REFERENCES users(id),
                           film_id   INTEGER NOT NULL,
                           added_at  DATE NOT NULL DEFAULT now(),
                           CONSTRAINT uq_user_film UNIQUE (user_id, film_id)
);