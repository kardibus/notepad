create table note_domain
(
    id    int8 generated by default as identity,
    text  varchar(2048),
    title varchar(255),
    primary key (id)
)