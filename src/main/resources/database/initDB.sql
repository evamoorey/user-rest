CREATE TABLE IF NOT EXISTS users
(
    Id SERIAL NOT NULL,
    Name TEXT,
    Info TEXT
);
INSERT INTO users (Name, Info) VALUES ('Peter', 'human');
INSERT INTO users (Name, Info) VALUES ('Bob', 'dog');