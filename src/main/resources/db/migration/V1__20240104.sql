CREATE TABLE users (
                       id         SERIAL PRIMARY KEY,
                       email      VARCHAR(256)   NOT NULL UNIQUE,
                       password   VARCHAR(2048) NOT NULL,
                       role       VARCHAR(32)   NOT NULL,
                       first_name VARCHAR(64)   NOT NULL,
                       last_name  VARCHAR(64)   NOT NULL,
                       avatar     VARCHAR(256),
                       disk_space BIGINT,
                       used_space BIGINT,
                       enabled    BOOLEAN       NOT NULL DEFAULT FALSE,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP
);