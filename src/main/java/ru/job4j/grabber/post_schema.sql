create table post (
    id serial primary key,
    name VARCHAR(250),
    text TEXT,
    link TEXT unique,
    created TIMESTAMP
);
