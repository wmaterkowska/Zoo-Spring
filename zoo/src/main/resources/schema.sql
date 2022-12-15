CREATE TABLE animals(
                        id_animal INT PRIMARY KEY NOT NULL,
                        species VARCHAR(255) NOT NULL,
                        name_animal VARCHAR(255) NOT NULL,
                        amount_of_food INT NOT NULL
);

CREATE TABLE zones(
                    id_zone INT PRIMARY KEY NOT NULL,
                    name_zone VARCHAR(255) NOT NULL,
                    amount_of_food INT,
                    max_amount_of_food INT NOT NULL,
                    id_animal INT REFERENCES animals(id_animal)
);



CREATE TABLE zoo(
                    id INT PRIMARY KEY NOT NULL,
                    id_zone INT,
                    CONSTRAINT fk_zone FOREIGN KEY (id_zone) REFERENCES zones(id_zone),
                    id_animal INT,
                    CONSTRAINT fk_animal FOREIGN KEY (id_animal) REFERENCES animals(id_animal)
);