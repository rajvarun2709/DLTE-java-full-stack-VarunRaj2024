create table transaction_oracle(transaction_id number not null,transaction_date date not null,transaction_to varchar(255) not null,transaction_amount number(10) not null,transaction_remarks varchar(255));

create sequence transaction_sequence start with 2024041 increment by 1;

alter table transaction_oracle add constraint transaction_sequence primary key(transaction_id);

insert into transaction_oracle(transaction_id,transaction_to,transaction_amount,transaction_date,transaction_remarks) values (transaction_seq.nextval,'Arun',1205,'23-Mar-2024','Restaurant');

insert into transaction_oracle(transaction_id,transaction_to,transaction_amount,transaction_date,transaction_remarks) values (transaction_seq.nextval,'Vighnesh',1232,'29-Feb-2024','School fee');

insert into transaction_oracle(transaction_id,transaction_to,transaction_amount,transaction_date,transaction_remarks) values (transaction_seq.nextval,'Hana',8523,'15-Sep-2024','Bus Ticket');

insert into transaction_oracle(transaction_id,transaction_to,transaction_amount,transaction_date,transaction_remarks) values (transaction_seq.nextval,'vishura',2563,'08-Nov-2024','Bus');

insert into transaction_oracle(transaction_id,transaction_to,transaction_amount,transaction_date,transaction_remarks) values (transaction_seq.nextval,'Vinaya',4215,'15-Aug-2024','Bus');

select * from transaction_oracle where transaction_date between '1-Sep-2024' and '30-Dec-2024';

select min(transaction_amount) from transaction_oracle;

select max(transaction_amount) from transaction_oracle;

select count(*)  from transaction_oracle where transaction_to='Vinaya';

select * from transaction_oracle where transaction_remarks='Restaurant';