ALTER TABLE import_job
    ALTER COLUMN processing_time DROP NOT NULL,
    ALTER COLUMN films_count DROP NOT NULL,
    ALTER COLUMN new_films_count DROP NOT NULL;