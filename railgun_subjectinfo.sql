create table subjectinfo
(
    id   int auto_increment
        primary key,
    name varchar(50) null
);

INSERT INTO railgun.subjectinfo (id, name) VALUES (1, '高等数学');
INSERT INTO railgun.subjectinfo (id, name) VALUES (2, '大学英语');
INSERT INTO railgun.subjectinfo (id, name) VALUES (3, '计算机网络基础');