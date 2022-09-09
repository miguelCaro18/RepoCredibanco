create schema credibanco_prueba;

use credibanco_prueba;

create table titular(
    id integer auto_increment,
    nombre_titular varchar(300),
    telefono_titular varchar(10),
    cedula_titular varchar(15),
primary key (id)
)Engine=InnoDB;

create table tipo_tarjeta(
    id integer auto_increment,
    nombre_tipo varchar(100),
    primary key (id)
)Engine=InnoDB;
insert into  tipo_tarjeta (nombre_tipo) values ('Crédito'),('Débito');
create table estado_tarjeta(
    id integer auto_increment,
    nombre_estado varchar(100),
    primary key (id)
)Engine=InnoDB;
insert into  tipo_tarjeta (nombre_tipo) values ('Creada'),('Enrolada'),('Eliminada');
create table tarjeta(
    pan_tarjeta varchar(19),
    id_titular integer,
    tipo_tarjeta integer,
    estado_tarjeta integer,
    num_validacion varchar(3),
    primary key (pan_tarjeta)
)Engine=InnoDB;
alter table tarjeta
    add constraint tarjeta_tipo_fk
foreign key (tipo_tarjeta) references tipo_tarjeta(id);
alter table tarjeta
    add constraint tarjeta_estado_fk
foreign key (estado_tarjeta) references estado_tarjeta(id);
alter table tarjeta
    add constraint tarjeta_titular_fk
foreign key (id_titular) references titular(id);

create table estado_transaccion(
    id integer auto_increment,
    nombre_estado varchar(100),
    primary key (id)
)Engine=InnoDB;
insert into  estado_transaccion (nombre_estado) values ('Aprobada'),('Reachazada'),('Anulada');


create table transaccion(
    id integer auto_increment,
    pan_tarjeta varchar(19),
    total_compra double,
    direccion varchar(200),
    estado_transaccion integer,
    referencia varchar(6),
    fecha_transaccion datetime,
    primary key (id)
)Engine=InnoDB;
alter table transaccion
    add constraint transaccion_estado_fk
foreign key (estado_transaccion) references estado_transaccion(id);
alter table transaccion
    add constraint transaccion_tarjeta_fk
foreign key (pan_tarjeta) references tarjeta(pan_tarjeta);
