create table if not exists item(
  item_id serial primary key,
  name varchar(200) not null,
  description varchar(200) not null,
  created timestamp
);
create table if not exists comment(
  comment_id serial primary key,
  comment varchar(3000),
  item_id int references item(item_id)
);