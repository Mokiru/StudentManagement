create table stuinfo
(
    id        int auto_increment
        primary key,
    faculties varchar(40) null,
    classn    varchar(20) null,
    stuid     varchar(20) not null,
    stuname   varchar(10) null,
    tel       varchar(20) null
);

INSERT INTO railgun.stuinfo (id, faculties, classn, stuid, stuname, tel) VALUES (2, '软件学院', '软件21-22', '20212501455', 'momochi', '123');
INSERT INTO railgun.stuinfo (id, faculties, classn, stuid, stuname, tel) VALUES (3, '软件学院', '软件21-22', '20212501452', 'kiruya', '1122');
INSERT INTO railgun.stuinfo (id, faculties, classn, stuid, stuname, tel) VALUES (4, '软件学院', '软件21-21', '20212501222', 'kokoro', '111111');
INSERT INTO railgun.stuinfo (id, faculties, classn, stuid, stuname, tel) VALUES (5, '软件学院', '软件21-23', '20212501111', 'momo', '4141414');
INSERT INTO railgun.stuinfo (id, faculties, classn, stuid, stuname, tel) VALUES (6, '计算机与信息技术学院', '计科21-10', '20212221555', 'kazuna', '22');
INSERT INTO railgun.stuinfo (id, faculties, classn, stuid, stuname, tel) VALUES (7, '物理科学与技术学院', '物理21-4', '20211902000', 'kozuki', '1010101');