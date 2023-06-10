CREATE TABLE IF NOT EXISTS books
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(50),
    author      VARCHAR(50),
    description TEXT,
    status      VARCHAR(20) NOT NULL CHECK (status IN ('IN_STOCK', 'ISSUED'))
);