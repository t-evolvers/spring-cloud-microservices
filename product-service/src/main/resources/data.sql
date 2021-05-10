INSERT INTO tbl_categories (id, name) VALUES (1, 'vinos');
INSERT INTO tbl_categories (id, name) VALUES (2, 'cervezas');
INSERT INTO tbl_categories (id, name) VALUES (3, 'alimentos');

INSERT INTO tbl_products (id, name, description, stock, price, status, created_at, categorie_id) VALUES (1, 'vino rose', 'ideal para sangrias y cocteles', 5, 178.89, 'CREATED', '2021-05-04', 1);
INSERT INTO tbl_products (id, name, description, stock, price, status, created_at, categorie_id) VALUES (2, 'vino tinto', 'ideal para una velada romantica', 4, 12.5, 'CREATED', '2021-05-04', 1);
INSERT INTO tbl_products (id, name, description, stock, price, status, created_at, categorie_id) VALUES (3, 'corona', 'cerveza refrescante', 12, 40.06, 'CREATED', '2021-05-04', 2);