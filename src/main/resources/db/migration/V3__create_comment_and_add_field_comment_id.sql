create table comment (
id  bigserial not null,
    comment varchar(255),
    parent_comment int8 not null,
    task_id int8,
    "user_id" int8,
     primary key (id));

alter table if exists comment
    add constraint task_id_fk
    foreign key (task_id) references task;

alter table if exists comment
    add constraint user_id_fk
     foreign key ("user_id") references "user";

