CREATE TABLE import_job (
                           id        BIGSERIAL PRIMARY KEY,
                           start_time   TIMESTAMP NOT NULL DEFAULT now(),
                           processing_time   INTEGER NOT NULL,
                           films_count  INTEGER NOT NULL,
                           new_films_count  INTEGER NOT NULL,
                           process_type  VARCHAR(20) NOT NULL,
                           status_of_process  VARCHAR(20) NOT NULL,
                           user_id  BIGINT REFERENCES users(id)
);

