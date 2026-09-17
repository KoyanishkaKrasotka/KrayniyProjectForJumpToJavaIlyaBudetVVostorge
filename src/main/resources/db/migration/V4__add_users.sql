CREATE TABLE users (
                       id        BIGSERIAL PRIMARY KEY,
                       usernames VARCHAR(50) NOT NULL UNIQUE,
                       passwords VARCHAR(60) NOT NULL,
                       roles     VARCHAR(20) NOT NULL,
                       enabled   BOOLEAN NOT NULL DEFAULT true
);