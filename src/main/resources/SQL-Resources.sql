INSERT INTO db_categories (id, name) VALUES (1, 'DVD');
INSERT INTO db_platforms (id, name, owner) VALUES (1, 'Home-Cinema', 'SONY');
INSERT INTO db_users (id, nickname, date_origen, level)  VALUES (1, 'Test', TO_DATE('20221121','YYYYMMDD'), 100);
INSERT INTO db_products (id, name, version, platform, format, region, category, date_origen, user_audit) VALUES (1, 'test', 1, 1, 1, 'PAL', 1, TO_DATE('20221121','YYYYMMDD'), 1);
INSERT INTO db_products_situations (id, product_fk, number_situation, amount, date_situation, user_audit) VALUES (1, 1, 1, 1, TO_DATE('20221121','YYYYMMDD'), 1);
INSERT INTO db_products_situations (id, product_fk, number_situation, amount, date_situation, user_audit) VALUES (2, 1, 2, 1, TO_DATE('20221121','YYYYMMDD'), 1);
INSERT INTO db_products_situations (id, product_fk, number_situation, amount, date_situation, user_audit) VALUES (3, 1, 3, 1, TO_DATE('20221121','YYYYMMDD'), 1);
