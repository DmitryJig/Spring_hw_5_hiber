BEGIN;

drop table if exists products cascade;
create table products (id bigserial, title varchar(50), cost double precision, primary key (id));
insert into products (title, cost)
    values
        ('tomato', 50),
        ('potato', 25),
        ('car', 1000000),
        ('tv', 1000);
COMMIT;