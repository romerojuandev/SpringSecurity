INSERT INTO permissions (id, name) VALUES(1, 'CREATE');
INSERT INTO permissions (id, name) VALUES(2, 'UPDATE');
INSERT INTO permissions (id, name) VALUES(3, 'READ');
INSERT INTO permissions (id, name) VALUES(4, 'DELETE');
INSERT INTO permissions (id, name) VALUES(5, 'REFACTOR');

INSERT INTO roles (id, role_name) VALUES(1, 'ADMIN');
INSERT INTO roles (id, role_name) VALUES(2, 'USER');
INSERT INTO roles (id, role_name) VALUES(3, 'INVITED');
INSERT INTO roles (id, role_name) VALUES(4, 'DEVELOPER');

INSERT INTO role_permissions (permission_id, role_id) VALUES(1, 1);
INSERT INTO role_permissions (permission_id, role_id) VALUES(2, 1);
INSERT INTO role_permissions (permission_id, role_id) VALUES(3, 1);
INSERT INTO role_permissions (permission_id, role_id) VALUES(4, 1);
INSERT INTO role_permissions (permission_id, role_id) VALUES(1, 2);
INSERT INTO role_permissions (permission_id, role_id) VALUES(3, 2);
INSERT INTO role_permissions (permission_id, role_id) VALUES(3, 3);
INSERT INTO role_permissions (permission_id, role_id) VALUES(1, 4);
INSERT INTO role_permissions (permission_id, role_id) VALUES(2, 4);
INSERT INTO role_permissions (permission_id, role_id) VALUES(3, 4);
INSERT INTO role_permissions (permission_id, role_id) VALUES(4, 4);
INSERT INTO role_permissions (permission_id, role_id) VALUES(5, 4);

INSERT INTO users (account_no_expired, account_no_locked, credential_no_expired, is_enabled, id, password, username) VALUES(1, 1, 1, 1, 1, '$2y$10$EEGoMlkwa2LpWyPALep.CuZ9WfH.EerkthukmYtNcoEw9Z34fjhCu', 'juancito');
INSERT INTO users (account_no_expired, account_no_locked, credential_no_expired, is_enabled, id, password, username) VALUES(1, 1, 1, 1, 2, '$2y$10$EEGoMlkwa2LpWyPALep.CuZ9WfH.EerkthukmYtNcoEw9Z34fjhCu', 'eli');
INSERT INTO users (account_no_expired, account_no_locked, credential_no_expired, is_enabled, id, password, username) VALUES(1, 1, 1, 1, 3, '$2y$10$EEGoMlkwa2LpWyPALep.CuZ9WfH.EerkthukmYtNcoEw9Z34fjhCu', 'uti');
INSERT INTO users (account_no_expired, account_no_locked, credential_no_expired, is_enabled, id, password, username) VALUES(1, 1, 1, 1, 4, '$2y$10$EEGoMlkwa2LpWyPALep.CuZ9WfH.EerkthukmYtNcoEw9Z34fjhCu', 'chamaco');

INSERT INTO user_roles (role_id, user_id) VALUES(1, 1);
INSERT INTO user_roles (role_id, user_id) VALUES(2, 2);
INSERT INTO user_roles (role_id, user_id) VALUES(3, 3);
INSERT INTO user_roles (role_id, user_id) VALUES(4, 4);