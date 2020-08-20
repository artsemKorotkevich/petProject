drop table if exists task cascade;

drop table if exists "user" cascade;

create table "user" (
    id uuid not null,
    name varchar(255),
    email varchar(255),
    primary key (id));


create table task (
    id  bigserial not null,
    creation_date timestamp,
    description TEXT,
    end_date_time timestamp,
    name TEXT,
    start_date_time timestamp,
    status varchar(255),
    updated_date timestamp,
    "creator_id" uuid,
    "executor_id" uuid,
    "inspecting_id" uuid,
    primary key (id));

alter table if exists task
    add constraint task_creator_fk
    foreign key ("creator_id") references "user";

alter table if exists task
    add constraint task_executor_fk
    foreign key ("executor_id") references "user";

alter table if exists task
    add constraint task_inspecting_fk
     foreign key ("inspecting_id") references "user";