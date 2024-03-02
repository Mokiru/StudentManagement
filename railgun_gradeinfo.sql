create table gradeinfo
(
    id      int auto_increment
        primary key,
    subject varchar(40) null,
    stuid   varchar(40) null,
    grade   int         null
);

INSERT INTO railgun.gradeinfo (id, subject, stuid, grade) VALUES (1, '高等数学', '20212501452', 66);
INSERT INTO railgun.gradeinfo (id, subject, stuid, grade) VALUES (2, '大学英语', '20212501452', 55);
INSERT INTO railgun.gradeinfo (id, subject, stuid, grade) VALUES (3, '高等数学', '20212501455', 99);
INSERT INTO railgun.gradeinfo (id, subject, stuid, grade) VALUES (5, '计算机网络基础', '20212501452', 40);
INSERT INTO railgun.gradeinfo (id, subject, stuid, grade) VALUES (6, '大学英语', '20212501455', 33);
INSERT INTO railgun.gradeinfo (id, subject, stuid, grade) VALUES (7, '计算机网络基础', '20212501455', 60);
INSERT INTO railgun.gradeinfo (id, subject, stuid, grade) VALUES (8, '高等数学', '20212501222', 33);
INSERT INTO railgun.gradeinfo (id, subject, stuid, grade) VALUES (9, '高等数学', '20212501111', 44);
INSERT INTO railgun.gradeinfo (id, subject, stuid, grade) VALUES (10, '大学英语', '20212501222', 44);
INSERT INTO railgun.gradeinfo (id, subject, stuid, grade) VALUES (11, '大学英语', '20212501111', 99);
INSERT INTO railgun.gradeinfo (id, subject, stuid, grade) VALUES (12, '计算机网络基础', '20212501222', 100);
INSERT INTO railgun.gradeinfo (id, subject, stuid, grade) VALUES (13, '计算机网络基础', '20212501111', 49);