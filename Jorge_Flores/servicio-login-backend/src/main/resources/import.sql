/* Creamos algunos "public"."usuarios" con sus "public"."roles" */
INSERT INTO "public"."usuarios" (username, password, enabled, nombre, apellido, email) VALUES ('jflores','$2a$10$C3Uln5uqnzx/GswADURJGOIdBqYrly9731fnwKDaUdBkt/M3qvtLq',true, 'Jorge', 'Flores','jflores@postulacion.com');
INSERT INTO "public"."usuarios" (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',true, 'Admin', 'General','admin@postulacion.com');

INSERT INTO "public"."roles" (nombre) VALUES ('ROLE_USER');
INSERT INTO "public"."roles" (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO "public"."usuarios_roles" (usuario_id, role_id) VALUES (1, 1);
INSERT INTO "public"."usuarios_roles" (usuario_id, role_id) VALUES (2, 1);

INSERT INTO "public"."regiones" (id, nombre) VALUES (1, 'Sudamérica');
INSERT INTO "public"."regiones" (id, nombre) VALUES (2, 'Centroamérica');
INSERT INTO "public"."regiones" (id, nombre) VALUES (3, 'Norteamérica');
INSERT INTO "public"."regiones" (id, nombre) VALUES (4, 'Europa');
INSERT INTO "public"."regiones" (id, nombre) VALUES (5, 'Asia');
INSERT INTO "public"."regiones" (id, nombre) VALUES (6, 'Africa');
INSERT INTO "public"."regiones" (id, nombre) VALUES (7, 'Oceanía');
INSERT INTO "public"."regiones" (id, nombre) VALUES (8, 'Antártida');