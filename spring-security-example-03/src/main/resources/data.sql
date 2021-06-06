INSERT INTO role (role_id, name) VALUES 
(1, 'ROLE_ADMIN'),
(2, 'ROLE_ACTUATOR'),
(3, 'ROLE_USER')
;

-- https://bcrypt-generator.com/
-- rounds : 10 , Spring default
-- password and user name are same

INSERT INTO user (user_id, email, password, name) VALUES 
(1, 'admin@gmail.com', '$2y$10$zsClnj1Cz7viqXqUycPwGOFfQb5yOpBwEnBhse17fhGSf05hb7ASa', 'admin'),
(2, 'user@gmail.com', '$2y$10$vYkWRJhpCrlf/WQDSPdIgOZNGUzhUHmpx4hwL88an5on.08Qr547e', 'user')
;


insert into user_role(user_id, role_id) values
(1,1),
(1,2),
(1,3),
(2,2)
;
