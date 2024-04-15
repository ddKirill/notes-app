create table notes
(
    id SERIAL not null,
    note_text VARCHAR(1024) not null,
    image_url VARCHAR(256),
    PRIMARY KEY (id)
);

insert into notes(id,note_text,image_url)
values (0,'Create first note with only text', null);


