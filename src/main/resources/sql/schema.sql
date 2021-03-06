CREATE TABLE IF NOT EXISTS pokemon
(
    id   VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    name VARCHAR NOT NULL,
    number INT
);

CREATE TABLE IF NOT EXISTS users
(
    id VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    name VARCHAR NOT NULL,
    email VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS user_pokemon
(
    id VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    user_id VARCHAR NOT NULL,
    pokemon_id VARCHAR NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (pokemon_id) REFERENCES pokemon (id)
);