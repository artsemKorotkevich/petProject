create table "user" (
    id bigserial not null,
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
    "creator_id" bigserial,
    "executor_id" bigserial,
    "inspecting_id" bigserial,
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