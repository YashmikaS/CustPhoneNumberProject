CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;

create table customer (customer_id bigint AUTO_INCREMENT primary key, customer_name varchar(25));
create table phone_number (number varchar(15) not null, customer_id bigint, primary key (number),FOREIGN KEY(customer_id) REFERENCES customer);

insert into customer values (123,'Alex');

insert into phone_number(number,customer_id) values ('0401245678',123);
insert into phone_number(number,customer_id) values ('0412345673',123);
insert into phone_number(number) values ('0445671576');
insert into phone_number(number) values ('0401245677');

