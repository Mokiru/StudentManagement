create table classinfo
(
    id          int auto_increment
        primary key,
    faculties   varchar(40) not null,
    classn      varchar(20) not null,
    headteacher varchar(20) null,
    personnum   int         not null
);

INSERT INTO railgun.classinfo (id, faculties, classn, headteacher, personnum) VALUES (2, '软件学院', '21-22软件', 'kokoro', 40);
INSERT INTO railgun.classinfo (id, faculties, classn, headteacher, personnum) VALUES (3, '计算机与信息技术学院', '21-22计科', 'kiruya', 22);