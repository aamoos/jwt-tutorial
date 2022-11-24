INSERT INTO USERS(USER_ID, USERNAME, PASSWORD, NICKNAME, ACTIVATED) VALUES(1, 'admin', '$2a$10$E2pUd//AHzJ9GftoOUGMnudE967qaiZ1elVzkpv3lO0NNYhl6Dmmy', 'admin', 1);

INSERT INTO AUTHORITY (AUTHORITY_NAME) VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (AUTHORITY_NAME) VALUES ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_NAME) VALUES (1, 'ROLE_USER');
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_NAME) VALUES (1, 'ROLE_ADMIN');
