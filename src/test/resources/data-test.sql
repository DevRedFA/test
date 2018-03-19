INSERT INTO products (id, name) VALUES (1, 'TEST_PRODUCT_1');
INSERT INTO products (id, name) VALUES (2, 'TEST_PRODUCT_2');
INSERT INTO products (id, name) VALUES (3, 'TEST_PRODUCT_3');
INSERT INTO products (id, name) VALUES (4, 'TEST_PRODUCT_4');

INSERT INTO contracts (id) VALUES (1);
INSERT INTO contracts (id) VALUES (2);
INSERT INTO contracts (id) VALUES (3);
INSERT INTO contracts (id) VALUES (4);

INSERT INTO applications (id, DATE_TIME_CREATED, CONTRACT_ID, PRODUCT_ID) VALUES (1, '2009-06-04 13:00:00', 1, 1);
INSERT INTO applications (id, DATE_TIME_CREATED, CONTRACT_ID, PRODUCT_ID) VALUES (2, '2009-06-04 14:00:00', 1, 2);
INSERT INTO applications (id, DATE_TIME_CREATED, CONTRACT_ID, PRODUCT_ID) VALUES (3, '2009-06-04 15:00:00', 1, 3);
INSERT INTO applications (id, DATE_TIME_CREATED, CONTRACT_ID, PRODUCT_ID) VALUES (4, '2009-06-04 16:00:00', 2, 1);
INSERT INTO applications (id, DATE_TIME_CREATED, CONTRACT_ID, PRODUCT_ID) VALUES (5, '2009-06-04 17:00:00', 2, 2);

-- TEST BASE SQL request:
-- select ap.contract_id, ap.id, ap.DATE_TIME_CREATED, products.name from applications as ap
--   left JOIN products on products.id = ap.product_id
-- where contract_id = 2 ORDER BY ap.DATE_TIME_CREATED DESC, id DESC LIMIT 1