create table userinfo
(
    id       int auto_increment
        primary key,
    stuid    varchar(40) null,
    password varchar(40) null,
    salt     varchar(12) null
);

INSERT INTO railgun.userinfo (id, stuid, password, salt) VALUES (1, '20212501452', '69c948485485e49a48bfa2c303b91acc96bb5d8c', 'icOMPVKm');