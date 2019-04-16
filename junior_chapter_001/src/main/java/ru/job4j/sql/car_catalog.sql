create database car_catalog;

create table bodies (
  id serial primary key,
  name varchar(50)
);

create table engines (
  id serial primary key,
  name varchar(100)
);

create table transmissions (
  id serial primary key,
  name varchar(100)
);

create table cars (
  id serial primary key,
  name varchar(100),
  body_name_id int references bodies(id) not null,
  engine_name_id int references engines(id) not null,
  transaction_name_id int references transmissions(id) not null
);

insert into bodies (name) values ('coupe');
insert into bodies (name) values ('sedan');
insert into bodies (name) values ('pickup');
insert into bodies (name) values ('crossover');
insert into bodies (name) values ('cabriolet');
insert into bodies (name) values ('minivan');

insert into engines (name) values ('1,4');
insert into engines (name) values ('1,6');
insert into engines (name) values ('1,8');
insert into engines (name) values ('2,0');

insert into transmissions (name) values ('manual');
insert into transmissions (name) values ('auto');
insert into transmissions (name) values ('dsg');

insert into cars (name, body_name_id, engine_name_id, transaction_name_id) values ('bmw', 2, 3, 2);
insert into cars (name, body_name_id, engine_name_id, transaction_name_id) values ('gmc', 3, 4, 1);
insert into cars (name, body_name_id, engine_name_id, transaction_name_id) values ('audi', 4, 4, 2);

select c.name, b.name, e.name, t.name from cars as c
inner join bodies as b on c.body_name_id=b.id
inner join engines as e on c.engine_name_id=e.id
inner join transmissions t on c.transaction_name_id = t.id;

select b.name from bodies as b left outer join cars as c on c.body_name_id=b.id where c.id is null;
select e.name from engines as e left outer join cars as c on c.engine_name_id=e.id where c.id is null;
select t.name from transmissions as t left outer join cars as c on c.transaction_name_id=t.id where c.id is null;