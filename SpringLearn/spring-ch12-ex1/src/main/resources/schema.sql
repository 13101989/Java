CREATE TABLE IF NOT EXISTS purchase
(
    id
    INT
    GENERATED
    BY
    DEFAULT AS
    IDENTITY
    PRIMARY
    KEY,
    product
    varchar
(
    255
) NOT NULL,
    price double NOT NULL
    );

