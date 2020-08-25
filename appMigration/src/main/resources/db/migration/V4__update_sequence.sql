DROP SEQUENCE userSequence_id_seq;
CREATE SEQUENCE userSequence
 START WITH 1001;
ALTER TABLE "user" ALTER id
    SET DEFAULT NEXTVAL('userSequence');

DROP SEQUENCE taskSequence_id_seq;
CREATE SEQUENCE taskSequence
 START WITH 2001;
ALTER TABLE task ALTER id
    SET DEFAULT NEXTVAL('taskSequence');

DROP SEQUENCE commentSequence_id_seq;
CREATE SEQUENCE commentSequence
 START WITH 501;
ALTER TABLE comment ALTER id
    SET DEFAULT NEXTVAL('commentSequence');

DROP SEQUENCE historySequence_id_seq;
CREATE SEQUENCE historySequence
 START WITH 501;
 ALTER TABLE history ALTER id
    SET DEFAULT NEXTVAL('historySequence');


