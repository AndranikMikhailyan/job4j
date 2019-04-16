select * from product as p inner join type as t on p.type_id=t.id where type = 'СЫР';

select * from product as p where p.name like '%мороженное%';

select * from product as p where extract(month from p.expired_date)=extract(month from current_date)+1;

select product.name from product having max(price);

select t.type, count(*)from product as p inner join type as t on p.type_id=t.id group by t.type;

select * from product as p inner join type as t on p.type_id=t.id where t.type = 'СЫР' or t.type='МОЛОКО';

select t.type from product as p inner join type as t on p.type_id=t.id group by t.type having count(*)<10;

select * from product as p inner join type as t on p.type_id=t.id;