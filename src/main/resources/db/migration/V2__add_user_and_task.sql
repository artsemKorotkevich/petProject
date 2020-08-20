insert into "user" (id,name,email)
    values ('aae82879-f695-4e2c-bdd8-c4ab04c7b94d','test','test@gmail.com');

insert into task (name,status,description,creator_id,executor_id,inspecting_id,start_date_time,end_date_time,creation_date)
    values ('task1','IN_PROGRESS','description1','aae82879-f695-4e2c-bdd8-c4ab04c7b94d','aae82879-f695-4e2c-bdd8-c4ab04c7b94d','aae82879-f695-4e2c-bdd8-c4ab04c7b94d','2020-08-20 05:00:01','2020-08-20 05:00:01','2020-08-20 05:00:01');