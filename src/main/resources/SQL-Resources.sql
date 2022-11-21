INSERT INTO db_categories (id, name)  VALUES (1, 'DVD');
INSERT INTO db_platforms (id, name, owner)  VALUES (1, 'Home-Cinema', 'SONY');
INSERT INTO db_products (id, name, version, platform, format, region, category, date_origen)  VALUES (1, 'test', 1, 1, 1, 'PAL', 1, TO_DATE('20221121','YYYYMMDD'));
INSERT INTO db_products_situations (id, product_fk, number_situation, amount)  VALUES (1, 1, 1, 1);
INSERT INTO db_products_situations (id, product_fk, number_situation, amount)  VALUES (2, 1, 2, 1);
INSERT INTO db_products_situations (id, product_fk, number_situation, amount)  VALUES (3, 1, 3, 1);
