create table dorminfo
(
    id       int auto_increment
        primary key,
    classn   varchar(20) null,
    stuname  varchar(20) null,
    buildnum int         null,
    dormnum  int         null
);

INSERT INTO railgun.dorminfo (id, classn, stuname, buildnum, dormnum) VALUES (1, '软件21-22', 'kiruya', 4, 528);
INSERT INTO railgun.dorminfo (id, classn, stuname, buildnum, dormnum) VALUES (3, '软件21-22', 'momochi', 4, 528);