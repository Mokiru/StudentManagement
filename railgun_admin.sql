create table admin
(
    id       int auto_increment
        primary key,
    name     varchar(20) null,
    username varchar(40) null,
    password varchar(40) null,
    salt     varchar(12) null
);

INSERT INTO railgun.admin (id, name, username, password, salt) VALUES (1, 'kiruya', 'kiruya', 'f61d7b61f0af8babfe4021d3ae750699295a077d', 'pSZezCrk');