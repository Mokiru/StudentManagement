create table falist
(
    id   int auto_increment
        primary key,
    name varchar(40) null
);

INSERT INTO railgun.falist (id, name) VALUES (1, '计算机与信息技术学院');
INSERT INTO railgun.falist (id, name) VALUES (2, '物理科学与技术学院');
INSERT INTO railgun.falist (id, name) VALUES (3, '生命科学与技术学院');
INSERT INTO railgun.falist (id, name) VALUES (4, '软件学院');
INSERT INTO railgun.falist (id, name) VALUES (5, '数学与系统科学学院');
INSERT INTO railgun.falist (id, name) VALUES (6, '历史学院');