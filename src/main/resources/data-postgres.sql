/* INSERT INTO resource (resource_id, role) VALUES (1, 'Premium role');
INSERT INTO resource (resource_id, role) VALUES (2, 'Basic role');

INSERT INTO client (client_id, email, login, password, phone_number) VALUES (1, 'jakismail@gmail.com', 'login1', 'pass1', 123456789);
INSERT INTO client (client_id, email, login, password, phone_number) VALUES (2, 'jakismail@gmail.com', 'login1', 'pass1', 123456789);

INSERT INTO subscription (subscription_id, end_date, start_date, sub_type, resource_id) VALUES (1, '2022-02-02', '2022-02-30', 'PREMIUM', 1 );
INSERT INTO subscription (subscription_id, end_date, start_date, sub_type, resource_id) VALUES (2, '2022-06-02', '2022-07-30', 'BASIC', 2 );

INSERT INTO account (account_id, client_id, subscription_id) VALUES (1, 1, 1);
INSERT INTO account (account_id, client_id, subscription_id) VALUES (2, 2, 2); */
