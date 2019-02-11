/* USER Table*/
CREATE TABLE USER
(
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    EMAIL_ADDRESS VARCHAR(50) UNIQUE NOT NULL,
    FIRST_NAME VARCHAR(30) NOT NULL,
    LAST_NAME VARCHAR(30) NOT NULL,
    PASSWORD VARCHAR(30) NOT NULL,
    TYPE TINYINT NOT NULL DEFAULT 2
);
INSERT INTO USER
(
    EMAIL_ADDRESS,
    FIRST_NAME,
    LAST_NAME,
    PASSWORD,
    TYPE
)
VALUES
(
    'admin@email.com',
    'admin',
    'admin ln',
    'admin@123',
    1
);