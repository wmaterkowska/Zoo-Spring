CREATE TABLE zones(
                      id_zone BIGSERIAL PRIMARY KEY NOT NULL,
                      name VARCHAR(255) NOT NULL,
                      amount_of_food INTEGER,
                      max_amount_of_food INTEGER NOT NULL,
                      id_animal BIGSERIAL,
                      CONSTRAINT fk_animal FOREIGN KEY (id_animal) REFERENCES animals(id_animal)
);

CREATE TABLE animals(
                        id_animal BIGSERIAL PRIMARY KEY NOT NULL,
                        species VARCHAR(255) NOT NULL,
                        name VARCHAR(255) NOT NULL,
                        amount_of_food INTEGER NOT NULL,
                        id_zone BIGSERIAL,
                        CONSTRAINT fk_zone FOREIGN KEY (id_zone) REFERENCES zones(id_zone)
);

CREATE TABLE zoo(
                    id BIGSERIAL PRIMARY KEY NOT NULL,
                    id_zone BIGSERIAL,
                    CONSTRAINT fk_zone FOREIGN KEY (id_zone) REFERENCES zones(id_zone),
                    id_animal BIGSERIAL,
                    CONSTRAINT fk_animal FOREIGN KEY (id_animal) REFERENCES animals(id_animal)
);