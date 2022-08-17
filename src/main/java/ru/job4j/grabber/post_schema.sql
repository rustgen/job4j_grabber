create table post (
    id serial primary key,
    name VARCHAR(100),
    text TEXT,
    link TEXT unique,
    created SMALLDATETIME
);
