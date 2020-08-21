create table  history(
    id  bigserial not null,
    task_id bigserial,
    "creator_id" bigserial,
    "executor_id" bigserial,
    "commentator_id" bigserial,
    creation_date timestamp,
    primary key (id)
);

alter table if exists history
    add constraint task_id_fk
    foreign key (task_id) references task;

alter table if exists history
    add constraint task_creator_fk
    foreign key ("creator_id") references "user";

alter table if exists history
    add constraint task_executor_fk
    foreign key ("executor_id") references "user";

alter table if exists history
    add constraint task_commentator_fk
    foreign key ("commentator_id") references "user";