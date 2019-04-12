create database job4j_junior;

create table roles (
  id serial primary key,
  role varchar(30) not null
);

create table rules (
  id serial primary key,
  rule varchar(30) not null
);

create table role_rule (
  id_role int references roles(id),
  id_rule int references rules(id)
);

create table users (
  id serial primary key,
  id_role int references roles(id),
  login varchar(100) not null
);

create table categories (
 id serial primary key,
 category varchar(50)
);

create table states (
  id serial primary key,
  state varchar(20)
);

create table items (
  id serial primary key,
  id_user int references users(id),
  id_category int references categories(id),
  id_state int references states(id),
  item varchar(200) not null
);

create table comments (
  id serial primary key,
  id_item int references items(id),
  comment varchar(5000)
);

create table attaches (
  id serial primary key references items(id),
  attaches bytea
);

insert into roles (role) values (user); -- выберится пользователь postgres

insert into roles (role) values ('admin');

insert into roles (role) values ('user');

insert into rules (rule) values ('rule1');

insert into rules (rule) values ('rule2');

insert into rules (rule) values ('rule3');

insert into role_rule (id_role, id_rule) values (1, 1);

insert into role_rule (id_role, id_rule) values (1, 2);

insert into role_rule (id_role, id_rule) values (1, 3);

insert into role_rule (id_role, id_rule) values (2, 2);

insert into role_rule (id_role, id_rule) values (2, 3);

insert into role_rule (id_role, id_rule) values (3, 3);

insert into users (id_role, login) values (3, 'xxxxx');

insert into categories (category) values ('category_1');

insert into states (state) values ('activ');

insert into items (id_user, id_category, id_state, item) values (1, 1, 1, 'item_1');

insert into comments (id_item, comment) values (1, 'comment...');

insert into attaches (attaches) values (null);