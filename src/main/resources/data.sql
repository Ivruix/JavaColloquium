-- noinspection SqlDialectInspectionForFile
-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE rates
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)   NOT NULL,
    rate DECIMAL(100, 2) NOT NULL
);