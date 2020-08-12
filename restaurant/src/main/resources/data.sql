INSERT INTO restaurant(id,name,created_at, updated_at) VALUES
    (1,'Thanks Burguer', CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP()),
    (2,'Burger King', CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP()),
    (3,'Casa da Batchan', CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());

INSERT INTO food(name,value,description,id_restaurant) VALUES
    ('Tonkatsu',25,'Porco empanado',3),
    ('Gioza',25,'Pastel japones',3);  