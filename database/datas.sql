CREATE DATABASE search_intelligent;
\c search_intelligent;

CREATE SEQUENCE seq_categorie;
CREATE TABLE categorie (
    id_categorie integer primary key default nextval('seq_categorie'),
    name VARCHAR(50)
);

CREATE SEQUENCE seq_product;
CREATE TABLE product (
    id_product integer primary key default nextval('seq_product'),
    name VARCHAR(50),
    id_categorie INTEGER REFERENCES categorie(id_categorie),
    prix DOUBLE PRECISION,
    qualite DOUBLE PRECISION,
    status INTEGER
);

CREATE SEQUENCE seq_key_word;
CREATE TABLE key_word (
    id_key_word integer primary key default nextval('seq_key_word'),
    request VARCHAR(20),
    key_value_normal VARCHAR(10),
    key_value_prix VARCHAR(10)
);

/*CREATE SEQUENCE seq_synonym;
CREATE TABLE synonym (
    id_synonym integer primary key default nextval('seq_synonym'),
    id_key_word INTEGER REFERENCES key_word(id_key_word),
    value VARCHAR(30)
);

CREATE SEQUENCE seq_condition;
CREATE TABLE condition (
    id_condition integer primary key default nextval('seq_condition'),
    request VARCHAR(100),
    value VARCHAR(5)
);

 
CREATE SEQUENCE seq_formule_key;
CREATE TABLE formule_key (
    id_forumle_key integer primary key default nextval('seq_formule_key'),
    id_key_word INTEGER REFERENCES key_word(id_key_word),
    column_reference VARCHAR(30),
    value_formule VARCHAR(5)
);
*/
CREATE OR REPLACE VIEW v_product_categorie AS 
SELECT p.id_product, p.name product, p.id_categorie, c.name categorie, p.prix, p.qualite, p.status
FROM product p
JOIN categorie c ON p.id_categorie = c.id_categorie;
/*
CREATE OR REPLACE VIEW v_formule_key AS
SELECT fk.id_formule_key, fk.id_key_word, fk.column_reference, fk.value_formule, kw.key_value, 
s.value synonym 
FROM formule_key fk
JOIN key_word kw ON fk.id_key_word = kw.id_key_word
JOIN synonym s ON fk.id_key_word = s.id_key_word;
*/
INSERT INTO categorie (name) VALUES
    ('Telephone'),
    ('Ordinateur'),
    ('Chaussure'),
    ('Vetement');

INSERT INTO product (name, id_categorie, prix, qualite, status) VALUES
    ('IPhone X', 1, 1560000, 5, 1),
    ('Google pixel 3', 1, 560000, 7, 1),
    ('DELL', 2, 1000000, 3, 1),
    ('MAC', 2, 3560000, 8, 1),
    ('Toshiba', 2, 860000, 7, 1),
    ('Asus', 2, 2820000, 4, 1),
    ('Air nike', 3, 50000, 6, 1),
    ('Air jord 3', 3, 126000, 6, 1),
    ('Adidas', 4, 60000, 7, 1),
    ('Nike', 4, 600000, 5, 1),
    ('Lonzo', 4, 40000, 7, 1),
    ('Android', 4, 45000, 6, 1);