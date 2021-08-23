create table cajero (id integer not null auto_increment, es_exclusivo bit not null, es_normal bit not null, es_preferencial bit not null, nombre varchar(255), primary key (id)) engine=InnoDB;
create table cola (id integer not null auto_increment, edad integer not null, fecha_hora_ingreso datetime(6), nombre varchar(255), cajero_id integer, primary key (id)) engine=InnoDB;
alter table cola add constraint FK47cpc3cm2rbmi15fd5h8snphi foreign key (cajero_id) references cajero (id);

INSERT INTO cajero (es_exclusivo, es_normal, es_preferencial, nombre) VALUES (0, 0, 0, 'jorge');
INSERT INTO cajero (es_exclusivo, es_normal, es_preferencial, nombre) VALUES (1, 0, 0, 'vanessa');
INSERT INTO cajero (es_exclusivo, es_normal, es_preferencial, nombre) VALUES (0, 1, 0, 'edson');
INSERT INTO cajero (es_exclusivo, es_normal, es_preferencial, nombre) VALUES (0, 0, 0, 'luis');
INSERT INTO cajero (es_exclusivo, es_normal, es_preferencial, nombre) VALUES (0, 0, 0, 'guillermo');
INSERT INTO cajero (es_exclusivo, es_normal, es_preferencial, nombre) VALUES (0, 0, 0, 'isabel');
INSERT INTO cajero (es_exclusivo, es_normal, es_preferencial, nombre) VALUES (0, 0, 0, 'alberto');
INSERT INTO cajero (es_exclusivo, es_normal, es_preferencial, nombre) VALUES (0, 0, 0, 'juan');